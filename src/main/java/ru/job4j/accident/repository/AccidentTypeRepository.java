package ru.job4j.accident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.accident.model.AccidentType;

public interface AccidentTypeRepository extends JpaRepository<AccidentType, Integer> {
}
