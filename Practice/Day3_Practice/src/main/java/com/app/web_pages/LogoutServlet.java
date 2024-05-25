package com.app.web_pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter out=response.getWriter()) {
			HttpSession hs=request.getSession();
			
			out.print("<h5>You have already voted !!!!!!!!!</h5>");
			
			hs.invalidate();
			out.print("<h5>You have logged out....</h5>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			HttpSession hs=request.getSession();
			User user=(User) hs.getAttribute("user_info");
			UserDaoImpl ud=(UserDaoImpl) hs.getAttribute("user_dao");
			CandidateDaoImpl cd=(CandidateDaoImpl) hs.getAttribute("candidate_dao");
			pw.print("<h5>Hello , "+user.getfName()+" "+user.getlName()+"</h5>");
			int cid=Integer.parseInt(request.getParameter("candidate_id")) ;
			pw.print("<h5>"+ud.updateVotingStatus(user.getId())+"</h5>");
			
			pw.print("<h5>"+cd.incrementCandidateVotes(cid)+"</h5>");
			
			
			hs.invalidate();
			pw.print("You have logout sucessfully");
		}
		catch (Exception e) {
			throw new ServletException("err in do-post of "+getClass(), e);
		}
		}

}
