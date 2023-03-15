package auros.test.controller;

import auros.test.models.KnowledgePackageSet;
import auros.test.service.KnowledgePackageService;
import auros.test.service.KnowledgePackageSetService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class KnowledgePackageSetController {

    private final KnowledgePackageSetService knowledgePackageSetService;

    private final KnowledgePackageService knowledgePackageService;

    @Autowired
    public KnowledgePackageSetController(KnowledgePackageSetService knowledgePackageSetService, KnowledgePackageService knowledgePackageService) {
        this.knowledgePackageSetService = knowledgePackageSetService;
        this.knowledgePackageService = knowledgePackageService;
    }

    @GetMapping("/sets")
    public String findAllKnowledgePackageSet(Model model) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            model.addAttribute("knowledgePackages", knowledgePackageService.findAll());
            model.addAttribute("knowledgePackageSets", mapper.writeValueAsString(knowledgePackageSetService.findAll()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "sets";
    }

    @PostMapping("/addKnowledgePackage_set")
    public String addKnowledgePackageSet(@ModelAttribute("knowledgePackageSet") KnowledgePackageSet knowledgePackageSet, @RequestParam(name = "ids", required = false) String[] ids) {
        knowledgePackageSetService.saveKnowledgePackageSet(knowledgePackageSet, ids);
        return "redirect:/sets";
    }

    @GetMapping("/deleteKnowledgePackage_set/{id}")
    public String deleteKnowledgePackageSetById(@PathVariable int id) {
        knowledgePackageSetService.deleteKnowledgePackageSetById(id);
        return "redirect:/sets";
    }

    @GetMapping("set/{id}")
    public String findKnowledgePackageSetById(@PathVariable int id, Model model) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            model.addAttribute("knowledgePackageSet",
                    mapper.writeValueAsString(knowledgePackageSetService.findKnowledgePackageSetById(id).getKnowledgePackages()));

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "set";
    }


}
