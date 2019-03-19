package com.scotiabank.clinic.controller;

import com.scotiabank.clinic.model.Doctor;
import com.scotiabank.clinic.repository.DoctorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/doctors"})
public class DoctorController {
	private DoctorRepository repository;
	DoctorController(DoctorRepository doctorRepository){
		this.repository = doctorRepository;
	}

	@GetMapping
	public List findAll(){
		return repository.findAll();
	}


	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Doctor> findById(@PathVariable long  id){
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}



}
