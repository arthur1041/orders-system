package com.arthurcruz.orderssystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arthurcruz.orderssystem.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
}
