package com.Esraa.project.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "guardians")
public class Guardians {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 @NotNull(message="please enter your first name")
	 @Size(min = 3, max = 10, message ="first name need tb be between 3 and 10")
	 private String fName;
	 
	 @NotNull(message ="please enter your first name")
	 @Size(min = 3, max =10 , message ="Last naem should be between 3 and 10")
	 private String lName;
	 
		@NotEmpty(message = "Email is required!")
		@Email(message = "Please enter a valid email!")
		private String email;

		@NotEmpty(message = "Password is required!")
		@Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
		private String password;
		
		@Transient
		@NotEmpty(message = "Confirm Password is required!")
		@Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters")
		private String confirm;
		
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
		public String getfName() {
			return fName;
		}
		public void setfName(String fName) {
			this.fName = fName;
		}
		public String getlName() {
			return lName;
		}
		public void setlName(String lName) {
			this.lName = lName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirm() {
			return confirm;
		}
		public void setConfirm(String confirm) {
			this.confirm = confirm;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		public Long getId() {
			return id;
		}
		public Guardians() {
		
		}
	
}