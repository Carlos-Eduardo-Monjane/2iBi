package com.carlos.api_2ibi_challenge.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.api_2ibi_challenge.model.Country;
import com.carlos.api_2ibi_challenge.repository.CountriesRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CountryController {

  @Autowired
  CountriesRepository countryRepository;

// Ordenamento por qualquer atributo ou propriedade da entidade País
    @GetMapping("/paisesss/{atributo}")
  public ResponseEntity<List<Country>> getAllCountrie( @PathVariable("atributo") String atributo) {

    try {
    
      List<Country> countries = countryRepository.findAll(Sort.by(atributo));

      if (countries.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(countries, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // Listagem de todos Países Cadastrados 
  @GetMapping("/paises")
  public ResponseEntity<List<Country>> getAllCountries(@RequestParam(required = false) String nome) {
    try {
      List<Country> countries = new ArrayList<Country>();

      if (nome == null)
        countryRepository.findAll().forEach(countries::add);
  
      if (countries.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(countries, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // Impressão de País especificado pelo seu identificador
  @GetMapping("/paises/{id}")
  public ResponseEntity<Country> getCountryById(@PathVariable("id") Integer id) {
    Optional<Country> countryData = countryRepository.findById(id);

    if (countryData.isPresent()) {
      return new ResponseEntity<>(countryData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Cadastro de um País
  @PostMapping("/paises")
  public ResponseEntity<Country> createCountry(@RequestBody Country country) {
    try {
        Country _country = countryRepository
          .save(new Country(
              country.getNome(), 
              country.getCapital(), 
              country.getRegiao(), 
              country.getSub_regiao(), 
              country.getArea()));
      return new ResponseEntity<>(_country, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // Edição de propriedades do País
  @PutMapping("/paises/{id}")
  public ResponseEntity<Country> updateCountry(@PathVariable("id") Integer id, @RequestBody Country country) {
    var countryData = countryRepository.findById(id);

    if (countryData.isPresent()) {
      var _country = countryData.get();
      _country.setNome(country.getNome());
      _country.setCapital(country.getCapital());
      _country.setRegiao(country.getRegiao());
      _country.setSub_regiao(country.getSub_regiao());
      _country.setArea(country.getArea());
      return new ResponseEntity<>(countryRepository.save(_country), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
// Eliminação de um País especificado pelo seu identificador
  @DeleteMapping("/paises/{id}")
  public ResponseEntity<HttpStatus> deleteCountry(@PathVariable("id") Integer id) {
    try {
        countryRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // Eliminação de todos Países previamente cadastrados
  @DeleteMapping("/paises")
  public ResponseEntity<HttpStatus> deleteAllCountries() {
    try {
        countryRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }



}