package com.niit.backend.controller;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.backend.Dao.UserDetailsDao;
import com.niit.backend.mailMail.MailMail;
import com.niit.backend.model.UserDetails;

@RestController
public class UserController {
	@Autowired
	UserDetails userDetails;
	@Autowired
	UserDetailsDao userDetailsDao;
	private MailMail mailMail = new MailMail();

	// ---------------------fetchAllUserDetailss----------------------------------------------

	@RequestMapping(value = "/userDetails", method = RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> listAllUserDetails() {
		List<UserDetails> userDetails = userDetailsDao.listAllUserDetails();
		if (userDetails.isEmpty()) {
			return new ResponseEntity<List<UserDetails>>(HttpStatus.NO_CONTENT);// You  many decide  to return HttpStatus.NOT_FOUND
																			 
		}
		return new ResponseEntity<List<UserDetails>>(userDetails, HttpStatus.OK);
	}

	// -------------------Create a UserDetails--------------------------------------------------------

	@RequestMapping(value = "/userDetails", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody UserDetails userDetails, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating UserDetails " + userDetails.getUserName());

		if (userDetailsDao.isUserDetailsExist(userDetails)) {
			System.out.println("A UserDetails with name " + userDetails.getUserName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		userDetails.setUserDetails_id("USR" + UUID.randomUUID().toString().substring(30).toUpperCase());
		userDetails.setIs_notify("pending");
		userDetails.setEnabled("student");
		userDetailsDao.saveOrUpdate(userDetails);
		String message = "Hello "+userDetails.getUserName()+" you're successfully registered with us, Thanks !";
		
		mailMail.sendEmail(userDetails.getEmail(),"Registration Successfull",message);	
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/userDetails/{userDetails_id}")
				.buildAndExpand(userDetails.getUserDetails_id()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

}
