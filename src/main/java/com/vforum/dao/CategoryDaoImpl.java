package com.vforum.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vforum.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	 @Autowired
	    private SessionFactory sessionFactory;
	

	public Category getCategoryById(int categoryId) {
		 return (Category) sessionFactory.getCurrentSession().get(
	                Category.class, categoryId);
	}

}