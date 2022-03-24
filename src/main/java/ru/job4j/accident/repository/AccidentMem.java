package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Map;

@Repository
public class AccidentMem {
    private Map<Integer, Accident> accidentMap;
}
