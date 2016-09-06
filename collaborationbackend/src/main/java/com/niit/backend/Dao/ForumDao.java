package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.Forum;

public interface ForumDao {
	
	void saveOrUpdate(Forum forum);

	void editForum(Forum forum);
		
	void deleteForum(Forum forum);
	
	Forum get(String forum_id);
		
		List<Forum> list();
		
		Forum getForumByName(String title);
}
