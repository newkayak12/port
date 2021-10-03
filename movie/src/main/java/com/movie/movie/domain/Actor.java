package com.movie.movie.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

@Table(name = "ACTOR")
@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACTOR_ID", nullable = false)
	private Long actorId;
	@Column(name = "ACTOR_NAME", nullable = false)
	private String actorName;

	@Column(name = "ACTOR_PICTURE", nullable = true)
	private String actorPicture;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ACTOR_BIRTH", nullable = false)
	private Date actorBirth;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "actors")
	private List<Movie> movies = new ArrayList<>();
	
	
}
