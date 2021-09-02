package com.github.wallaceb2.citiesapi.staties.repositories;

import com.github.wallaceb2.citiesapi.staties.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
