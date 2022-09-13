package com.hospital.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entity.Patient;
import com.hospital.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService pService;

	@GetMapping("/patients") // rest end points , handler method
	public List<Patient> findAll()
	{
		return pService.findAll();
	}
	
	@GetMapping("/patient/{id}")
	public Patient findById(@PathVariable int id)
	{
		return pService.findById(id);
	}
	
	@DeleteMapping("/patient/{id}")
	public String deleteById(@PathVariable int id)
	{
		return pService.deletById(id)+" record deleted";
	}
	
	@PutMapping("/patient/{id}")
	public String update(@PathVariable int id,@RequestBody Patient p)
	{
		return pService.update(p, id)+" record updated";
	}
	
	
	@PostMapping("/patient")
	public String save(@RequestBody Patient p)
	{
		return pService.save(p)+" record inserted";
	}
	
}
