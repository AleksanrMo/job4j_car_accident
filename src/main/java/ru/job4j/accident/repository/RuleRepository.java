package ru.job4j.accident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.accident.model.Rule;

public interface RuleRepository extends JpaRepository<Rule, Integer> {
}
