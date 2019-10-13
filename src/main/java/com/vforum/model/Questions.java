package com.vforum.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "questions")
public class Questions implements Serializable {
	private static final long serialVersionUID = -3465813074586302847L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int questionId;
	@Column
	private String questionDescription;
	@Column
	private Date date;
	@ManyToOne
	@JoinColumn(name ="employeeId")
	private Employee employee;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="answerId")
	private Set<Answers> answerId;
	@ManyToOne
	@JoinColumn(name ="categoryId")
	private Category category;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
//	create table questions( questionId int not null primary key auto_increment,
//	questionDescription  varchar(2000), date date,employeeId int,categoryId int, FOREIGN KEY (employeeId) 
//	REFERENCES Employee(employeeId),  FOREIGN KEY (categoryId) 
//REFERENCES Category(categoryId));
	public Set<Answers> getAnswerId() {
		return answerId;
	}
	
	public void setAnswerId(Set<Answers> answerId) {
		this.answerId = answerId;
	}

	public int getQuestionId() {
		return questionId;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	}