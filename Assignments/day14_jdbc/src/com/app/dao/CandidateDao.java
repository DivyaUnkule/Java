package com.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.entities.Candidate;



public interface CandidateDao {
	public List<Candidate> getCandidateDetails()throws SQLException;
	public String incrementCandidateVotes(int id) throws SQLException;

}
