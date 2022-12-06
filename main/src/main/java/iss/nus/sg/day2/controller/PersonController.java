package iss.nus.sg.day2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import iss.nus.sg.day2.model.Person;
import iss.nus.sg.day2.service.PersonService;

import java.util.ArrayList;
import java.util.List;



@Controller
@RequestMapping("/persons")
public class PersonController {
   
    private List<Person> personList= new ArrayList<Person>();

    @Autowired
    PersonService personService;

    //@autowired as below
    // public PersonController(){
    //     personService = new PersonService();
    // }

    @Value("${welcome.message}")
    private String welcomeMessasage;

    @Value("${person.list.header}")
    private String headermessage;

    @GetMapping(value={"/index","/home"})
    public String index(Model model){

        model.addAttribute("message",welcomeMessasage);
        return "home";
    }

    @GetMapping(value = "/testRetrieveAllPerson", produces = "application/json" )
    public @ResponseBody List<Person> getAllPersons(){
        personList = personService.getPerson();

        return personList;
    }

    @GetMapping(value = "/list")
    public String personList(Model model){
        personList = personService.getPerson();
        model.addAttribute("persons", personList);
        model.addAttribute("listofpersons", headermessage);
        return "personList";
    }

    @PostMapping(value = "/update")
    public String updatePerson(@ModelAttribute(value="per") Person p, Model model){
        model.addAttribute("per", p);
        return "personEdit";
    }

    @PostMapping(value = "/updatePerson")
    public String updatePersonRecord(@ModelAttribute(value="per") Person p){
        personService.updatePerson(p);
        return "redirect:/persons/list";
    }


    @PostMapping(value = "/deletePerson")
    public String deletePerson(@ModelAttribute(value = "per") Person p){
        personService.removePerson(p);
        return "redirect:/persons/list";
    }

}