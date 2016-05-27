package com.movieGo.form;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class seatsForm {
	private ArrayList<Integer> xList = new ArrayList<>();
	private ArrayList<Integer> ylist = new ArrayList<>();
	private int nseats = 0;
	private Long sid;
}
