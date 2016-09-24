package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.ForumPostComment;

public interface ForumPostCommentDao {

	void saveOrUpdate(ForumPostComment forumPostComment);
		
	void deleteForumPostComment(ForumPostComment forumPostComment);
	
	ForumPostComment getById(String forumPostComment_id);
		
		List<ForumPostComment> listAllPostComments();
		
		
}
