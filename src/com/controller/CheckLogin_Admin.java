package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.AdminDAO;
import com.model.AdminDTO;

import com.model.StatusConstants;


public class CheckLogin_Admin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String status = null;
	
		
		String emailAdmin=request.getParameter("email_admin");
		String passwordAdmin=request.getParameter("password_admin");
		
		AdminDAO aDAO=new AdminDAO();
		AdminDTO aDTO=new AdminDTO();
		aDTO.setEmail(emailAdmin);
		aDTO.setPassword(passwordAdmin);
		
			try {
				status=aDAO.login(aDTO);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(status.equals(StatusConstants.SUCCESS))
		{
			HttpSession sess=request.getSession(true);
			sess.setAttribute("emailAdmin", emailAdmin);
			RequestDispatcher rd=request.getRequestDispatcher("JSP/adminDashboard.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Admin_Login_Fail.jsp");
			rd.forward(request, response);	
		}
		
	}

}
