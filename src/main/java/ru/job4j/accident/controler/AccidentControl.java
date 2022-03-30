package ru.job4j.accident.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.service.AccidentService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Controller
public class AccidentControl {

    @Autowired
    private final AccidentService service;

    public AccidentControl(AccidentService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", service.getTypes());
        model.addAttribute("rules", service.getRules());
        return "accident/create";
    }

    @PostMapping ("/save")
    public String save(@ModelAttribute Accident accident, @RequestParam("rIds") int[] ruleId,
                       @RequestParam("type.id") int typeId) {
        Set<Rule> rules = new HashSet<>();
        Arrays.stream(ruleId).forEach(e -> rules.add(service.getRule(e)));
        accident.setRules(rules);
        accident.setAccidentType(service.getType(typeId));
        service.save(accident);
        return "redirect:/";
    }

    @GetMapping ("/updateInfo")
    public String update(@RequestParam("empId") int id, Model model) {
        model.addAttribute("accident", service.findById(id));
        model.addAttribute("types", service.getTypes());
        return "accident/edit";
    }

    @PostMapping ("/update")
    public String update2(Accident accident) {
        service.update(accident.getId(), accident);
        return "redirect:/";
    }
}
