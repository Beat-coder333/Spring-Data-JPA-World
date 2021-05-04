package it.object.jpa.world.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.object.jpa.world.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	@Query(value = "SELECT Distinct continent FROM Country")
	public List<String> getContinetsList();

	public List<Country> findCountryByContinent(String continent);

	@Query(value = "SELECT x FROM Country x WHERE (''= ?1 OR x.name=?1) AND ( x.continent= ?2 OR ''=?2 )")
	public List<Country> findCountryByNationOrContinent(String name, String continent);
}
