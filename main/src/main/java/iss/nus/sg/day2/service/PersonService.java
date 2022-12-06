package iss.nus.sg.day2.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import iss.nus.sg.day2.model.Person;

import java.util.*;


@Service
public class PersonService {
    private List<Person> persons = new ArrayList<>();

    public PersonService(){
        persons.add(new Person("mark", "Kwaan"));
        persons.add(new Person("Lyae", "kyee"));
        persons.add(new Person("Kyae", "wan"));
    }

    public List<Person> getPerson(){
        return this.persons;
    }

    public void addPerson(Person newPerson){
        persons.add(new Person(newPerson.getFirstName(), newPerson.getLastName()));
    }

    public void removePerson(Person person){
        Person foundPerson = persons.stream().filter(p -> p.getId().equals(person.getId())).findAny().orElse(null);
        persons.remove(foundPerson);
    }

    public void updatePerson(Person person){
        Person foundPerson = persons.stream().filter(p -> p.getId().equals(person.getId())).findAny().orElse(null);
        Person updatePerson = new Person();
        updatePerson.setId(person.getId());
        updatePerson.setFirstName(person.getFirstName());
        updatePerson.setLastName(person.getLastName());
        persons.remove(foundPerson);
        persons.add(updatePerson);

    }


}
