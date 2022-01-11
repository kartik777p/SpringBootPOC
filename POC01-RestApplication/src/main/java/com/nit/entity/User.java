package com.nit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NEO_POC_USER")
public class User implements Serializable {  //recomanded to impl bcz if any case our inMemory
	                                                                      //cache is filled up then hibernate uses Hard disk to save the cache
	                                                                    //and we can write only Selializable obj data into file or other place
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Size(max = 30)
    private Integer uId;
	//@Size(max = 30)
	@NotNull(message = "First Name must be Given ")
    private String firstName;
	//@Size(max = 30)
	@NotNull(message = "Last Name must be Given ")
    private String lastName;
	//@Size(max = 30)
	@NotNull(message = "address must be Given ")
    private String addrs;
	//@NotNull(message = "First Name must be Given ")
    private Date dob;
	//@Size(max = 30)
    private Date doj;
	//@Size(max = 30)
    @NotNull(message = "Pin code must be Given ")
    private Long pinCode;
    //
    private int deleted;
}
