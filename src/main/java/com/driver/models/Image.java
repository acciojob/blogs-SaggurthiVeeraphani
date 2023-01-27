package com.driver.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Image{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

   private String description;

   private String dimensions;

    @ManyToOne
    @JoinColumn
    private Blog blog;

    //constructors, Getters & Setters


    public Image() {
    }

    public Image(String description, String dimensions) {
        this.description = description;
        this.dimensions = dimensions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

}