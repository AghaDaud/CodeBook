package com.luv2code.springbootlibrary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.luv2code.springbootlibrary.entity.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
	
	Checkout findByUserEmailAndBookId(String userEmail, Long bookId);
	
	//this will return every checkout that we currently have for findBooksByUserEmail
	List<Checkout> findBooksByUserEmail(String userEmail);
	
	 @Modifying
	    @Query("delete from Checkout where book_id in :book_id")
	    void deleteAllByBookId(@Param("book_id") Long bookId);
	
}
