package com.app.dao;

import static com.app.utils.DBUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.entities.Candidates;

public class CandidateDaoImpl implements CandidateDao {
	private Connection c;
	private PreparedStatement pst1,pst2,pst4,pst5;
	public CandidateDaoImpl() throws SQLException
	{
		 c=getConnection();
		 pst1=c.prepareStatement("Select * from candidates");
		 
		 pst2 = c.prepareStatement("update candidates set votes=votes+1 where id=?");
		 pst4=c.prepareStatement("select * from candidates order by votes desc limit 2");
		 pst5=c.prepareStatement("select party,sum(votes) from candidates group by party");
	}

	@Override
	public List<Candidates> getAllCandidates(){
		List<Candidates>lst=new ArrayList<>();
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
			{
				lst.add(new Candidates(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return lst;
	}

	
	@Override
	public String incrementCandidateVotes(int candidateId) throws SQLException {
		
		pst2.setInt(1, candidateId);
		int updateCount = pst2.executeUpdate();
		if (updateCount == 1)
			return "Votes updated...";
		return "Votes updation failed !!!!!!!!!!!!";
	}

	@Override
	public List<Candidates> topTwoCandidates() throws SQLException {
		List<Candidates>lst=new ArrayList<>();
		try (ResultSet rst = pst4.executeQuery()) {
			while (rst.next())
				lst.add(new Candidates(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return lst;

	}

	@Override
	public Map<String, Integer> displayPoliticalPartywiseVotes()throws SQLException {
		Map<String,Integer>map=new HashMap<>();
		try (ResultSet rst = pst5.executeQuery()) {
			while (rst.next())
				map.put(rst.getString(1), rst.getInt(2));
		}
		return map;
		
	}
	
	

}
