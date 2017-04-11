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
public class AdminEditValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adminId=request.getParameter("id");
		String firstName=request.getParameter("firstName");
		String password=request.getParameter("password");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String city=request.getParameter("city");
		boolean isError=false;
		AdminBean adminBean=new AdminBean();
		if(ValidateUtils.isEmpty(firstName))
		{
			isError=true;
		}
		
		else
			adminBean.setFirstName(firstName);
		if(ValidateUtils.isEmpty(lastName))
		{
			isError=true;
		}
		else
			adminBean.setLastName(lastName);
		if(ValidateUtils.isEmpty(email))
		{
			isError=true;
			request.setAttribute("msgemail", "please enter email");
		}
		else if(!ValidateUtils.EmailFormatValidator(email))
		{
			adminBean.setEmail(email);
			isError=true;
			request.setAttribute("msgemail", "please enter valid email");
		}
		else
			adminBean.setEmail(email);
		adminBean.setCityId(new CityDAO().getCityID(city));
		adminBean.setGender(gender);
		adminBean.setPassword(password);
		if(isError)
		{
		request.setAttribute("adminBean", adminBean);
			request.getRequestDispatcher("AdminEdit.jsp").forward(request, response);
		
		}
		else
		{
			
			adminBean.setAdminId(Integer.parseInt(adminId));
			if(new AdminDAO().updateAdmin(adminBean))
			{
				request.setAttribute("msgupdate", " successfully updated");
				request.getRequestDispatcher("Admindashboard.jsp").forward(request, response);
			
			}
			else
			{
				request.setAttribute("adminBean", adminBean);
				request.setAttribute("msgupdate", " failed to update ");
				request.getRequestDispatcher("AdminEdit.jsp").forward(request, response);
				
			}
		}

	}

}
