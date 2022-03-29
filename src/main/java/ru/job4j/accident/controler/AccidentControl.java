package ru.job4j.accident.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.service.AccidentService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AccidentControl {

    @Autowired
    private final AccidentService service;

    public AccidentControl(AccidentService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", listOfTypes());
        return "accident/create";
    }

    @PostMapping ("/save")
    public String save(@ModelAttribute Accident accident) {
        service.save(accident);
        return "redirect:/";
    }

    @GetMapping ("/updateInfo")
    public String update(@RequestParam("empId") int id, Model model) {
        model.addAttribute("accident", service.findById(id));
        model.addAttribute("types", listOfTypes());
        return "accident/edit";
    }

    @PostMapping ("/update")
    public String update2(Accident accident) {
        service.update(accident.getId(), accident);
        return "redirect:/";
    }


    public List<AccidentType> listOfTypes() {
        List<AccidentType> types = new ArrayList<>();
        types.add(AccidentType.of(1, "Две машины"));
        types.add(AccidentType.of(2, "Машина и человек"));
        types.add(AccidentType.of(3, "Машина и велосипед"));
        return types;
    }
}
