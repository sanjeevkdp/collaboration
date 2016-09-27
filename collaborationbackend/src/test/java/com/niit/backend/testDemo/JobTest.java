package com.niit.backend.testDemo;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.JobOpportunitiesDao;
import com.niit.backend.model.JobOpportunities;

public class JobTest {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		Date date =new Date();
		long time=date.getTime();
		Timestamp timeStamp=new Timestamp(time);
		JobOpportunities jobOpportunities=(JobOpportunities) context.getBean("jobOpportunities");
		JobOpportunitiesDao jobOpportunitiesDao=(JobOpportunitiesDao) context.getBean("jobOpportunitiesDao");
		jobOpportunities.setCreatedAt(timeStamp);
		jobOpportunities.setDescription("this fist job posted to developer");
		jobOpportunities.setTitle("Post to IT ");
		System.out.print("jobOpporunities---------------------------------------------"+jobOpportunities);
		jobOpportunitiesDao.saveOrUpdate(jobOpportunities);
	}
}
