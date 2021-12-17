package BSWeb.controllers;

import BSWeb.models.Post;
import BSWeb.models.SEC;
import BSWeb.models.Achievments;
import BSWeb.repo.SECAchievmentsRepository;
import BSWeb.repo.SECRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
@RequestMapping("/scientific-and-educational-centers")
public class SECController {

    @Autowired
    private SECRepository secRepository;
    @Autowired
    private SECAchievmentsRepository achRepository;

    @GetMapping("")
    public String sec(Model model) {
        Iterable<SEC> sec = secRepository.findAll();
        model.addAttribute("sec", sec);
        model.addAttribute("title", "Научно-образовательные центры");

        return "secPage";
    }

    @GetMapping("/ТИОС")
    public String secAbout1(Model model) {
        Long id = 1L;
        Iterable<SEC> sec = secRepository.findAllById(Collections.singleton(id));
        Iterable<Achievments> ach = achRepository.findAllById(Collections.singleton(id));
        model.addAttribute("sec", sec);
        model.addAttribute("title", "ТИОС");
        model.addAttribute("ach", ach);

        return "secAboutPage";
    }

    @GetMapping("/БИС")
    public String secAbout2(Model model) {
        Long id = 2L;
        Iterable<SEC> sec = secRepository.findAllById(Collections.singleton(id));
        Iterable<Achievments> ach = achRepository.findAllById(Collections.singleton(id));
        model.addAttribute("sec", sec);
        model.addAttribute("title", "БИС");
        model.addAttribute("ach", ach);

        return "secAboutPage";
    }

    @PostMapping("")
    public String addNews(@RequestParam("title") String title,
                          @RequestParam("full_name") String full_name,
                          @RequestParam("description") String description,
                          Model model) {
        SEC sec = new SEC(title, full_name, description);
        secRepository.save(sec);
        return "redirect:/scientific-and-educational-centers";
    }

    @PostMapping("/edit")
    public String editNews(@RequestParam("id") Long id,
                           @RequestParam("title") String title,
                           @RequestParam("full_name") String full_name,
                           @RequestParam("description") String description,
                           Model model){
        if(secRepository.existsById(id)) {
            SEC sec = new SEC(id, title, full_name, description);
            secRepository.save(sec);

        }
        return "redirect:/scientific-and-educational-centers";
    }

    @PostMapping("/delete")
    public String deleteNews(@RequestParam("id") Long id,
                             Model model){
        if(secRepository.existsById(id)) {
            secRepository.deleteById(id);
        }
        return "redirect:/scientific-and-educational-centers";
    }
}
