package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.Candidate;
import com.app.entities.User;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//2. get PW
		try(PrintWriter pw=response.getWriter()) {
			//3. get http session from wc
			HttpSession hs=request.getSession();
			//4. get -- user details n daos
			User user=(User) hs.getAttribute("user_info");
			pw.print("<h5>Hello , "+user.getFirstName()+" "+user.getLastName()+"</h5>");
			UserDaoImpl userDao=(UserDaoImpl)hs.getAttribute("user_dao");
			CandidateDaoImpl candidateDao=(CandidateDaoImpl)hs.getAttribute("candidate_dao");
			List<Candidate> lst=candidateDao.displayTopTwoCandidates();
			pw.print("<h5>Top Two Candidates By Votes Are: </h5>");
			lst.forEach(s -> pw.print(s + "\n") );
			
			//8. discard http session
			hs.invalidate();
			pw.print("<h5>You have successfully logout from session...Thanks for visiting the site...Kindly visit again</h5>");
		} catch (Exception e) {
			throw new ServletException("err in do-post of "+getClass(), e);
		}
	}
	}


