package com.example.demo.service;

import com.example.demo.entity.MoviePoster;
import com.example.demo.repository.MoviePostRepository;
import java.io.IOException;


import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class MoviePostService {

    private static final String IMDB_URL = "https://www.imdb.com/movies-in-theaters/";

    private final MoviePostRepository moviePosterRepository;

    @Autowired
    public MoviePostService(MoviePostRepository moviePosterRepository) {
        this.moviePosterRepository = moviePosterRepository;
    }

    @Transactional
    public void crawl() throws IOException { //크롤링 코드 성공
        log.info("crawl-start");
        try {
            Document doc = Jsoup.connect(IMDB_URL).get();
            Elements posterElements = doc.getElementsByClass("loadlate");
            log.info("posterElement={}", posterElements);
            for (Element posterElement : posterElements) {
                String title = posterElement.attr("alt");
                String posterUrl = posterElement.attr("loadlate");
                log.info("posterUrl={}", posterUrl);
                MoviePoster moviePoster = new MoviePoster(title, posterUrl);
                log.info("moviePoster={}", moviePoster);
                moviePosterRepository.save(moviePoster);
            }
        }catch (IOException e){
            log.error("error", e);
        }
    }
}
