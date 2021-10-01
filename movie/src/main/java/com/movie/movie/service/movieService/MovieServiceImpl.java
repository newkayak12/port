package com.movie.movie.service.movieService;

import com.movie.movie.domain.Movie;
import com.movie.movie.domain.enums.Genre;
import com.movie.movie.domain.enums.Order;
import com.movie.movie.repository.movieRepository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieRepository repo;

    @Override
    public List<Movie> selectListByGenre(Genre genre) {
        return repo.selectListByGenre(genre);
    }

    @Override
    public List<Movie> selectListSortedbyScore(Order order) {
        return repo.selectListSortedbyScore(order);
    }

    @Override
    public Movie selectOne(Long id) {
        return repo.selectOne(id);
    }
}
