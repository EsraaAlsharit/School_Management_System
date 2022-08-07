package com.Esraa.project.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "First name is required!")
	@Size(min = 3, max = 30, message = "First name must be between 3 and 30 characters")
	private String fname;

	@NotEmpty(message = "Last name is required!")
	@Size(min = 3, max = 30, message = "Last name must be between 3 and 30 characters")
	private String lname;

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
}
