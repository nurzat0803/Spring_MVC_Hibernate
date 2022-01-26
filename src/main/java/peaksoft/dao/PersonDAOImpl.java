package peaksoft.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Person;


@Repository
public class PersonDAOImpl implements PersonDAO {
    private final SessionFactory sessionFactory;

    public PersonDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPerson(Person p) {
        Session session = sessionFactory.openSession();
        session.persist(p);
        session.close();
    }

    @Override
    public void updatePerson(Person p) {
        Session session = sessionFactory.openSession();
        session.update(p);
        session.close();
    }

    @Override
    public List<Person> listPersons() {
        Session session = sessionFactory.openSession();
        List<Person> personsList = session.createQuery("from Person").list();
        session.close();
        return personsList;
    }

    @Override
    public Person getPersonById(int id) {
        Session session = sessionFactory.openSession();
        Person p = (Person) session.load(Person.class, new Integer(id));
        session.close();
        return p;
    }

    @Override
    public void removePerson(int id) {
        Session session = sessionFactory.openSession();
        Person p = (Person) session.load(Person.class, new Integer(id));
        session.delete(p);
        session.close();
    }
}
