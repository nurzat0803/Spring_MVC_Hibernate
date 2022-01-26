package peaksoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.PersonDAO;
import peaksoft.entity.Person;


@Service
public class PersonServiceImpl implements PersonService {
    @Qualifier("personDao")
    @Autowired
    private PersonDAO personDAO;

    @Override
    @Transactional
    public void addPerson(Person p) {
        if (p != null) {
            personDAO.addPerson(p);
        }
    }

    @Override
    @Transactional
    public void updatePerson(Person p) {
        this.personDAO.updatePerson(p);
    }

    @Override
    @Transactional
    public List<Person> listPersons() {
        return this.personDAO.listPersons();
    }

    @Override
    @Transactional
    public Person getPersonById(int id) {
        return this.personDAO.getPersonById(id);
    }

    @Override
    @Transactional
    public void removePerson(int id) {
        this.personDAO.removePerson(id);
    }

}