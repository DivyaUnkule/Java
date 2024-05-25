package com.app.dao;

import java.sql.SQLException;
import java.util.Map;

import com.app.entities.User;

public interface UserDao {
	
	User signIn(String eamil,String password)throws SQLException;
	String updateVotingStatus(int cid)throws SQLException;
	

}
