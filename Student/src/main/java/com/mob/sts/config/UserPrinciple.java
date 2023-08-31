package com.mob.sts.config;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mob.sts.module.UserInfo;

public class UserPrinciple implements UserDetails, UserDatabase {
    
	@Autowired
	UserInfo userInfo;
	
	
	
	public UserPrinciple(UserInfo userInfo) {
		super();
		this.userInfo = userInfo;
	}

	@Override
	public Iterator<Group> getGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Role> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Group createGroup(String groupname, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role createRole(String rolename, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(String username, String password, String fullName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group findGroup(String groupname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findRole(String rolename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void open() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeGroup(Group group) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRole(Role role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userInfo.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userInfo.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
