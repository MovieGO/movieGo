package com.movieGo;

import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.movieGo.entity.*;
import com.movieGo.repo.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MovieGoApplication.class)
public class MovieGoApplicationTests {
	@Autowired
	MovieRepo mp;
	
	@Autowired
	SessionRepo sp;
	
	@Autowired
	CinemaRepo cp;
	@Test
	public void contextLoads() {
	}

}
