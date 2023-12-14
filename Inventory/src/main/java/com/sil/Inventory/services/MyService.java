package com.sil.Inventory.services;

import org.springframework.stereotype.Service;

import com.sil.Inventory.model.UserInfoModel;
import com.sil.Inventory.util.BaseResponse;

@Service
public interface MyService {
	BaseResponse insertUserInfo(UserInfoModel request);
	
	
	
	

}
