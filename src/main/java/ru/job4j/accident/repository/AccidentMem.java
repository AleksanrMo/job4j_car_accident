package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.*;

@Repository
public class AccidentMem {

    private Map<Integer, Accident> accidentMap = new HashMap<>();

    public boolean save(Accident accident) {
       return accidentMap.putIfAbsent(accident.getId(), accident) == null;
    }

    public boolean update(int id) {
        Accident accident =  findById(id);
        return accidentMap.replace(id, accident) != null;
    }

    public Collection<Accident> findAll() {
        return  accidentMap.values();
    }

    public Accident findById(int id) {
        return accidentMap.get(id);
    }

    public boolean delete(int id) {
        return accidentMap.remove(id) != null;
    }
}
