package ru.job4j.accident.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexControl {
    @GetMapping("/")
    public String index(Model model) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        model.addAttribute("list", list);
        return "index";
    }
}
