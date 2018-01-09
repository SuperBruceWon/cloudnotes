package com.tedu.cloudnotes.dao;

import com.tedu.cloudnotes.entity.User;

public interface UserDao {
	public void save(User user);
	
	public User findByName(String name);

}
