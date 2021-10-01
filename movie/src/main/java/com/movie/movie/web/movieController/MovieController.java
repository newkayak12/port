package com.movie.movie.web.movieController;

import com.movie.movie.service.movieService.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
	@Autowired
    MovieService service;
}
