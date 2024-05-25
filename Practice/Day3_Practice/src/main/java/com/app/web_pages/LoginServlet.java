package com.app.web_pages;

import static com.app.utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class Login
 */
//@WebServlet(value="/login" , loadOnStartup=1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userdao; 
    private CandidateDaoImpl candidateDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("Inside init");
		ServletConfig config = getServletConfig();
		try {
			openConnection(config.getInitParameter("db_url"),config.getInitParameter("username"),config.getInitParameter("password"));
			userdao=new UserDaoImpl();
			candidateDao=new CandidateDaoImpl();
		} catch (Exception e) {
			throw new ServletException("Error in init() "+getClass(), e);
			
		}
		}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userdao.cleanUp();
		} catch (Exception e) {
			System.out.println("Error in destroy "+getClass());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		try(PrintWriter pw=response.getWriter()){
			String email= request.getParameter("email");
			String password= request.getParameter("password");
			
			User u=userdao.signIn(email,password);
			
			if(u != null)
			{
				HttpSession session=request.getSession();
				session.setAttribute("user_info", u);
				session.setAttribute("candidate_dao",candidateDao);
				session.setAttribute("user_dao",userdao);
				
				if(u.getRole().equals("voter"))
				{
					if(u.isStatus())
						
					{
						response.sendRedirect("logout");
					}
					else
					{
						response.sendRedirect("candidatelist");
					}
				}
				else
				{
					response.sendRedirect("admin");
				}
			}
			else 
			{
		      pw.print("<h5>Invalid Login Credentials please try again...<a href='login.html'>Retry</a><h5>");
			}
			
		} catch (Exception e) {
			throw new ServletException("Error in servicing"+ getClass(),e);
		}
	}

}
