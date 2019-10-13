package com.vforum.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name = "answers")
	public class Answers implements Serializable {
		private static final long serialVersionUID = -3465813074586302847L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	    @Column
	    private int answerId;
		@Column
		private String answerDescription;	
		@Column
		private Date date;
		@ManyToOne
		@JoinColumn(name ="questionId")
		private Questions question;
		
		@ManyToOne
		@JoinColumn(name ="employeeId")
		private Employee employee;
//		create table answers( answerId int not null primary key auto_increment,
//		answerDescription  varchar(2000), date date, employeeId int,questionId int, FOREIGN KEY (employeeId) 
//		REFERENCES Employee(employeeId),  FOREIGN KEY (questionId) 
//		REFERENCES questions(questionId));
		public int getAnswerId() {
			return answerId;
		}
		public void setAnswerId(int answerId) {
			this.answerId = answerId;
		}
		public String getAnswerDescription() {
			return answerDescription;
		}
		public void setAnswerDescription(String answerDescription) {
			this.answerDescription = answerDescription;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public Employee getEmployee() {
			return employee;
		}
		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
		public Questions getQuestion() {
			return question;
		}
		public void setQuestion(Questions question) {
			this.question = question;
		}
		
		}