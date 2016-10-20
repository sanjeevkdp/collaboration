package com.niit.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.Dao.UserDetailsDao;
import com.niit.backend.model.UserDetails;
import com.niit.backend.utility.UserToSend;
import com.niit.backend.utility.ValidUserModel;

@RestController
public class LoginController {
	@Autowired
	UserDetails userDetails;
	@Autowired
	UserDetailsDao userDetailsDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<UserToSend> isValidUser(@RequestBody ValidUserModel validUser) {
		System.out.println(validUser.getUsername() + "   " + validUser.getPassword());
		if (userDetailsDao.checkUser(validUser.getUsername(), validUser.getPassword()) == null) {
			return new ResponseEntity<UserToSend>(HttpStatus.NOT_FOUND);
		}
		else{
		userDetails = userDetailsDao.checkUser(validUser.getUsername(), validUser.getPassword());
		System.out.println(userDetails);
		UserToSend userToSend = new UserToSend();
		userToSend.setUserDetails_id(userDetails.getUserDetails_id());
		userToSend.setUsername(userDetails.getEmail());
		userToSend.setStatus(userDetails.getStatus());
		userToSend.setPassword(userDetails.getPassword());
		return new ResponseEntity<UserToSend>(userToSend, HttpStatus.OK);
		}
	}
}
