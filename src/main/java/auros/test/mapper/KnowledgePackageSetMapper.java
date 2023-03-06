package auros.test.mapper;

import auros.test.models.KnowledgePackageSet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KnowledgePackageSetMapper implements RowMapper<KnowledgePackageSet> {

    @Override
    public KnowledgePackageSet mapRow(ResultSet resultSet, int i) throws SQLException {
        KnowledgePackageSet knowledgePackageSet = new KnowledgePackageSet();
        knowledgePackageSet.setId(resultSet.getInt("id"));
        knowledgePackageSet.setTitle(resultSet.getString("title"));
        return knowledgePackageSet;
    }
}
