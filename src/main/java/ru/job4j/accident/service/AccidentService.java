package ru.job4j.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Collection;

@Service
public class AccidentService {

    @Autowired
    private AccidentMem accidentMem;

    public boolean save(Accident accident) {
        return accidentMem.save(accident);
    }

    public boolean update(int id, Accident accident) {
        return accidentMem.update(id, accident);
    }

    public Collection<Accident> findAll() {
        return  accidentMem.findAll();
    }

    public Accident findById(int id) {
        return accidentMem.findById(id);
    }

    public boolean delete(int id) {
        return accidentMem.delete(id);
    }

    public AccidentType getType(int id) {
        return accidentMem.getType(id);
    }
    public Collection<AccidentType> getTypes() {
        return accidentMem.getTypes();
    }

    public Rule getRule(int id) {
        return accidentMem.getRule(id);
    }

    public Collection<Rule> getRules() {
        return accidentMem.getRules();
    }
}
