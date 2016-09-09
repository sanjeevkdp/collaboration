package com.niit.backend.testDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.BlogDao;
import com.niit.backend.model.Blog;

public class BlogTest {
public static void main(String args[]){
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.backend");
	context.refresh();
	Blog blog=(Blog) context.getBean("blog");
	BlogDao blogDao=(BlogDao) context.getBean("blogDao");
	blog.setCreatedAt("12/9/16");
	blog.setDesscripti("hi your tested");
	blog.setNoOfComment("12");
	blog.setStatus("approved");
	blog.setUserDetails_id("USR001");
	blog.setTitle("firstblog");
	blogDao.saveOrUpdate(blog);
	
	}
}
