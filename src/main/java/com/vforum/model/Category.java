package com.vforum.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "category")
public class Category {
	@Id
    @Column
	private int categoryId;
	@Column
	private String categoryName;
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="categoryId")
    private Set<Questions> questions;
	
//	create table category(categoryId int not null primary key,categoryName varchar(20));
//	mysql> insert into category values(1,"IT");
//
//	mysql> insert into category values(2,"HR");
//	
//
//	mysql> insert into category values(3,"TECHNICAL");
//	
//
//	mysql> insert into category values(4,"GENERAL");
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Set<Questions> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}
	
}