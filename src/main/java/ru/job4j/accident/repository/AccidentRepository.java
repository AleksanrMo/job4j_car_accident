package ru.job4j.accident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.job4j.accident.model.Accident;

import java.util.List;


public interface AccidentRepository extends JpaRepository<Accident, Integer> {
   @Query("select distinct c from Accident c left join fetch c.rules")
   List<Accident> findAll();
}
