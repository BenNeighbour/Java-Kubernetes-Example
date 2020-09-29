package com.benneighbour.javakubernetes.serverexample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ben Neighbour
 * @created 25/09/2020
 * @project CloneBnb
 */
@RestController
@RequestMapping("/people")
public class PeopleController {

    public static class Person {
        private String firstName;
        private String surName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getSurName() {
            return surName;
        }

        public void setSurName(String surName) {
            this.surName = surName;
        }
    }

    @GetMapping
    public ResponseEntity<Person> getPerson() {
        Person person = new Person();
        person.setFirstName("Ben");
        person.setSurName("Neighbour");

        return ResponseEntity.ok(person);
    }
}
