package ru.alishev.springcourse.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.models.Person;

import javax.persistence.EntityManager;
import java.util.*;

@Component
public class PersonDao {

    private final EntityManager entityManager;
    @Autowired
    public PersonDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }




}
