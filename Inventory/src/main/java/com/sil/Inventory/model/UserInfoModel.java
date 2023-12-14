package com.sil.Inventory.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserInfoModel {
	private Long id;
	private String username;	
	private String email;
	private String phone;
//	private Date CreatedDate;
	private String Password;
//	private Date dob;	
	private String blood;
	private String address;
}
