package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.AuthoritiesDao;
import com.niit.backend.model.Authorities;
@Repository("AuthoritiesDao")
public class AuthoritiesDaoImpl implements AuthoritiesDao {

	@Autowired
	private SessionFactory sessionFactory;


	@Transactional
	public void saveOrUpdate(Authorities authorities) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(authorities);

	}

	@Transactional
	public void editAuthorities(Authorities authorities) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(authorities);
	}

	@Transactional
	public Authorities get(String authorities_id) {
		// TODO Auto-generated method stub
		//return sessionFactory.getCurrentSession().get(Authorities.class, authorities_id);
		String hql = "from Authorities where authorities_id=" + "'" + authorities_id + "'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Authorities> listAuthorities= (List<Authorities>) query.getResultList();
		if (listAuthorities!= null && !listAuthorities.isEmpty()) {
			return listAuthorities.get(0);
		}
		return null;
	}

	@Transactional
	public List<Authorities> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Authorities> listAuthorities= (List<Authorities>) sessionFactory.getCurrentSession()
		.createCriteria(Authorities.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listAuthorities;
	}

	
}
