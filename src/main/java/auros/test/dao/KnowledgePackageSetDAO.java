package auros.test.dao;

import auros.test.models.KnowledgePackageSet;

import java.util.List;

public interface KnowledgePackageSetDAO {
    int saveKnowledgePackageSet(KnowledgePackageSet knowledgePackageSet);

    List<KnowledgePackageSet> findAll();

    void deleteKnowledgePackageSetById(int id);

    void addKPacToKPacSet(int kPacId, int kPacSetId);

    KnowledgePackageSet findKnowledgePackageSetById(int id);


}
