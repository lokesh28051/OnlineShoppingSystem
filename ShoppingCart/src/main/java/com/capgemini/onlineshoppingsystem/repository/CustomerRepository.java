package com.capgemini.onlineshoppingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlineshoppingsystem.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
