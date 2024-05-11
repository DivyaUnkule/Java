package com.app.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.Candidate;

import static com.app.utils.DBUtils.*;
public class CandidateDaoImpl implements CandidateDao {
	
	private Connection cn;
	private PreparedStatement pst1,pst2;
	
	public CandidateDaoImpl() throws SQLException
	{
		cn=openConnection();
		pst1=cn.prepareStatement("select * from candidates");
		pst2=cn.prepareStatement("update Candidates set votes=votes+1 where id = ?");
		
	}
	
	@Override
	public List<Candidate> getCandidateDetails()throws SQLException
	{
		List<Candidate>lst=new ArrayList<>();
		
	try(ResultSet rst= pst1.executeQuery())
		{
		while(rst.next())
		{
			lst.add(new Candidate(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4)));
		}
			
		}
	return lst;
	
	}
	@Override
	public String incrementCandidateVotes(int id) throws SQLException
	{
		pst2.setInt(1, id);
		int row = pst2.executeUpdate();
		if(row==1)
		{
			return "Candidate votes updated successfully";
		}
		
		return "Candidate votes are not updated successfully";
	}
	
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		if(pst2 != null)
			pst2.close();
		closeConnection();
	}

}
