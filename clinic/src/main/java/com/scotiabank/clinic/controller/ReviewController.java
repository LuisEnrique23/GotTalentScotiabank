package com.scotiabank.clinic.controller;


import com.scotiabank.clinic.model.Review;
import com.scotiabank.clinic.repository.DoctorRepository;
import com.scotiabank.clinic.repository.ReviewRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/reviews"})
public class ReviewController {
	private ReviewRepository repository;
	ReviewController(ReviewRepository reviewRepository){
		this.repository = reviewRepository;
	}

	@PostMapping
	public Review create(@RequestBody Review review){
		return repository.save(review);
	}

}
