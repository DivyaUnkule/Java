package com.app.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.app.entities.Candidates;

public interface CandidateDao {
	List<Candidates> getAllCandidates();
	
	String incrementCandidateVotes(int nv)throws SQLException;
	List<Candidates> topTwoCandidates()throws SQLException;
	Map<String,Integer> displayPoliticalPartywiseVotes()throws SQLException;
	
	
}
