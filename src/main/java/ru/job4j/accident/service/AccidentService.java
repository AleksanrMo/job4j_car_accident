package ru.job4j.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Collection;

@Service
public class AccidentService {

    @Autowired
    private AccidentMem accidentMem;

    public boolean save(Accident accident) {
        return accidentMem.save(accident);
    }

    public boolean update(int id) {
        return accidentMem.update(id);
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
}
