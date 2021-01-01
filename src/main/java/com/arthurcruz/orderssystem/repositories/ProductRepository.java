package com.arthurcruz.orderssystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arthurcruz.orderssystem.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
