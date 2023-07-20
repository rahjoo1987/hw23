package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import command.PersonCommand;
import converter.PersonSignupCommandToPersonConverter;
import domain.Person;
import repository.PermissionRepository;
import repository.PersonRepository;

import javax.persistence.EntityManager;

public class PersonRepositoryImpl extends BaseEntityRepositoryImpl<Person>implements PersonRepository {
    public PersonRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }

    @Override
    public Person getByUsername(String username) {
        String jql = "SELECT m from Person m where m.username=:P";
        return  this.em.createQuery(jql, Person.class).setParameter("P", username).getSingleResult();
    }

    @Override
    public PersonCommand personSignup(PersonCommand c) {
        PersonSignupCommandToPersonConverter personSignupCommandToPersonConverter =
                new PersonSignupCommandToPersonConverter();
        Person person = personSignupCommandToPersonConverter.convert(c);
        this.save(person);
        return c;
    }
}
