package com.niit.backend.testDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.ForumPostDao;
import com.niit.backend.model.ForumPost;

public class ForumPostTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();

		ForumPost forumPost=(ForumPost) context.getBean("forumPost");
		ForumPostDao forumPostDao=(ForumPostDao) context.getBean("forumPostDao");
	 forumPostDao.deleteForumPostById("FRMPSTC82B26");
		
	}
}
