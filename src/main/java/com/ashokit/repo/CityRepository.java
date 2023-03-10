package com.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ashokit.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

	@Query("from City c where c.state.stateId=:stateId")
	public List<City> getCity(@Param("stateId") Integer stateId);
}
