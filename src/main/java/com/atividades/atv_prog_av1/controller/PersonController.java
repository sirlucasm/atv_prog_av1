package com.atividades.atv_prog_av1.controller;

import com.atividades.atv_prog_av1.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PersonController {
    @GetMapping
    public List<Person> index() {
        return ;
    }
}
