package com.luv2code.springbootlibrary.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springbootlibrary.requestmodels.ReviewRequest;
import com.luv2code.springbootlibrary.service.ReviewService;
import com.luv2code.springbootlibrary.utils.ExtractJWT;

@CrossOrigin("https://localhost:3000")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	private ReviewService reviewService;
	
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	@GetMapping("/secure/user/book")
	public Boolean reviewBookByUser(@RequestHeader(value="Authorization")String token,
									@RequestParam Long bookId) throws Exception{
		String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
		if (userEmail== null) {
			throw new Exception ("User email is missng");
		}
		return reviewService.userReviewListed(userEmail, bookId);
	}
	
	
	@PostMapping("/secure")
	public void postReview(@RequestHeader(value="Authorization") String token,
							@RequestBody ReviewRequest reviewRequest) throws Exception{
			String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
			if (userEmail == null ) {
				throw new Exception ("User email is missing");
			}
			reviewService.postReiview(userEmail, reviewRequest);
	}
}
