package ru.job4j.accident.repository;

import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.*;


public class AccidentMem {

    private Map<Integer, Accident> accidentMap = new HashMap<>();
    private Map<Integer, AccidentType> types = new HashMap<>();
    private Map<Integer, Rule>  rules = new HashMap<>();

    public AccidentMem() {
    }

    public boolean save(Accident accident) {

        return accidentMap.putIfAbsent(accident.getId(), accident) == null;
    }

    public boolean update(int id, Accident accident) {

        return accidentMap.replace(id, accident) != null;
    }

    public Collection<Accident> findAll() {

        return accidentMap.values();
    }

    public Accident findById(int id) {
        return accidentMap.get(id);
    }

    public boolean delete(int id) {

        return accidentMap.remove(id) != null;
    }

    public AccidentType getType(int id) {
        return types.get(id);
    }

    public Collection<AccidentType> getTypes() {
        return types.values();
    }

    public Rule getRule(int id) {
        return rules.get(id);
    }

    public Collection<Rule> getRules() {
        return rules.values();
    }
}
