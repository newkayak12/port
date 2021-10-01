package com.movie.movie.service.movieService;

import javax.transaction.Transactional;

import com.movie.movie.domain.Movie;
import com.movie.movie.domain.enums.Genre;
import com.movie.movie.domain.enums.Order;
import com.movie.movie.repository.movieRepository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieService {
	public List<Movie> selectListByGenre(Genre genre);
    public List<Movie> selectListSortedbyScore(Order order);
    public Movie selectOne(Long id);

}
