package auros.test.dao;

import auros.test.models.KnowledgePackage;
import auros.test.models.KnowledgePackageSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnowledgePackageDAOImpl implements KnowledgePackageDAO {
    public final JdbcTemplate jdbcTemplate;


    @Autowired
    public KnowledgePackageDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<KnowledgePackage> findAll() {
        String sql = "SELECT * FROM knowledge_package " +
                "left join knowledge_package_knowledge_package_set kpkps on knowledge_package.id = kpkps.kPac_id  " +
                "left join knowledge_package_set kps on kpkps.kPacSet_id = kps.id " +
                "ORDER BY kPac_id";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<KnowledgePackage>>() {
            @Override
            public List<KnowledgePackage> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Map<Integer, KnowledgePackage> knowledgePackageById = new HashMap<>();
                while (resultSet.next()) {
                    KnowledgePackageSet knowledgePackageSet = new KnowledgePackageSet(resultSet.getInt("kps.id"), resultSet.getString("kps.title"));
                    String title = resultSet.getString("title");
                    int id = resultSet.getInt("id");
                    String description = resultSet.getString("description");
                    String creationDate = resultSet.getString("creation_date");

                    KnowledgePackage knowledgePackage = knowledgePackageById.get(resultSet.getInt("id"));
                    if (knowledgePackage == null) {
                        knowledgePackage = new KnowledgePackage(id, title, description, creationDate);
                        knowledgePackageById.put(knowledgePackage.getId(), knowledgePackage);
                    }
                    if (knowledgePackageSet.getId() != 0) {
                        knowledgePackage.getKnowledgePackageSets().add(knowledgePackageSet);

                    }
                }
                return new ArrayList<>(knowledgePackageById.values());
            }
        });
    }

    @Override
    public void saveKnowledgePackage(KnowledgePackage knowledgePackage) {
        String sql = "INSERT INTO knowledge_package (title,description, creation_date) VALUES (?,?,?)";
        String creationDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date(System.currentTimeMillis()));
        jdbcTemplate.update(sql, knowledgePackage.getTitle(), knowledgePackage.getDescription(), creationDate);
    }


    @Override
    public void deleteKnowledgePackageById(int id) {
        String sql = "DELETE FROM knowledge_package WHERE id=? ";
        jdbcTemplate.update(sql, id);
    }
}
