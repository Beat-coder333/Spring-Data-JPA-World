package it.object.jpa.world.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.object.jpa.world.model.Country;
import it.object.jpa.world.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepo;

	public List<String> getContinentsList() {
		List<String> continents = countryRepo.getContinetsList();
		return continents;

	}

	public List<Country> getCountriesByContinents(String continent, HttpServletResponse response) {
		List<Country> countries = countryRepo.findCountryByContinent(continent);
		response.setStatus(HttpServletResponse.SC_OK);
		return countries;
	}

	// empty esce fuori cmq la lista
	public List<Country> getCountryByNationOrContinent(String name, String continent, HttpServletResponse response) {
		List<Country> counts = countryRepo.findCountryByNationOrContinent(name, continent);
		if (name.isBlank() && name.isBlank()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

		return counts;

	}

}
