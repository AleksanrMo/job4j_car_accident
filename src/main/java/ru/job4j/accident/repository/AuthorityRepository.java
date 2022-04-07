package ru.job4j.accident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.accident.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    Authority findByAuthority(String role);
}
