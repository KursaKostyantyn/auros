package auros.test.service;

import auros.test.models.KnowledgePackage;

import java.util.List;

public interface KnowledgePackageService {
    void saveKnowledgePackage(KnowledgePackage knowledgePackage);

    List<KnowledgePackage> findAll();

    void deleteKnowledgePackageById(int id);
}
