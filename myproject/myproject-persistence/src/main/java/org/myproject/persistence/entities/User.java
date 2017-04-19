package org.myproject.persistence.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude={"ratings"})
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NonNull
	private String username;
	@NonNull
	private String password;
	@NonNull
	private String name;
	@NonNull
	private String lastname;
	@NonNull
	private String email;
	private boolean admin;
	
	private boolean enabled;
	
	@OneToMany(mappedBy ="user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference(value="ratings_user")
	private Set<Rating> ratings = new HashSet<>();
	
	
}
