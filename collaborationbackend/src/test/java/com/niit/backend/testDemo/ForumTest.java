package com.niit.backend.testDemo;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.ForumDao;
import com.niit.backend.Dao.ForumPostDao;
import com.niit.backend.Dao.PostCommentDao;
import com.niit.backend.model.Forum;
import com.niit.backend.model.ForumPost;
import com.niit.backend.model.PostComment;

public class ForumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		 Date date=new Date();
	     long time = date.getTime();
	     Timestamp timeStamp=new Timestamp(time);
		
		Forum forum=(Forum) context.getBean("forum");
		ForumDao forumDao=(ForumDao) context.getBean("forumDao");
		forum.setCreatedAt(timeStamp);
		forum.setDescription("helloo every one what going on");
		forum.setTitle("First forum test");
		forum.setUserDetails_id("USR003");
		forumDao.saveOrUpdate(forum);
		
		ForumPost forumPost=(ForumPost) context.getBean("forumPost");
		ForumPostDao forumPostDao=(ForumPostDao) context.getBean("forumPostDao");
		forumPost.setCreatedAt(timeStamp);
		forumPost.setForum(forum);
		forumPost.setForumDescription("this is  first post of Forum");
		forumPost.setUserDetails_id("USR004");
		forumPostDao.saveOrUpdate(forumPost);
		
		PostComment postComment=(PostComment) context.getBean("postComment");
		PostCommentDao postCommentDao=(PostCommentDao) context.getBean("postCommentDao");
		postComment.setCreatedAt(timeStamp);
		postComment.setForumPost(forumPost);
		postComment.setUserDetails_id("USR006");
		postComment.setDescription("hi this is yours post nice");
		postComment.setForumPost(forumPost);
		postCommentDao.saveOrUpdate(postComment);
	}

}
