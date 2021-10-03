package com.movie.movie.web.movieController;

import java.util.List;

import com.movie.movie.domain.Movie;
import com.movie.movie.domain.enums.Genre;
import com.movie.movie.domain.enums.Order;
import com.movie.movie.service.movieService.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MovieController {
	@Autowired
    MovieService service;

    @GetMapping("/api/movie/order/{sort}")
    public List<Movie> showListOrder(@PathVariable("sort") String order){
        Order orderholder = Order.DESC;
	    if(order.equalsIgnoreCase("asc")){
            orderholder=Order.ASC;
        } 
		List<Movie> result = service.selectListSortedbyScore(orderholder);
        log.error("{}",result);
	    return result;
    }
    @GetMapping("/api/movie/genre/{genre}")
    public List<Movie> showListGenre(@PathVariable("genre") String genre){
        Genre genreholder = Genre.ACTION;
        if(genre.equalsIgnoreCase("thriller")){
            genreholder=Genre.THRILLER;
        }
        if(genre.equalsIgnoreCase("romantic")){
            genreholder=Genre.ROMANTIC;
        }
        if(genre.equalsIgnoreCase("comic")){
            genreholder=Genre.COMIC;
        }
        return service.selectListByGenre(genreholder);
    }
}
