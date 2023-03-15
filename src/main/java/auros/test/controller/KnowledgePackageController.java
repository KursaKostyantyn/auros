package auros.test.controller;

import auros.test.models.KnowledgePackage;
import auros.test.service.KnowledgePackageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class KnowledgePackageController {


    private final KnowledgePackageService knowledgePackageService;

    @Autowired
    public KnowledgePackageController(KnowledgePackageService knowledgePackageService) {
        this.knowledgePackageService = knowledgePackageService;
    }

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/kpacs")
    public String findAllKnowledgePackages(Model model) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            model.addAttribute("knowledgePackages", mapper.writeValueAsString(knowledgePackageService.findAll()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "kpacs";
    }

    @PostMapping("/addKnowledgePackage")
    public String addKnowledgePackages(@ModelAttribute("knowledgePackage") KnowledgePackage knowledgePackage) {
        knowledgePackageService.saveKnowledgePackage(knowledgePackage);
        return "redirect:/kpacs";
    }

    @GetMapping("/deleteKnowledgePackage/{id}")
    public String deleteKnowledgePackageById(@PathVariable int id) {
        knowledgePackageService.deleteKnowledgePackageById(id);
        return "redirect:/kpacs";
    }

}


