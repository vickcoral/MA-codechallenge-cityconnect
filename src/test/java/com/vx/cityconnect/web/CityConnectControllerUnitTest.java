package com.vx.cityconnect.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.when;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.vx.cityconnect.service.CityConnectService;

@RunWith(SpringRunner.class)
@WebMvcTest(CityConnectController.class)
public class CityConnectControllerUnitTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    CityConnectService applicationService;
    
    @Test
    public void getCityConnectInfo() throws Exception {
    	String origina ="Newark";
    	String destination = "Boston";
    	
    	when(applicationService.checkCitiesConnected(origina,destination)).thenReturn("yes");
		this.mockMvc.perform(get("/connected?origin=Newark&destination=Boston")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("yes")));    	    	  
    }

}
