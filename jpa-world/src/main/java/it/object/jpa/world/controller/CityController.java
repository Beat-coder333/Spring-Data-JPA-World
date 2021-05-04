package it.object.jpa.world.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.object.jpa.world.model.City;
import it.object.jpa.world.service.CityService;

@RestController
@RequestMapping("/api/city")
public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping("/find/name")
	public City getCityByName(@RequestParam("cityname") String name, HttpServletResponse response) {
		City city = cityService.findByName(name, response);
		return city;

	}

	@GetMapping("get/list-cities/{countryCode}")
	public List<City> getCitiesByCountryCode(@PathVariable String countryCode, HttpServletResponse response) {
		List<City> cities = cityService.findByCountryCode(countryCode, response);
		return cities;

	}

}
