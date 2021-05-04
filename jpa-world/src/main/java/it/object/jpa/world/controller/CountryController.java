package it.object.jpa.world.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.object.jpa.world.model.Country;
import it.object.jpa.world.service.CountryService;

@RestController
@RequestMapping("/api/country")
public class CountryController {

	@Autowired
	private CountryService countryServ;

	@GetMapping("continents-list")
	public List<String> getContinentsList() {
		List<String> conts = countryServ.getContinentsList();
		return conts;

	}

	@GetMapping("country-list/{continent}")
	public List<Country> getCountriesList(@PathVariable String continent, HttpServletResponse response) {
		List<Country> countries = countryServ.getCountriesByContinents(continent, response);
		return countries;
	}

	@GetMapping("get-countries")
	public List<Country> getCountryByNameOrContinent(@RequestParam String name, @RequestParam String continent,
			HttpServletResponse response) {
		List<Country> counts = countryServ.getCountryByNationOrContinent(name, continent, response);
		return counts;
	}

}
