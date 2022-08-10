package com.Esraa.project.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "managers")
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch =
	// FetchType.LAZY)
	// private List<Student> students;

	// @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch =
	// FetchType.LAZY)
	// private List<Teacher> teachers;

	// @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch =
	// FetchType.LAZY)
	// private List<Guardians> guardians;

	// @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch =
	// FetchType.LAZY)
	// private List<Subject> Subject;

	// @NotEmpty(message = "First name is required")
	// @Size(min = 3, max = 30, message = "First name must be between 3 and 30
	// characters")
	// private String fname;

	// @NotEmpty(message = "Last name is required!")
	// @Size(min = 3, max = 30, message = "Last name must be between 3 and 30
	// characters")
	// private String lname;

	// @NotEmpty(message = "Last name is required!")
	@Size(min = 3, max = 30, message = "userName must be between 3 and 30 characters")
	private String userName;

	// @NotEmpty(message = "Email is required!")
	// @Email(message = "Please enter a valid email!")
	// private String email;

	// @NotEmpty(message = "Password is required!")
	@Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
	private String password;

	@Transient
	// @NotEmpty(message = "Confirm Password is required!")
	@Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters")
	private String confirm;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	public Manager() {

	}

	public Long getId() {
		return id;
	}

	// public List<Student> getStudent() {
	// return student;
	// }

	// public void setStudent(List<Student> student) {
	// this.student = student;
	// }

	// public List<Teacher> getTeacher() {
	// return teacher;
	// }

	// public void setTeacher(List<Teacher> teacher) {
	// this.teacher = teacher;
	// }

	// public List<Guardians> getGuardians() {
	// return guardians;
	// }

	// public void setGuardians(List<Guardians> guardians) {
	// this.guardians = guardians;
	// }

	// public List<Subject> getSubject() {
	// return Subject;
	// }

	// public void setSubject(List<Subject> subject) {
	// Subject = subject;
	// }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	// public String getFname() {
	// return fname;
	// }

	// public void setFname(String fname) {
	// this.fname = fname;
	// }

	// public String getLname() {
	// return lname;
	// }

	// public void setLname(String lname) {
	// this.lname = lname;
	// }

	// public String getEmail() {
	// return email;
	// }

	// public void setEmail(String email) {
	// this.email = email;
	// }

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

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
