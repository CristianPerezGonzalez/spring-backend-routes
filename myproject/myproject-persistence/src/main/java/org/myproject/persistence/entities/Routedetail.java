package org.myproject.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@EqualsAndHashCode(exclude={"route","routetype"})
public class Routedetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_route")
	private Route route;
	@NonNull
	private String description;
	
	@ManyToOne
	@JoinColumn(name="id_routetype")
	private RouteType routetype;
	
	private double distance;
	@NonNull
	private Integer difficulty;
	@NonNull
	private Integer duration;
	private double latitude;
	private double longitude;
	private String coordinates;

	
	
}
