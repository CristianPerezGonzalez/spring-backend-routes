package org.myproject.dto;

import org.myproject.persistence.entities.Route;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MarkerINDTO{
	private Long id;
	private String title;
	private double latitude;
	private double longitude;
	private RouteDTO route;
	
	
}
