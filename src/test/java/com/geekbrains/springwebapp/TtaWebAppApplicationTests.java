package com.geekbrains.springwebapp;

import TravelAgency.TtaWebAppApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TtaWebAppApplication.class) // Add this line with your main application class
public class TtaWebAppApplicationTests {

	@Test
	public void contextLoads() {
	}
}
