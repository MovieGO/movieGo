package com.movieGo.form;

import com.movieGo.entity.Movie;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class movieQueryForm {
	private Movie.Type type = null;
	private String name = null;
}
