package com.niit.backend.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

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

import com.niit.backend.Dao.BlogCommentDao;
import com.niit.backend.Dao.BlogDao;
import com.niit.backend.model.Blog;
import com.niit.backend.model.BlogComment;
import com.niit.backend.model.ModelClass;
@RestController
public class SingleBlogController {
	@Autowired
	Blog blog;
	@Autowired
	BlogDao blogDao;
	@Autowired
	BlogComment blogComment;
	@Autowired
	BlogCommentDao blogCommentDao;
	 Date date=new Date();
     long time = date.getTime();
     Timestamp timeStamp=new Timestamp(time);
	
	//------------------------------fetchsingleblog---------------------------
    @RequestMapping(value="/blogs/blogView/{blog_id}",method=RequestMethod.GET)
    public ResponseEntity<Blog> listSingleBlog(@PathVariable String blog_id){
   	 Blog singleBlog=blogDao.findById(blog_id);
   	 return new ResponseEntity<Blog>(singleBlog, HttpStatus.OK); 
   	 
    }
    
    //-------------------Create a blogComment--------------------------------------------------------
    
	  @RequestMapping(value = "/blogs/blogView", method = RequestMethod.POST)
	  public ResponseEntity<Void> createblogComment(@RequestBody ModelClass modelClass,UriComponentsBuilder ucBuilder) {
	      System.out.println("Creating blogComment " + blog);
	      System.out.println("Creating blogComment " + blogComment.getDescription());
	      
	     /* if (blogCommentDao.isForumExist(blogComment)) {
	          System.out.println("A blog with title " + blog.getTitle() + " already exist");
	          return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	      }*/
	      blogComment.setBlogComment_id("BLGCMT"+UUID.randomUUID().toString().substring(30).toUpperCase());
	      blogComment.setCom_createdAt(timeStamp);
	      blogComment.setBlog(modelClass.getBlog());
	      blogComment.setDescription(modelClass.getBlog_comments());
	      blogComment.setUserDetails_id("USR007");
	      blogCommentDao.saveOrUpdate(blogComment);
	      HttpHeaders headers = new HttpHeaders();
	      headers.setLocation(ucBuilder.path("/blogs/{blog_id}").buildAndExpand(blog.getBlog_id()).toUri());
	      return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	  }

}
