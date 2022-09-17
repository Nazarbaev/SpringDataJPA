package ru.alishev.springcourse.services;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.models.Book;
import ru.alishev.springcourse.models.Person;
import ru.alishev.springcourse.repositories.PeopleRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Neil Alishev
 */
@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(Person person) {
        person.setCratedAt(new Date());

        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }



    public Optional<Person> getPersonByFullName(String name) {
        return peopleRepository.findByName(name);
    }

    public List<Book> getBooksByOwnerId(int id){
        Optional<Person> foundPerson = peopleRepository.findById(id);

        if(foundPerson.isPresent()){
            Hibernate.initialize(foundPerson.get().getBooks());

            foundPerson.get().getBooks().forEach(book -> {
                long diffInMillies = Math.abs(book.getTakenAt().getTime() - new Date().getTime());

                if(diffInMillies>864000000){
                    book.setExpired(true);
                }
            });
            return foundPerson.get().getBooks();
        }else{
            return Collections.emptyList();
        }



    }

}
