package com.app.dao;

import java.sql.SQLException;

import com.app.entities.User;

public interface UserDao {
	public User signIn(String email,String password) throws SQLException;
	
}
