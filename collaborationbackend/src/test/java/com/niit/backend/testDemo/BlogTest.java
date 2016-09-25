package com.niit.backend.testDemo;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.BlogCommentDao;
import com.niit.backend.Dao.BlogDao;
import com.niit.backend.model.Blog;
import com.niit.backend.model.BlogComment;

public class BlogTest {
public static void main(String args[]){
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.backend");
	context.refresh();
	
	Blog blog=(Blog) context.getBean("blog");
	BlogDao blogDao=(BlogDao) context.getBean("blogDao");
	blog.setCreatedAt(new Date());
	blog.setDesscription("hi your tested");
	blog.setStatus("approved");
	blog.setUserDetails_id("USR001");
	blog.setTitle("firstblog");
	blogDao.saveOrUpdate(blog);
	
	BlogComment blogComment=(BlogComment) context.getBean("blogComment");
	BlogCommentDao blogCommentDao=(BlogCommentDao) context.getBean("blogCommentDao");
	blogComment.setCom_createdAt(new Date());
	blogComment.setDescription("Awosome .......................... ");
	blogComment.setUserDetails_id("USR02");
	blogComment.setBlog(blog);
	blogCommentDao.saveOrUpdate(blogComment);
	
	BlogComment blogComment1=new BlogComment();
	BlogCommentDao blogCommentDao1=(BlogCommentDao) context.getBean("blogCommentDao");
	blogComment1.setCom_createdAt(new Date());
	blogComment1.setDescription("wow nice one........................ ");
	blogComment1.setUserDetails_id("USR021");
	blogComment1.setBlog(blog);
	blogCommentDao1.saveOrUpdate(blogComment1);
	
	BlogComment blogComment2=new BlogComment();
	BlogCommentDao blogCommentDao2=(BlogCommentDao) context.getBean("blogCommentDao");
	blogComment2.setCom_createdAt(new Date());
	blogComment2.setDescription("amaing................. ");
	blogComment2.setUserDetails_id("USR011");
	blogComment2.setBlog(blog);
	blogCommentDao2.saveOrUpdate(blogComment2);
	
	BlogComment blogComment3=new BlogComment();
	BlogCommentDao blogCommentDao3=(BlogCommentDao) context.getBean("blogCommentDao");
	blogComment3.setCom_createdAt(new Date());
	blogComment3.setDescription("verygood..........");
	blogComment3.setUserDetails_id("USR011");
	blogComment3.setBlog(blog);
	blogCommentDao3.saveOrUpdate(blogComment3);
	}
}
