
package com.mob.sts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mob.sts.module.UserInfo;


public interface UserInterface extends JpaRepository<UserInfo, Integer>{
	
	UserInfo  findByName(String name);

}
