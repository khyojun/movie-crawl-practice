package com.example.demo.entity;


import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "movie_poster")
public class MoviePoster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String imageUrl;

    public MoviePoster() {
    }

    public MoviePoster(String title, String imageUrl) {
        this.title = title;
        this.imageUrl=imageUrl;
    }
}
