package ru.job4j.accident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.accident.model.Accident;


public interface AccidentRepository extends JpaRepository<Accident, Integer> {

}
