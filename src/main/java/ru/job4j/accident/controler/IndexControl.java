package ru.job4j.accident.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.service.AccidentServiceImpl;

@Controller
public class IndexControl {

    private final AccidentServiceImpl service;

    public IndexControl(AccidentServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("list", service.getAll());
        return "index";
    }
}
