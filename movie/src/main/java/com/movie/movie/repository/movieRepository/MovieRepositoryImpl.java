package com.movie.movie.repository.movieRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.movie.movie.domain.Actor;
import com.movie.movie.domain.Movie;
 import static com.movie.movie.domain.QMovie.movie;
 import static com.movie.movie.domain.QActor.actor;
import com.movie.movie.domain.enums.Genre;
import com.movie.movie.domain.enums.Order;
import com.mysema.query.jpa.impl.JPAQuery;

import org.springframework.stereotype.Repository;
@Repository
public class MovieRepositoryImpl implements MovieRepository{
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Movie> selectListByGenre(Genre genre) {
		JPAQuery query = new JPAQuery(em);
		 List<Movie> result = query.from(movie).where(movie.genre.eq(genre)).offset(0).limit(8).list(movie);
		return result;
	}

	@Override
	public List<Movie> selectListSortedbyScore(Order order) {
		JPAQuery query = new JPAQuery(em);
		// BooleanBuilder builder = new BooleanBuilder();
		 JPAQuery temp = query.from(movie);
		if(order.equals(Order.ASC)){
			 temp.orderBy(movie.movieTotalScore.asc());
		}
		if(order.equals(Order.DESC)){
			 temp.orderBy(movie.movieTotalScore.desc());
		}
		 List<Movie> result = temp.offset(0).limit(8).list(movie);
		return result;
	}

	@Override
	public Movie selectOne(Long id) {
		JPAQuery query = new JPAQuery(em);
		 Movie result = query.from(movie).leftJoin(movie.actors,actor ).where(movie.movieId.eq(id)).singleResult(movie);
		return result;
	}
	
}
