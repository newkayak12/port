package com.movie.movie.repository.movieRepository;

import java.util.List;

import com.movie.movie.domain.Movie;
import com.movie.movie.domain.enums.Genre;
import com.movie.movie.domain.enums.Order;

public interface MovieRepository {
	public List<Movie> selectListByGenre(Genre genre);
	public List<Movie> selectListSortedbyScore(Order order);
	public Movie selectOne(Long id);
}
