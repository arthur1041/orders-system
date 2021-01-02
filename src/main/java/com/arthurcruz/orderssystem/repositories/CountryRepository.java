package com.arthurcruz.orderssystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arthurcruz.orderssystem.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
	
}
