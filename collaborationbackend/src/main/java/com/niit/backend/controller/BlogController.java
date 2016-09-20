package com.niit.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.Dao.BlogDao;
import com.niit.backend.model.Blog;

@RestController
public class BlogController {
	@Autowired
	BlogDao blogDao;
	
	@RequestMapping(value = "/blogs", method = RequestMethod.GET)
	public ResponseEntity<List<Blog>> listAllBlog(){
		List<Blog> blogs = blogDao.listAllBlog();
		if(blogs.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
	}
}
