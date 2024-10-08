package com.luv2code.springbootlibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springbootlibrary.entity.Book;
import com.luv2code.springbootlibrary.responsemodels.ShelfCurrentLoansResponse;
import com.luv2code.springbootlibrary.service.BookService;
import com.luv2code.springbootlibrary.utils.ExtractJWT;

//this means our react app will be able to call our app without getting any cors error
@CrossOrigin("https://localhost:3000")
@RestController
//api/books to match our repo
@RequestMapping("/api/books")
public class BookController {

	private BookService bookService;
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/secure/currentloans")
	public List<ShelfCurrentLoansResponse> currentLoans(@RequestHeader(value ="Authorization") String token)
	
	throws Exception
	{
		
		String userEmail = ExtractJWT.payloadJWTExtraction(token,"\"sub\"");
		return bookService.currentLoans(userEmail);
	}
	
	
	
	@GetMapping("/secure/currentloans/count")
	//             this is saying that we are expecting somthing in the request header
	//that has a key of "Authorization" pull the value out in our var called token
	public int currentLoansCount(@RequestHeader(value = "Authorization")String token) {
		String userEmail = ExtractJWT.payloadJWTExtraction(token,"\"sub\"");
		return bookService.currentLoansCount(userEmail);
	}
	
	@GetMapping("/secure/ischeckedout/byuser")
	public Boolean checkoutBookByUser(@RequestHeader(value = "Authorization")String token,
			@RequestParam Long bookId) {
		String userEmail = ExtractJWT.payloadJWTExtraction(token,"\"sub\"");
		return bookService.checkoutBookByUser(userEmail, bookId);
	}
	
	@PutMapping("/secure/checkout")
	public Book checkoutBook(@RequestHeader(value = "Authorization")String token,
			@RequestParam Long bookId) throws Exception{
		String userEmail = ExtractJWT.payloadJWTExtraction(token,"\"sub\"");
		return bookService.checkoutBook(userEmail, bookId);
	}
	
	@PutMapping("/secure/return")
	public void returnBook(@RequestHeader(value = "Authorization") String token,
					@RequestParam Long bookId) throws Exception {
		String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
		bookService.returnBook(userEmail, bookId);
	}
	
	@PutMapping("/secure/renew/loan")
	public void renewLoan(@RequestHeader(value="Authorization") String token,
			@RequestParam Long bookId) throws Exception {
		String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
		bookService.renewLoan(userEmail,bookId);
	}
		
	
}
