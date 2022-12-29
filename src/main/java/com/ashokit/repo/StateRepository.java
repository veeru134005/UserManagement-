package com.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ashokit.entity.State;

public interface StateRepository extends JpaRepository<State, Integer> {

	@Query("select * from State s where s.country.CountryId=:countryId")
	public List<State> getState(@Param("countryId") Integer countryId);
}
