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

    @Autowired
    public KnowledgePackageSetService knowledgePackageSetService;
    @Autowired
    public KnowledgePackageService knowledgePackageService;

    @GetMapping("/sets")
    public String findAllKnowledgePackageSet(Model model) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        model.addAttribute("knowledgePackages", knowledgePackageService.findAll());
        model.addAttribute("knowledgePackageSets", mapper.writeValueAsString(knowledgePackageSetService.findAll()));
        return "sets";
    }

    @PostMapping("/add_knowledge_package_set")
    public String addKnowledgePackageSet(@ModelAttribute("knowledgePackageSet") KnowledgePackageSet knowledgePackageSet, @RequestParam(name = "ids", required = false) String[] ids) {
        knowledgePackageSetService.saveKnowledgePackageSet(knowledgePackageSet, ids);
        return "redirect:/sets";
    }

    @GetMapping("/delete_knowledge_package_set/{id}")
    public String deleteKnowledgePackageSetById(@PathVariable int id) {
        knowledgePackageSetService.deleteKnowledgePackageSetById(id);
        return "redirect:/sets";
    }

    @GetMapping("set/{id}")
    public String findKnowledgePackageSetById(@PathVariable int id, Model model) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        model.addAttribute("knowledgePackageSet",
                mapper.writeValueAsString(knowledgePackageSetService.findKnowledgePackageSetById(id).getKnowledgePackages()));
        return "set";
    }


}
