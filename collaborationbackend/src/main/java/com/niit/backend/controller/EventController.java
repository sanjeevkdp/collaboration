package com.niit.backend.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.backend.Dao.EventDao;
import com.niit.backend.model.Event;

@RestController
public class EventController {
	@Autowired
	EventDao eventDao;
	@Autowired
	Event event;
	
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public ResponseEntity<List<Event>> listAllEvents(){
		List<Event> events = eventDao.listAllEvents();
		if(events.isEmpty()){
            return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}
    
  //-------------------Create a Event--------------------------------------------------------
    
  @RequestMapping(value = "/events", method = RequestMethod.POST)
  public ResponseEntity<Void> createEvent(@RequestBody Event event,    UriComponentsBuilder ucBuilder) {
      System.out.println("Creating Event " + event.getEventName());

      if (eventDao.isEventExist(event)) {
          System.out.println("A Event with name " + event.getEventName() + " already exist");
          return new ResponseEntity<Void>(HttpStatus.CONFLICT);
      }
     event.setCreatedAt(new Date());
     eventDao.saveOrUpdate(event);

      HttpHeaders headers = new HttpHeaders();
      headers.setLocation(ucBuilder.path("/events/{event_id}").buildAndExpand(event.getEvent_id()).toUri());
      return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

   
    

}
