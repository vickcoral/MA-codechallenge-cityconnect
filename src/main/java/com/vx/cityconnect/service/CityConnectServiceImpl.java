package com.vx.cityconnect.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.vx.cityconnect.exception.CityNotFoundException;

@Service
public class CityConnectServiceImpl implements CityConnectService {	
	private final Logger logger = LoggerFactory.getLogger(CityConnectServiceImpl.class);
	
	@Autowired
    ResourceLoader resourceLoader;
	
	@Autowired
	private Environment env;
	
	List<String> cityPairList = new ArrayList<>();
	
	@PostConstruct void init() {
		getCityConnectedList();
	}

	@Override
	public String checkCitiesConnected(String city1, String city2) throws CityNotFoundException {
		
		logger.info("checking If two cities are connected");
		if(city1 ==null || city1.trim().isEmpty())
			//throw new CityNotFoundException("Error: City Name of origin was not provided. Please retry by providing both city names.");
			return "no";
		
		if(city2 ==null || city2.trim().isEmpty())
			//throw new CityNotFoundException("Error: City Name was of destination not provided. Please retry by providing both city names.");
			return "no";
		
		StringJoiner joiner1 = new StringJoiner(", ");
		joiner1.add(city1.trim().toUpperCase());		
		joiner1.add(city2.trim().toUpperCase());		
		
		String cityMatch = findMatch(joiner1.toString());
		if(cityMatch.equalsIgnoreCase("yes"))
			return cityMatch;
		
		else {
			StringJoiner joiner2 = new StringJoiner(", ");
			joiner2.add(city2.trim().toUpperCase());		
			joiner2.add(city1.trim().toUpperCase());			
			
			return findMatch(joiner2.toString());
		}
	}

	private String findMatch(String search) {
		List<String> matchingElements = cityPairList.stream()
	      .filter(str -> str.trim().contains(search))
	      .collect(Collectors.toList());
		 		   
		if(matchingElements !=null && !matchingElements.isEmpty())
			return "yes";
		
		else
			return "no";
	}
	
	private void getCityConnectedList() {		
		
	try {
	    Resource resource = resourceLoader.getResource(env.getProperty("file.path"));
	  
	    if(resource !=null) {
		    File file = resource.getFile();
		   
		    Scanner scanner = new Scanner(file);
		    if(scanner !=null) {			  		
		        while (scanner.hasNext()){
		        		String cityPair = scanner.nextLine();
		        		if(cityPair !=null && !cityPair.trim().isEmpty())
		        			cityPairList.add(cityPair.trim().toUpperCase());		               
		        }
		        scanner.close();
		    }
	    }

     } catch (IOException exp) {
    	 logger.error(exp.toString());;
     }
		
		
	}

}
