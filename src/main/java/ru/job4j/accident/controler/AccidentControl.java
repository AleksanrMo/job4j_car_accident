package ru.job4j.accident.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentJdbcTemplate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class AccidentControl {

    @Autowired
    private final AccidentJdbcTemplate template;
    private int id;

    public AccidentControl(AccidentJdbcTemplate template) {

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
                       @RequestParam("type.id") int typeId, @RequestParam("rIds") int[] ruls) {
        accident.setAccidentType(template.getType(typeId));
        template.save(accident);
        List<Accident> accidentList = template.getAll();
        Accident accident1 = accidentList.get(accidentList.size() - 1);
        Arrays.stream(ruls).forEach(e -> template.addIntoAccidentsRules(e, accident1.getId()));
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

    @SuppressWarnings("checkstyle:ArrayTypeStyle")
    @PostMapping ("/update")
    public String update2(Accident accident, @RequestParam("type.id") int idType,
                          @RequestParam("rIds") int[] ids) {
        accident.setAccidentType(template.getType(idType));
        template.update(id, accident);
        Arrays.stream(ids).forEach(e -> template.addIntoAccidentsRules(e, id));

        return "redirect:/";
    }

}
