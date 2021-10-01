package com.movie.movie.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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

@Table(name = "MOVIE_BOARD")
@Entity
public class MovieBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOVIE_BOARD_ID")
	private Long movieBoardId;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Members members;

	@ManyToOne
	@JoinColumn(name = "MOVIE_ID")
	private Movie movie;
	
	@Column(name = "MOVIE_BOARD_CONTENT", nullable = false)
	private String movieBoardContent;
	@Column(name = "MOVIE_BOARD_SCORE", nullable = false)
	private int movieBoardScore;

}
