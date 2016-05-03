package com.movieGo.form;

import com.movieGo.entity.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class changePwForm {
	User user;
	String newPw, oldPw;
}
