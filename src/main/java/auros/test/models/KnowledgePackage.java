package auros.test.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class KnowledgePackage {
    private int id;
    private String title;
    private String description;
    private String creationDate;
    private List<KnowledgePackageSet> knowledgePackageSets = new ArrayList<>();

    public KnowledgePackage() {
    }

    public KnowledgePackage(int id, String title, String description, String creationDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "KnowledgePackage{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", knowledgePackageSets=" + knowledgePackageSets +
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public List<KnowledgePackageSet> getKnowledgePackageSets() {
        return knowledgePackageSets;
    }

    public void setKnowledgePackageSets(List<KnowledgePackageSet> knowledgePackageSets) {
        this.knowledgePackageSets = knowledgePackageSets;
    }
}
