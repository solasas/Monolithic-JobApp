package com.sashank.jobapp1.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sashank.jobapp1.company.Company;
import jakarta.persistence.*;

import java.lang.reflect.Type;

@Entity
@Table(name="review-table")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private int rating;
    @JsonIgnore
    @ManyToOne
    private Company company;

    public Review(Long id, String content, int rating) {
        this.id = id;
        this.content = content;
        this.rating = rating;
    }
    public Review(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
