package com.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
