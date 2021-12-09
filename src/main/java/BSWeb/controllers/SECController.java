package BSWeb.controllers;

import BSWeb.models.SEC;
import BSWeb.models.Achievments;
import BSWeb.repo.SECAchievmentsRepository;
import BSWeb.repo.SECRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;

@Controller
public class SECController {

    @Autowired
    private SECRepository secRepository;
    @Autowired
    private SECAchievmentsRepository achRepository;

    @GetMapping(value = "/scientific-and-educational-centers")
    public String sec(Model model) {
        Iterable<SEC> sec = secRepository.findAll();
        model.addAttribute("sec", sec);
        model.addAttribute("title", "Научно-образовательные центры");

        return "secPage";
    }

    @GetMapping(value = "/scientific-and-educational-centers/ТИОС")
    public String secAbout1(Model model) {
        Long id = 1L;
        Iterable<SEC> sec = secRepository.findAllById(Collections.singleton(id));
        Iterable<Achievments> ach = achRepository.findAllById(Collections.singleton(id));
        model.addAttribute("sec", sec);
        model.addAttribute("title", "ТИОС");
        model.addAttribute("ach", ach);

        return "secAboutPage";
    }

    @GetMapping(value = "/scientific-and-educational-centers/БИС")
    public String secAbout2(Model model) {
        Long id = 2L;
        Iterable<SEC> sec = secRepository.findAllById(Collections.singleton(id));
        Iterable<Achievments> ach = achRepository.findAllById(Collections.singleton(id));
        model.addAttribute("sec", sec);
        model.addAttribute("title", "БИС");
        model.addAttribute("ach", ach);

        return "secAboutPage";
    }
}
