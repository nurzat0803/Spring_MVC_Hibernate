package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.Person;
import peaksoft.service.PersonService;

import java.util.List;

@Controller
//@RequestMapping("/")
public class MainController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Person> listPersons = personService.listPersons();
        model.addAttribute("listPersons", listPersons);
        return "index";
    }

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("persons", "Welcome");
        return "index";
    }

    @GetMapping("/person-add")
    public String getPersonAddPage(Model model) {
        Person  person = new Person();
        model.addAttribute("person", person);
        return "add-student";
    }

    @PostMapping("/save")
    public String savePerson (@ModelAttribute ("person") Person person) {
        personService.addPerson(person);
        return "redirect:/";

    }

//    @GetMapping("/person-list")
//    public String getPersons(Model model) {
//        model.addAttribute("persons", personService.listPersons());
//        return "index";
//    }
//    @GetMapping("/person-add")
//    public String getPersonAddPage(Model model) {
//        model.addAttribute("person", new Person());
//        return "add-student";
//    }
//    @PostMapping
//    public String personSave(@ModelAttribute Person person, Model model) {
//        personService.addPerson(person);
//        model.addAttribute("person", personService.listPersons());
//        return "index";
//    }

}
