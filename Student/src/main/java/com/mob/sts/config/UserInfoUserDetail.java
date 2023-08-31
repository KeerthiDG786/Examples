package com.mob.sts.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.mob.sts.module.UserInfo;
import com.mob.sts.repository.UserInterface;

@Component
public class UserInfoUserDetail implements UserDetailsService {

	@Autowired
	UserInterface userInterface;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo=userInterface.findByName(username);
		if(userInfo==null)
		{
			System.out.println("no user found");
		}
		return new UserPrinciple(userInfo) ;
	}

}
