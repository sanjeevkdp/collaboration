//------------------- Update a UserDetails--------------------  String hql = "from UserDetails where userDetails_id=" + "'" + userDetails_id + "'";
        Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
        List<UserDetails> listUserDetails = (List<UserDetails>) query.getResultList();
        if (listUserDetails  != null && !listUserDetails .isEmpty()) {
            return listUserDetails.get(0);