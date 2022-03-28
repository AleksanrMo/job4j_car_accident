package ru.job4j.accident.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;


@Controller
public class AccidentControl {

    @Autowired
    private final AccidentMem accidentMem;

    public AccidentControl(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("list", accidentMem.findAll());
        return "index";
    }
    @RequestMapping("/create")
    public String create(Model model) {
        Accident accident = new Accident();
        model.addAttribute("accident", accident);
        return "accident/create";
    }

    @RequestMapping ("/save")
    public String save(@ModelAttribute Accident accident) {
        accidentMem.save(accident);
        return "redirect:/";
    }

    @RequestMapping ("/updateInfo")
    public String update(Model model) {
        Accident accident = new Accident();
        model.addAttribute("update", accident);
        return "accident/edit";
    }

    @RequestMapping ("/update2")
    public String update2(@ModelAttribute Accident accident) {
        accidentMem.update(accident.getId(), accident);
        return "redirect:/";
    }
}
