package com.atividades.atv_prog_av1.repository;

import com.atividades.atv_prog_av1.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}