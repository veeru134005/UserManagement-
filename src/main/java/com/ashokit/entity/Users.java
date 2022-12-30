package com.ashokit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class Users {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer userId;

	@Column(name = "FirstName", nullable = false)
	private String firstName;

	@Column(name = "LastName", nullable = false)
	private String lastName;

	@Column(name = "Email", unique = true, nullable = false)
	private String email;

	@Column(name = "PhoneNumber", nullable = false)
	private Long phoneNumber;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YYYY")
	private Date dob;

	@Column(name = "Gender", nullable = false)
	private String gender;

	@Column(name = "Country", nullable = false)
	private String country;

	@Column(name = "State", nullable = false)
	private String state;

	@Column(name = "City", nullable = false)
	private String city;

	private String password;

	private boolean isUserUnlock;

}
