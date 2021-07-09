package com.testesondaapplication.testesondaapplication.repo;

import com.testesondaapplication.testesondaapplication.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Airplanerepo extends JpaRepository<Airplane, Long> {
    void deleteAirplaneById(Long id);
    Optional<Airplane> findAirplaneById(Long id);
}
