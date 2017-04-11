package com.digimation.goldengym.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.AdminBean;
import com.digimation.goldengym.dao.AdminDAO;
import com.digimation.goldengym.dao.CityDAO;
import com.digimation.goldengym.util.ValidateUtils;
public class AdminInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirmPassword");
		String city=request.getParameter("city");
		
		boolean isError=false;
		if(ValidateUtils.isEmpty(firstName))
		{
			isError=true;
		}
	
		if(ValidateUtils.isEmpty(lastName))
		{
			isError=true;
		}
		if(ValidateUtils.isEmpty(email))
		{
			isError=true;
		}
		else if(!ValidateUtils.EmailFormatValidator(email))
		{
			isError=true;
			request.setAttribute("msgemail", "please enter correct email");
		}
		
		if(ValidateUtils.isEmpty(password))
		{
			isError=true;
		}
		else if(password!=null && password.length()<6)
		{
			isError=true;
			request.setAttribute("msgpwd", "password must contain min. 6 character");
		}
	
			if(ValidateUtils.isEmpty(confirmPassword))
		{
			isError=true;
		}
		else if(password!=null && !password.equals(confirmPassword))
		{
			isError=true;
			request.setAttribute("msgcpwd", "confirm password does not match");
		}
			if(ValidateUtils.isEmpty(city))
			{
				isError=true;
			}
		
		if(isError)
		{
			request.getRequestDispatcher("AdminInsert.jsp").forward(request, response);
		}
		else
		{
			AdminBean adminBean=new AdminBean();
			adminBean.setCityId(new CityDAO().getCityID(city));
			adminBean.setEmail(email);
			adminBean.setFirstName(firstName);
			adminBean.setLastName(lastName);
			adminBean.setGender(gender);
			adminBean.setPassword(ValidateUtils.base64encode(password));
			if(new AdminDAO().addAdmin(adminBean))
			{
				request.setAttribute("msginsert", firstName+" successfully added");
				request.getRequestDispatcher("AdminListServlet").forward(request, response);
			
			}
			else
			{
				request.setAttribute("msginsert", " failed to add "+firstName);
				request.getRequestDispatcher("AdminInsert.jsp").forward(request, response);
			
			}
		}
		

	}

}
