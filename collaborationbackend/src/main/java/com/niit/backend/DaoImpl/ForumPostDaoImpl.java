package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.ForumPostDao;
import com.niit.backend.model.ForumPostComment;
@Repository("ForumPostDao")
@Transactional
public class ForumPostDaoImpl implements ForumPostDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveOrUpdate(ForumPostComment forumPostComment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editForum(ForumPostComment forumPostComment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteForum(ForumPostComment forumPostComment) {
		// TODO Auto-generated method stub

	}

	@Override
	public ForumPostComment get(String forumPostComment_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ForumPostComment> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
