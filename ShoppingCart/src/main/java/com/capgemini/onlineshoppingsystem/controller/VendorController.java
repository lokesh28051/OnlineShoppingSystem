package com.capgemini.onlineshoppingsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlineshoppingsystem.exception.ResourceNotFoundException;
import com.capgemini.onlineshoppingsystem.model.Vendor;
import com.capgemini.onlineshoppingsystem.repository.VendorRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")
public class VendorController {
	
	@Autowired
	VendorRepository vendorRepository;
	
	@PostMapping("/vendors")
	public Vendor createVendor(@Valid @RequestBody Vendor vendor)
	{
		return vendorRepository.save(vendor);
	}
	
	@GetMapping("/vendors")
	public List<Vendor> getAllVendors()
	{
		return vendorRepository.findAll();
	}

	@GetMapping("/vendors/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable(value = "id") Long vendorId)
        throws ResourceNotFoundException {
        Vendor vendor = vendorRepository.findById(vendorId)
          .orElseThrow(() -> new ResourceNotFoundException("Vendor not found for this id :: " + vendorId));
        return ResponseEntity.ok().body(vendor);
	}
	
	@PutMapping("/vendors/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable(value = "id") Long vendorId,
         @Valid @RequestBody Vendor vendorDetails) throws ResourceNotFoundException {
        Vendor vendor = vendorRepository.findById(vendorId)
        .orElseThrow(() -> new ResourceNotFoundException("Vendor not found for this id :: " + vendorId));

        vendor.setEmail(vendorDetails.getEmail());
        vendor.setLastName(vendorDetails.getLastName());
        vendor.setFirstName(vendorDetails.getFirstName());
        vendor.setUsername(vendorDetails.getUsername());
        vendor.setPassword(vendorDetails.getPassword());
   
        
        final Vendor updatedVendor = vendorRepository.save(vendor);
        return ResponseEntity.ok(updatedVendor);
    }
	
}