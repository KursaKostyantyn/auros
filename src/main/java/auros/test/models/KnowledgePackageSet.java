package auros.test.models;

import java.util.ArrayList;
import java.util.List;

public class KnowledgePackageSet {
    private int id;
    private String title;
    private List<KnowledgePackage> knowledgePackages = new ArrayList<>();

    public KnowledgePackageSet(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public KnowledgePackageSet() {
    }

    @Override
    public String toString() {
        return "KnowledgePackageSet{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", knowledgePackages=" + knowledgePackages +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<KnowledgePackage> getKnowledgePackages() {
        return knowledgePackages;
    }

    public void setKnowledgePackages(List<KnowledgePackage> knowledgePackages) {
        this.knowledgePackages = knowledgePackages;
    }
}
