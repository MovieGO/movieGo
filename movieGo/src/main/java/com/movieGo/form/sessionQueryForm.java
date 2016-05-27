package com.movieGo.form;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.movieGo.entity.Cinema;
import com.movieGo.entity.Movie;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class sessionQueryForm {
	private Movie movie = null;
	//format: 1993-01-09
	private String date = null;
	private Cinema cinema = null;
}
