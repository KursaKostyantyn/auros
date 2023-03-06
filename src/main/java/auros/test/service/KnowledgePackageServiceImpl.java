package auros.test.service;

import auros.test.models.KnowledgePackage;
import auros.test.dao.KnowledgePackageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgePackageServiceImpl implements KnowledgePackageService {
    @Autowired
    public KnowledgePackageDAO knowledgePackageDAO;

    @Override
    public void saveKnowledgePackage(KnowledgePackage knowledgePackage) {
        knowledgePackageDAO.saveKnowledgePackage(knowledgePackage);
    }

    @Override
    public List<KnowledgePackage> findAll() {
        return knowledgePackageDAO.findAll();
    }

    @Override
    public void deleteKnowledgePackageById(int id) {
        knowledgePackageDAO.deleteKnowledgePackageById(id);
    }
}
