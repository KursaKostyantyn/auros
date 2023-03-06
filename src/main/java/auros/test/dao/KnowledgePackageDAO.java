package auros.test.dao;

import auros.test.models.KnowledgePackage;

import java.util.List;

public interface KnowledgePackageDAO {

    void saveKnowledgePackage(KnowledgePackage knowledgePackage);

    List<KnowledgePackage> findAll();

    void deleteKnowledgePackageById(int id);

}
