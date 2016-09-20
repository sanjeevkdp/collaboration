package com.niit.backend.testDemo;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.EventDao;
import com.niit.backend.model.Event;

public class EventTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		Event event=(Event) context.getBean("event");
		EventDao eventDao=(EventDao) context.getBean("eventDao");
		event.setCreatedAt(new Date());
		event.setDescription("about somethingt");
		event.setEventName("some news");
		eventDao.saveOrUpdate(event);
		
		
		event.setCreatedAt(new Date());
		event.setDescription("holidays");
		event.setEventName("some news");
		eventDao.saveOrUpdate(event);
		
		event.setCreatedAt(new Date());
		event.setDescription("friendship day");
		event.setEventName("some news");
		eventDao.saveOrUpdate(event);
	}

}
