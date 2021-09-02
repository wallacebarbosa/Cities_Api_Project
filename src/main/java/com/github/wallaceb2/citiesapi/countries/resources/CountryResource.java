package com.github.wallaceb2.citiesapi.countries.resources;

import com.github.wallaceb2.citiesapi.countries.entities.Country;
import com.github.wallaceb2.citiesapi.countries.repositories.CountryRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryResource {

  private final CountryRepository repository;

  public CountryResource(final CountryRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/countries")
  public Page<Country> countries(Pageable page) {

    return repository.findAll(page);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Country> getOne(@PathVariable Long id) {

    Optional<Country> optional = repository.findById(id);

    if(optional.isPresent()) {
      return ResponseEntity.ok().body(optional.get());
    } else {

      return ResponseEntity.notFound().build();
    }

  }
}
