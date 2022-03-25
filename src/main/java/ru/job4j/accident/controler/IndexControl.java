package ru.job4j.accident.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;


@Controller
public class IndexControl {

    @Autowired
    AccidentService service;

    @GetMapping("/")
    public String index(Model model) {

        Accident accident1 = new Accident(1, "accident", "some text", "address");
        Accident accident2 = new Accident(2, "accident2", "some text2", "address2");
        service.save(accident1);
        service.save(accident2);
        model.addAttribute("list", service.findAll());
        return "index";
    }
}
