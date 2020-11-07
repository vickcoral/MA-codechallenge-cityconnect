package com.vx.cityconnect.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vx.cityconnect.exception.CityNotFoundException;
import com.vx.cityconnect.service.CityConnectService;

@RestController
@RequestMapping
public class CityConnectController {
	
	@Autowired
	private CityConnectService cityConnectService;
	
	@GetMapping("/connected")
	@ResponseBody
	public String getCityConnectInfo(@RequestParam(name="origin", required = false, defaultValue="") String origin, @RequestParam(name="destination", required = false, defaultValue="") String destination) {
		try {
			return cityConnectService.checkCitiesConnected(origin, destination);
		}
		catch (CityNotFoundException notFoundExp) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, notFoundExp.getMessage());
		}
		
	}		

}
