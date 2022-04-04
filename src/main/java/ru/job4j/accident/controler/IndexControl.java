package ru.job4j.accident.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.repository.AccidentRepository;



@Controller
public class IndexControl {


    private final AccidentRepository service;

    public IndexControl(AccidentRepository service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("list", service.findAll());
        return "index";
    }
}
