package com.atividades.atv_prog_av1.controller;

import com.atividades.atv_prog_av1.model.Person;
import com.atividades.atv_prog_av1.repository.PersonRepository;

// responses
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

// requests
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "http://localhost:3000")
public class PersonController {

    @Autowired
    private PersonRepository _personRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Person> index() {
        return _personRepository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Person body) {
        Person person = _personRepository.save(body);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Object edit(@RequestBody Person personUpdate) {
        Optional<Person> person = _personRepository.findById(personUpdate.getId());

        if (person.isPresent()) {
            _personRepository.save(personUpdate);
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Person> person = _personRepository.findById(id);

        if (person.isPresent()) {
            _personRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object show(@PathVariable Long id) {
        Optional<Person> person = _personRepository.findById(id);
        if (person.isPresent()) return new ResponseEntity<>(person.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
