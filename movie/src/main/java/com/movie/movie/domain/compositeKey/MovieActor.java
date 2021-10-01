package com.movie.movie.domain.compositeKey;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
// @Table(name = "MOVIE_ACTOR")
// @Entity
// @IdClass(MovieActorId.class)
public class MovieActor {
	@Id
	@Column(name="MOVIE_ID")
	private Long  movieId;

	@Id
	@Column(name = "ACTOR_ID")
	private Long actorId;
	
}
