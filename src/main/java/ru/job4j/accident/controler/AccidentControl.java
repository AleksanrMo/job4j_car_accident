package ru.job4j.accident.controler;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.service.AccidentServiceImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Controller
public class AccidentControl {

   AccidentServiceImpl accidentService;

    public AccidentControl(AccidentServiceImpl accidentService) {
        this.accidentService = accidentService;
    }

    private int id;



    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", accidentService.getTypes());
        model.addAttribute("rules", accidentService.getRules());
        return "accident/create";
    }

    @PostMapping ("/save")
    public String save(@ModelAttribute Accident accident,
                       @RequestParam("type.id") int typeId,  @RequestParam("rIds") int[] ruls) {
        accident.setAccidentType(accidentService.getType(typeId));
        Set<Rule> rules = new HashSet<>();
        Arrays.stream(ruls).forEach(e -> rules.add(accidentService.getRule(e)));
        accident.setRules(rules);
        accident.setId(id);
        accidentService.save(accident);
        return "redirect:/";
    }

    @GetMapping ("/updateInfo")
    public String update(@RequestParam("empId") int id, Model model) {
        this.id = id;
        model.addAttribute("accident", accidentService.findById(id));
        model.addAttribute("types", accidentService.getTypes());
        model.addAttribute("rules", accidentService.getRules());
        return "accident/edit";
    }
}
