package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.ForumDao;
import com.niit.backend.model.Forum;
@Repository("forumDao")
@Transactional
public class ForumDaoImpl implements ForumDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveOrUpdate(Forum forum) {
		// TODO Auto-generated method stub
      sessionFactory.getCurrentSession().saveOrUpdate(forum);
	}

	@Override
	public List<Forum> listAllForums() {
		// TODO Auto-generated method stub
		String hql="from Forum";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Forum> listForum=query.getResultList();
		return listForum;
	}

	@Override
	public Forum findByName(String title) {
		// TODO Auto-generated method stub
		String hql = "from Forum where title=" + "'" + title + "'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Forum> listForum = (List<Forum>) query.getResultList();
		if (listForum  != null && !listForum .isEmpty()) {
			return listForum.get(0);
		}
		return null;
	}

	@Override
	public boolean isForumExist(Forum forum) {
		// TODO Auto-generated method stub
		return findByName(forum.getTitle())!=null;
	}

	@Override
	public Forum findById(String forum_id) {
		// TODO Auto-generated method stub
		String hql = "from Forum where forum_id=" + "'" + forum_id + "'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Forum> listForum = (List<Forum>) query.getResultList();
		if (listForum  != null && !listForum .isEmpty()) {
			return listForum.get(0);
		}
		return null;
	}

	@Override
	public void deleteForumById(String forum_id) {
		// TODO Auto-generated method stub
		Forum forumToDelete = new Forum();
		forumToDelete.setForum_id(forum_id);
		sessionFactory.getCurrentSession().delete(forumToDelete);
	}

	@Override
	public void deleteAllForums() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Forum> listSingleForum() {
		// TODO Auto-generated method stub
	
		return null;
	}

}
