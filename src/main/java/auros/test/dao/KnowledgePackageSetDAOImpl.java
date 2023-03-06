package auros.test.dao;

import auros.test.mapper.KnowledgePackageSetMapper;
import auros.test.models.KnowledgePackage;
import auros.test.models.KnowledgePackageSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnowledgePackageSetDAOImpl implements KnowledgePackageSetDAO {
    public final JdbcTemplate jdbcTemplate;

    @Override
    public KnowledgePackageSet findKnowledgePackageSetById(int id) {
        String sql = "SELECT * FROM knowledge_package_set " +
                "LEFT JOIN knowledge_package_knowledge_package_set kpkps on knowledge_package_set.id = kpkps.kPacSet_id " +
                "LEFT JOIN knowledge_package kp on kp.id = kpkps.kPac_id " +
                "WHERE knowledge_package_set.id=?;";

        return jdbcTemplate.query(sql, new ResultSetExtractor<KnowledgePackageSet>() {
            @Override
            public KnowledgePackageSet extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                return getKnowledgePackageSetList(resultSet).get(0);
            }
        }, id);
    }

    @Autowired
    public KnowledgePackageSetDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int saveKnowledgePackageSet(KnowledgePackageSet knowledgePackageSet) {
        String sql = "INSERT INTO knowledge_package_set (title) VALUES (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, knowledgePackageSet.getTitle());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void addKPacToKPacSet(int kPacId, int kPacSetId) {
        String sql = "INSERT INTO knowledge_package_knowledge_package_set (kPac_id, kPacSet_id) VALUES (?,?);";
        jdbcTemplate.update(sql, kPacId, kPacSetId);
    }

    @Override
    public List<KnowledgePackageSet> findAll() {
        String sql = "SELECT * FROM knowledge_package_set";
        return jdbcTemplate.query(sql, new KnowledgePackageSetMapper());
    }

    private List<KnowledgePackageSet> getKnowledgePackageSetList(ResultSet resultSet) throws SQLException {
        Map<Integer, KnowledgePackageSet> knowledgePackageSetById = new HashMap<>();
        while (resultSet.next()) {
            KnowledgePackage knowledgePackage = new KnowledgePackage(
                    resultSet.getInt("kp.id"),
                    resultSet.getString("kp.title"),
                    resultSet.getString("description"),
                    resultSet.getString("creation_date"));

            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            KnowledgePackageSet knowledgePackageSet = knowledgePackageSetById.get(resultSet.getInt("id"));
            if (knowledgePackageSet == null) {
                knowledgePackageSet = new KnowledgePackageSet(id, title);
                knowledgePackageSetById.put(knowledgePackageSet.getId(), knowledgePackageSet);
            }
            if (knowledgePackage.getId() != 0) {
                knowledgePackageSet.getKnowledgePackages().add(knowledgePackage);
            }

        }

        return new ArrayList<>(knowledgePackageSetById.values());
    }


    @Override
    public void deleteKnowledgePackageSetById(int id) {
        String sql = "DELETE FROM knowledge_package_set WHERE id=?";
        jdbcTemplate.update(sql, id);
    }


}
