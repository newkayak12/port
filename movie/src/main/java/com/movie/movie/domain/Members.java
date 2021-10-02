package com.movie.movie.domain;

import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Table(name = "MEMBERS")
@Entity
public class Members {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBERS_ID")
	private Long membersId;
	@Column(name = "MEMBERS_USER_ID", nullable = false)
	private String membersUserId;
	@Column(name = "MEMBERS_USER_PASSWORD", nullable = false)
	private String membersUserPassword;

	
}
