package ru.job4j.accident.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.repository.AccidentHibernate;
import ru.job4j.accident.repository.AccidentJdbcTemplate;
import ru.job4j.accident.service.AccidentService;


@Controller
public class IndexControl {

    @Autowired
    private AccidentHibernate service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("list", service.getAll());
        return "index";
    }
}
