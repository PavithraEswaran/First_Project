package com.vforum.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	    private static final long serialVersionUID = -3465813074586302847L;
	    @Id
	    @Column
	    private int employeeId;
	    @Column
	    private String employeeName;
	    @Column
	    private String employeeDesignation;
	    @Column
	    private String employeeLocation;
	    @Column
	    private String username;
	    @Column
	    private String password;
	    @OneToMany(cascade=CascadeType.ALL)
	    @JoinColumn(name="employeeId")
	    private Set<Questions> questions;
	    @OneToMany(cascade=CascadeType.ALL)
	    @JoinColumn(name="employeeId")
	    private Set<Answers> answers;
	    public Set<Answers> getAnswers() {
			return answers;
		}

		public void setAnswers(Set<Answers> answers) {
			this.answers = answers;
		}

		public Employee()
	    {
	    
	    }
	 
			 public int getEmployeeId() {
					return employeeId;
				}
		
		
				public Set<Questions> getQuestions() {
				return questions;
			}
		
			public void setQuestions(Set<Questions> questions) {
				this.questions = questions;
			}
	
			public void setEmployeeId(int employeeId) {
				this.employeeId = employeeId;
			}
	
	
			public String getEmployeeName() {
				return employeeName;
			}
	
	
			public void setEmployeeName(String employeeName) {
				this.employeeName = employeeName;
			}
	
	
			public String getEmployeeDesignation() {
				return employeeDesignation;
			}
	
	
			public void setEmployeeDesignation(String employeeDesignation) {
				this.employeeDesignation = employeeDesignation;
			}
	
	
			public String getEmployeeLocation() {
				return employeeLocation;
			}
	
	
			public void setEmployeeLocation(String employeeLocation) {
				this.employeeLocation = employeeLocation;
			}
	
	
			public String getUsername() {
				return username;
			}
	
	
			public void setUsername(String username) {
				this.username = username;
			}
	
	
			public String getPassword() {
				return password;
			}
	
	
			public void setPassword(String password) {
				this.password = password;
			}
	
	
		
		    
		}