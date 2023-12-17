package com.sil.Inventory.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_info", indexes = {@Index(name = "index_user_id",  columnList="userId", unique = true)})
public class UserInfo {
	@Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "userId",
            updatable = true
    )
    private Long id;
private String username;	
private String email;
private String phone;
private Date CreatedDate = new Date();
private String password;
private Date dob = new Date();	
private String blood;
private String address;


	

}
