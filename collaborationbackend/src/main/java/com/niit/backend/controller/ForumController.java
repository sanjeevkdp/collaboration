package com.niit.backend.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.Dao.ForumDao;
import com.niit.backend.model.Forum;

@RestController
public class ForumController {
	@Autowired
	Forum forum;
	@Autowired
	ForumDao forumDao;
	 Date date=new Date();
     long time = date.getTime();
     Timestamp timeStamp=new Timestamp(time);
     //------------------------------fetchAllForum---------------------------
     @RequestMapping(value = "/forums", method = RequestMethod.GET)
 	public ResponseEntity<List<Forum>> listAllBlog(){
 		List<Forum> forums = forumDao.listAllForums();
 		if(forums.isEmpty()){
             return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
         }
         return new ResponseEntity<List<Forum>>(forums, HttpStatus.OK);
 	}
 	

}
