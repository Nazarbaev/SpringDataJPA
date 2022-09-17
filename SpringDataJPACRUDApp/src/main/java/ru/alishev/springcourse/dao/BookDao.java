package ru.alishev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class BookDao {

    private final EntityManager entityManager;
    @Autowired
    public BookDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
