package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.ForumPostDao;
import com.niit.backend.model.ForumPost;
import com.niit.backend.model.PostComment;
@Repository("forumPostDao")
@Transactional
public class ForumPostDaoImpl implements ForumPostDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveOrUpdate(ForumPost forumPost) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(forumPost);

	}

	@Override
	public void editForum(ForumPost forumPost) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteForum(ForumPost forumPost) {
		// TODO Auto-generated method stub

	}

	@Override
	public ForumPost get(String forumPost_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ForumPost> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
