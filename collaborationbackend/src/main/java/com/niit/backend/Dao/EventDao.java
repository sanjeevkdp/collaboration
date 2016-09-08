package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.Event;

public interface EventDao {
	void saveOrUpdate(Event event);

	void editEvent(Event event);
		
	void deleteEvent(Event event);
	
	Event get(String event_id);
		
		List<Event> list();
		
		Event getEventByName(String title);
}