package com.movie.movie.domain.compositeKey;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class MovieActorId implements Serializable{
	private String movieId;
	private String actorId;

	public MovieActorId(){

	}

	public MovieActorId(String movieId, String actorId){
		this.movieId=movieId;
		this.actorId=actorId;
	}
}
