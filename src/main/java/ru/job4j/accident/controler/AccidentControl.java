package ru.job4j.accident.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentHibernate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Controller
public class AccidentControl {

    @Autowired
    private final AccidentHibernate template;

    private int id;

    public AccidentControl(AccidentHibernate template) {

        this.template = template;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", template.getTypes());
        model.addAttribute("rules", template.getRules());
        return "accident/create";
    }

    @PostMapping ("/save")
    public String save(@ModelAttribute Accident accident,
                       @RequestParam("type.id") int typeId,  @RequestParam("rIds") int[] ruls) {
        accident.setAccidentType(template.getType(typeId));
        Set<Rule> rules = new HashSet<>();
        Arrays.stream(ruls).forEach(e -> rules.add(template.getRule(e)));
        accident.setRules(rules);
        accident.setId(id);
        template.save(accident);
        return "redirect:/";
    }

    @GetMapping ("/updateInfo")
    public String update(@RequestParam("empId") int id, Model model) {
        this.id = id;
        model.addAttribute("accident", template.findById(id));
        model.addAttribute("types", template.getTypes());
        model.addAttribute("rules", template.getRules());
        return "accident/edit";
    }
}
