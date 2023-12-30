package com.sil.Inventory.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.sil.Inventory.entity.UserInfo;
import com.sil.Inventory.model.LoginModel;
import com.sil.Inventory.model.UserInfoModel;
import com.sil.Inventory.repository.UserRepo;
import com.sil.Inventory.services.MyService;
import com.sil.Inventory.util.BaseResponse;

@Service
public class MyServiceImpl implements MyService{

	@Autowired
	UserRepo userRepo;
	
	
	  public UserInfo UserInfoModelToProductEntity(UserInfoModel request)
	  { 
		  UserInfo	user = new UserInfo(); 
		  BeanUtils.copyProperties(request, user); 
		  return user;
	  }
	  
	  @Override public BaseResponse insertUserInfo(UserInfoModel request) {
		  BaseResponse baseresponse= new BaseResponse(); 
		  if (request !=null) {	  
				  try { 
					  UserInfo obj=UserInfoModelToProductEntity(request);
					  userRepo.save(obj); 
					  baseresponse.setMessage("user created successfully");
				  } 
				  catch(Exception e) 
				  { 
					  e.printStackTrace(); 
				  }
				  
				  return baseresponse;
	  
	  }
	  
	  else { baseresponse.setMessage("error"); return baseresponse; }
	  
	  
	  }

	@Override
	public BaseResponse loginUser(LoginModel request) {

		BaseResponse baseresponse=new BaseResponse();
		UserInfo user=userRepo.findUserByUserName(request.getUsername());
		
		if (request.getUsername()==user.getUsername()){
			
			if(request.getPassword()==user.getPassword()) {
				baseresponse.setMessage("success");
			}
		}
		else
		{
			baseresponse.setMessage("error");
		}
		
		return baseresponse;
	}
	 

}
