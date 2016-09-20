package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.ForumDao;
import com.niit.backend.model.Forum;
@Repository("ForumDao")
@Transactional
public class ForumDaoImpl implements ForumDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveOrUpdate(Forum forum) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editForum(Forum forum) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteForum(Forum forum) {
		// TODO Auto-generated method stub

	}

	@Override
	public Forum get(String forum_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Forum> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Forum getForumByName(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
