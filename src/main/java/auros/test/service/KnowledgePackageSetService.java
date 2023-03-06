package auros.test.service;

import auros.test.models.KnowledgePackage;
import auros.test.models.KnowledgePackageSet;

import java.util.List;

public interface KnowledgePackageSetService {
    void saveKnowledgePackageSet(KnowledgePackageSet knowledgePackageSet, String[] ids);

    List<KnowledgePackageSet> findAll();

    void deleteKnowledgePackageSetById(int id);

    public KnowledgePackageSet findKnowledgePackageSetById(int id);

}
