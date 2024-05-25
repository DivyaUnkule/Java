package com.app.web_pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDaoImpl;
import com.app.entities.Candidates;
import com.app.entities.User;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession hs=request.getSession();
		CandidateDaoImpl cd=(CandidateDaoImpl) hs.getAttribute("candidate_dao");
		try(PrintWriter pw=response.getWriter())
		{
			User u=(User) hs.getAttribute("user_info");
			pw.print(u.getfName()+" , Welcome to Admin Page");
			pw.print("Top Two candidate list");
			List<Candidates>lst=cd.topTwoCandidates();
			lst.forEach(s->pw.print(s));
			pw.print("Political partywise total votes");
			Map<String,Integer>map=cd.displayPoliticalPartywiseVotes();
			map.forEach((k,v)->pw.print(k + "," + v));
			hs.invalidate();
			pw.print("<h5>You have logout succesfully..Thanks for visiting<a href='login.html'>Visit Again</a><h5>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
