package com.example.demo.model;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity   //creating entity for sql database
@Table(name = "lessons") //name of the table in sql database
public class Lesson {

    @Id //inside of class lesson; primary key of this table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tells how you are going to generate the Id number
    private Long id;
    private String title; //


    @Column(columnDefinition = "date") //telling JPA fill this column with the sql type date
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deliveredOn;

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDeliveredOn() {
        return deliveredOn;
    }

    public void setDeliveredOn(Date deliveredOn) {
        this.deliveredOn = deliveredOn;
    }

}
