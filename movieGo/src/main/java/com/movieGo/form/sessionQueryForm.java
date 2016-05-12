package com.movieGo.form;

import java.util.Date;

import com.movieGo.entity.Cinema;
import com.movieGo.entity.Movie;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class sessionQueryForm {
	private Movie movie = null;
	private Date date = null;
	private Cinema cinema = null;
}
