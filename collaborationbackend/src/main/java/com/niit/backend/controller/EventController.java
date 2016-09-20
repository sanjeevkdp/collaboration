package com.niit.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.Dao.EventDao;
import com.niit.backend.model.Event;

@RestController
public class EventController {
	@Autowired
	EventDao eventDao;
	
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public ResponseEntity<List<Event>> listAllEvents(){
		List<Event> events = eventDao.listAllEvents();
		if(events.isEmpty()){
            return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}
}
