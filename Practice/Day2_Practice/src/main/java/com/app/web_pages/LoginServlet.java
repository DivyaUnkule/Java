package com.app.web_pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/login",loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao; 

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		try {
			userDao=new UserDaoImpl();
		} catch (Exception e) {
			
			throw new ServletException("Error in init() - "+getClass(), e);
		}
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userDao.cleanUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in destroy() "+getClass());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter p=response.getWriter()) {
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			User u=userDao.signIn(email,password);
			
			if(u==null)
			{
				p.print("<h5>Invalid login attempt please try again...<a href='login.html'>Retry</a><h5>");
			}
			else {
				Cookie c1 = new Cookie("user_details",u.toString());
				response.addCookie(c1);
				
				if((u.getRole()).equals("voter"))
				{
					if(u.isStatus())
					{
						response.sendRedirect("logout");
						
					}
					else
					{
						response.sendRedirect("candidateList");
					}
				}
				else
				{
					response.sendRedirect("admin");
				}
			}
			
		} catch (Exception e) {
			throw new ServletException("Error in servicing"+ getClass(),e);
		}
		
	}

}
