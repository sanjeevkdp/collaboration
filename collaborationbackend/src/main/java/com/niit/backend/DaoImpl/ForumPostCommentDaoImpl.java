package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.ForumPostCommentDao;
import com.niit.backend.model.ForumPostComment;
@Repository("ForumPostCommentDao")
@Transactional
public class ForumPostCommentDaoImpl implements ForumPostCommentDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveOrUpdate(ForumPostComment forumPostComment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteForumPostComment(ForumPostComment forumPostComment) {
		// TODO Auto-generated method stub

	}

	@Override
	public ForumPostComment getById(String forumPostComment_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ForumPostComment> listAllPostComments() {
		// TODO Auto-generated method stub
		return null;
	}

}
