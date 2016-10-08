JobOpportunities jobOportunitiesToDelete = new JobOpportunities();
        jobOportunitiesToDelete.setForum_id(jobOportunities_id);
        sessionFactory.getCurrentSession().delete(jobOportunitiesToDelete);