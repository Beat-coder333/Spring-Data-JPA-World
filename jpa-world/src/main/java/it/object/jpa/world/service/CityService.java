package it.object.jpa.world.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.object.jpa.world.model.City;
import it.object.jpa.world.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepo;

	// optional?
	public City findByName(String name, HttpServletResponse response) {
		City city = cityRepo.findByName(name);
		if (city == null) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}
		return city;

	}

	public List<City> findByCountryCode(String countryCode, HttpServletResponse response) {
		List<City> cities = cityRepo.findByCountryCode(countryCode);
		if (countryCode.length() > 3) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

		} else {
			response.setStatus(HttpServletResponse.SC_OK);
		}

		return cities;

	}

}
