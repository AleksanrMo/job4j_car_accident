package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.*;

@Repository
public class AccidentMem {

    private Map<Integer, Accident> accidentMap = new HashMap<>();
    private Map<Integer, AccidentType> types = new HashMap<>();

    public AccidentMem() {
        save(new Accident(1, "accident", "some text", "address", new AccidentType()));
        save(new Accident(2, "accident2", "some text2", "address2", new AccidentType()));
        save(new Accident(3, "accident3", "some text3", "address3", new AccidentType()));
        types.put(1, AccidentType.of(1, "Две машины"));
        types.put(2, AccidentType.of(2, "Машина и человек"));
        types.put(3, AccidentType.of(3, "Машина и велосипед"));
    }

    public boolean save(Accident accident) {

        return accidentMap.putIfAbsent(accident.getId(), accident) == null;
    }

    public boolean update(int id, Accident accident) {

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

    public AccidentType getType(int id) {
        return types.get(id);
    }
    public Collection<AccidentType> getTypes() {
        return types.values();
    }
}
