package com.capgemini.onlineshoppingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlineshoppingsystem.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long>{
	Optional<Vendor> findByUsernameAndEmail(String username, String email);

}
