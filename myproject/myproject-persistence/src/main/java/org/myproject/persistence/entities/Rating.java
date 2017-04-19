package org.myproject.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @ToString @NoArgsConstructor @RequiredArgsConstructor
@EqualsAndHashCode(exclude={"user", "route"})
public class Rating implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_user")
	@JsonBackReference(value="ratings_user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "id_route")
	@JsonBackReference(value="ratings_route")
	private Route route;
	
	@NonNull
	private String comment;
	
	@NonNull
	private Integer stars;


	
	
	
	
}
