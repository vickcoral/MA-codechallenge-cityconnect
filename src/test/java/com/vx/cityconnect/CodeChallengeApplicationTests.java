package com.vx.cityconnect;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.vx.cityconnect.web.CityConnectController;

import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeChallengeApplicationTests {
	
	@Autowired
    private CityConnectController cityConnectController;

	@Test
	public void contextLoads() {
		assertThat(cityConnectController).isNotNull();
	}

}
