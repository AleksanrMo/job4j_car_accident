package ru.job4j.accident.controler;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.AccidentTypeRepository;
import ru.job4j.accident.repository.RuleRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Controller
public class AccidentControl {

    private final AccidentTypeRepository template;
    private final AccidentRepository repository;
    private final RuleRepository ruleRepository;


    public AccidentControl(AccidentTypeRepository template, AccidentRepository repository, RuleRepository ruleRepository) {
        this.template = template;
        this.repository = repository;
        this.ruleRepository = ruleRepository;
    }

    private int id;



    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", template.findAll());
        model.addAttribute("rules", ruleRepository.findAll());
        return "accident/create";
    }

    @PostMapping ("/save")
    public String save(@ModelAttribute Accident accident,
                       @RequestParam("type.id") int typeId,  @RequestParam("rIds") int[] ruls) {
        accident.setAccidentType(template.findById(typeId).get());
        Set<Rule> rules = new HashSet<>();
        Arrays.stream(ruls).forEach(e -> rules.add(ruleRepository.findById(e).get()));
        accident.setRules(rules);
        accident.setId(id);
        repository.save(accident);
        return "redirect:/";
    }

    @GetMapping ("/updateInfo")
    public String update(@RequestParam("empId") int id, Model model) {
        this.id = id;
        model.addAttribute("accident", repository.findById(id).get());
        model.addAttribute("types", template.findAll());
        model.addAttribute("rules", ruleRepository.findAll());
        return "accident/edit";
    }
}
