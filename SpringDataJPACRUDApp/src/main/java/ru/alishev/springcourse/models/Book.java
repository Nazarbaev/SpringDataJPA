package ru.alishev.springcourse.models;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name ="Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;



    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name="year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "person_id",referencedColumnName = "id")
    private Person owner;

    @Column(name = "takenat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takenAt;

    @Transient
    private boolean expired;

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public  Book(){}

    public Book( String name) {

        this.name = name;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public Date getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(Date takenAt) {
        this.takenAt = takenAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", owner=" + owner +
                '}';
    }
}
