package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.BlogDao;
import com.niit.backend.model.Blog;
@Repository("blogDao")
@Transactional
public class BlogDaoImpl implements BlogDao {
@Autowired
SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(Blog blog) {
		// TODO Auto-generated method stub
        sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}

	@Override
	public void editBlog(Blog blog) {
		// TODO Auto-generated method stub

	}

	@Override
	public Blog get(String blog_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> listAllBlog() {
		// TODO Auto-generated method stub
		/*@SuppressWarnings("unchecked")
		
		List<Blog> listBlog  = (List<Blog>) sessionFactory.getCurrentSession()
		.createCriteria(Blog.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listBlog;*/
		String hql="from Blog";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Blog> listBlog=query.getResultList();
		return listBlog;
	}

	@Override
	public Blog getBlogByName(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
