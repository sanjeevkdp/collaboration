package com.niit.backend.testDemo;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.BlogCommentDao;
import com.niit.backend.model.Blog;
import com.niit.backend.model.BlogComment;

public class BlogCommentTest {
	public static void main(String args[]){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		
	    Blog blog= (Blog) context.getBean("blog");
	    
		BlogComment blogComment=(BlogComment) context.getBean("blogComment");
		BlogCommentDao blogCommentDao=(BlogCommentDao) context.getBean("blogCommentDao");
		blogComment.setCom_createdAt(new Date());
		blogComment.setDescription("wow nice one ");
		blogComment.setUserDetails_id("USR01");
		blogComment.setBlog(blog);
		blogCommentDao.saveOrUpdate(blogComment);
	}
}
