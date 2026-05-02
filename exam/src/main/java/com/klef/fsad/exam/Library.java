package com.klef.fsad.exam;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "library")
public class Library 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String status;

    public Library() {}

    public Library(String name, String description, Date date, String status) 
    {
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public int getId() { return id; }

    @Override
    public String toString() 
    {
        return name + " - " + status;
    }
}