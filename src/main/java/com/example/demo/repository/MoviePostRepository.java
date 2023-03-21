package com.example.demo.repository;

import com.example.demo.entity.MoviePoster;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MoviePostRepository extends JpaRepository<MoviePoster, Long> {


    //Optional<MoviePoster> findByTitle(String title);
}
