package com.example.demo.controller;

import com.example.demo.entity.MoviePoster;
import com.example.demo.repository.MoviePostRepository;
import com.example.demo.service.MoviePostService;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MoviePosterController {


    private final MoviePostRepository moviePosterRepository;
    private final MoviePostService moviePostService;

    @Autowired
    public MoviePosterController(MoviePostRepository moviePosterRepository, MoviePostService moviePostService) {
        this.moviePosterRepository = moviePosterRepository;
        this.moviePostService = moviePostService;
    }

    @GetMapping("/v")
    public String crawlAndShow(Model model) throws IOException {
        moviePostService.crawl();
        log.info("crawl-end");
        List<MoviePoster> moviePosters = moviePosterRepository.findAll();
        model.addAttribute("moviePosters", moviePosters);
        return "index";
    }


    @GetMapping("/hello")
    public String templateTest(Model model) {
        log.info("hello");
        List<MoviePoster> moviePosters = moviePosterRepository.findAll();
        model.addAttribute("moviePosters", moviePosters);
        return "hello";
    }

}
