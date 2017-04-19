package org.myproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RouteDetailDTO{
	private Long id;
	private double distance;
	
	private Integer difficulty;
	
	private Integer duration;
	private double latitude;
	private double longitude;
	
}
