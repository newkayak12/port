package com.movie.movie.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.movie.movie.domain.enums.Genre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "MOVIE")
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MOVIE_ID")
	private Long movieId;
	@Column(name = "MOVIE_TITLE", nullable = false)
	private String movieTitle;
	@Column(name = "MOVIE_POSTER", nullable = false)
	private String moviePoster;
	@Column(name = "MOVIE_CONTENT", nullable = false)
	private String movieContent;
	@Column(name = "MOVIE_PREVIEW", nullable = false)
	private String moviePreview;
	
	@Column(name = "MOIVE_GENRE", nullable = false)
	@Enumerated(EnumType.STRING)
	private Genre genre;

	@Column(name = "MOVIE_TOTAL_SCORE", nullable = false)
	private String movieTotalScore;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "MOIVE_ACTOR", joinColumns =  @JoinColumn(name="MOVIE_ID"), inverseJoinColumns = @JoinColumn(name="ACTOR_ID"))
	List<Actor> actors = new ArrayList<>();


	public void addActors(Actor actor){
		if(actors.contains(actor)){
			actors.remove(actor);
		}
		actors.add(actor);
		actor.getMovies().add(this);
	}


}
