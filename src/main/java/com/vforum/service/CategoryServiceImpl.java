package com.vforum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vforum.dao.CategoryDao;

import com.vforum.model.Category;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	  	@Autowired
	    private CategoryDao categoryDAO;
	  	
	  	public Category getCategoryById(int categoryId) {
	        return categoryDAO.getCategoryById(categoryId);
	}
	  	
	  	 public void setCategoryDAO(CategoryDao categoryDAO) {
		        this.categoryDAO = categoryDAO;
		    
		 
		}

}