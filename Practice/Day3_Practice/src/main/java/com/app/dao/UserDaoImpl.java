package com.app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.entities.User;
import static com.app.utils.DBUtils.*;

public class UserDaoImpl implements UserDao {
	private Connection c;
	private PreparedStatement pst1,pst2;
	public UserDaoImpl() throws SQLException
	{
		c = getConnection();
		pst1=c.prepareStatement("select * from users where email=? and password=?");
		pst2=c.prepareStatement("Update users set status=1 where id=? ");
	}

	@Override
	public User signIn(String email, String password) throws SQLException {
		pst1.setString(1,email);
		pst1.setString(2, password);
		
		try(ResultSet rst=pst1.executeQuery()) {
			if(rst.next())
			{
				return new User(rst.getInt(1),rst.getString(2),rst.getString(3),email,password, rst.getDate(6), rst.getBoolean(7),
						rst.getString(8));
			}
			
		} 
		return null;
	}
	@Override
	public String updateVotingStatus(int cid) throws SQLException {
		pst2.setInt(1, cid);
		try {
			int r=pst2.executeUpdate();
			if(r==1)
			{
				return "You have casted vote succesfully";
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "Something went wrong please try again later";
		
		
	}

	
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
		{
			pst1.close();
		}
		closeConnection();
	}

	
}
