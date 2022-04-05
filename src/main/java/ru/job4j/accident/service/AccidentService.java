package ru.job4j.accident.service;

import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;


public interface AccidentService {


    Accident save(Accident accident);

    List<Accident> getAll();

    List<AccidentType> getTypes();

    AccidentType getType(int id);

    Rule getRule(int id);

    List<Rule> getRules();

    Accident findById(int id);

}
