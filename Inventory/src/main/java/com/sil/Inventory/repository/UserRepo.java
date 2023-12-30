package com.sil.Inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sil.Inventory.entity.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Long> {
	
	
	@Query("select e.username, password from UserInfo e  where e.username=:username")
	 UserInfo findUserByUserName(String username);
}
