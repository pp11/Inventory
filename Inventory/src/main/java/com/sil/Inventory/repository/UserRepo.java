package com.sil.Inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sil.Inventory.entity.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Long> {

}
