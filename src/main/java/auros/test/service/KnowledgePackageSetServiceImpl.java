package auros.test.service;

import auros.test.dao.KnowledgePackageSetDAO;
import auros.test.models.KnowledgePackageSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgePackageSetServiceImpl implements KnowledgePackageSetService {


    private final KnowledgePackageSetDAO knowledgePackageSetDAO;
    @Autowired
    public KnowledgePackageSetServiceImpl(KnowledgePackageSetDAO knowledgePackageSetDAO) {
        this.knowledgePackageSetDAO = knowledgePackageSetDAO;
    }

    @Override
    public void saveKnowledgePackageSet(KnowledgePackageSet knowledgePackageSet, String[] ids) {
        int lastId = knowledgePackageSetDAO.saveKnowledgePackageSet(knowledgePackageSet);
        if (ids != null && ids.length != 0) {
            for (String id : ids) {
                knowledgePackageSetDAO.addKPacToKPacSet(Integer.parseInt(id), lastId);
            }
        }
    }

    @Override
    public List<KnowledgePackageSet> findAll() {
        return knowledgePackageSetDAO.findAll();
    }

    @Override
    public void deleteKnowledgePackageSetById(int id) {
        knowledgePackageSetDAO.deleteKnowledgePackageSetById(id);
    }

    @Override
    public KnowledgePackageSet findKnowledgePackageSetById(int id) {
        return knowledgePackageSetDAO.findKnowledgePackageSetById(id);
    }
}
