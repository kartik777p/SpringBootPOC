package com.neosoft.Model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentId;
	
	
	@NotNull
	@Size(max=55)
	@Column(name="first_name")
	private String firstName;
	

	@NotNull
	@Size(max=55)
	@Column(name="last_name")
	private String lastName;
	

	@NotNull
	@Size(max=12)
	@Column(name="mobile_no")
	private String mobileNo;
	

	@NotNull
	@Size(max=55)
	@Column(name="email_address")
	private String emailAddress;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;

}
