package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class VoterRegistrationServlet
 */
@WebServlet("/voter_register")
public class VoterRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		 try {
			userDao = new UserDaoImpl();
		} catch (Exception e) {
		    
			throw new  ServletException("err in init" + getClass() , e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try(PrintWriter pw = response.getWriter()){
        	// Accept first name , last name , email , password , dob from user.
        	
        	String fname =request.getParameter("fn");
        	String lname=request.getParameter("ln");
        	String email =request.getParameter("em");
        	String password =request.getParameter("pass");
        	LocalDate d=LocalDate.parse(request.getParameter("dob"));
        	Date dob= Date.valueOf(d);
        	
 
        	double age= Period.between(d,LocalDate.now()).getYears();
        	
        	try {
        		if(age>=21)
        		{
				String s=userDao.voterRegistration(new User(fname,lname,email,password,dob));
				pw.print(s);
        		}
        		else
        		{
        			pw.print("<h5>you are not eligible for voting <a href='login.html'>Retry</a></h5>");
        		}
			} catch (SQLException e) {
				throw new ServletException(e);
			}
        	
        }
	}

	

}
