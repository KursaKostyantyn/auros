package auros.test.mapper;

import auros.test.models.KnowledgePackage;
import auros.test.models.KnowledgePackageSet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KnowledgePackageMapper implements RowMapper<KnowledgePackage> {
    @Override
    public KnowledgePackage mapRow(ResultSet resultSet, int i) throws SQLException {
        KnowledgePackage knowledgePackage = new KnowledgePackage();
        knowledgePackage.setTitle(resultSet.getString("title"));
        knowledgePackage.setId(resultSet.getInt("id"));
        knowledgePackage.setDescription(resultSet.getString("description"));
        knowledgePackage.setCreationDate(resultSet.getString("creation_date"));
        return knowledgePackage;
    }
}
