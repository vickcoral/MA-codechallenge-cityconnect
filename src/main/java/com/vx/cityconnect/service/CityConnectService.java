package com.vx.cityconnect.service;

import com.vx.cityconnect.exception.CityNotFoundException;

public interface CityConnectService {
	String checkCitiesConnected(String city1, String city2) throws CityNotFoundException;

}
