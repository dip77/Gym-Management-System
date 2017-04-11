package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.dao.AdminDAO;
import com.digimation.goldengym.dao.MemberDAO;
import com.digimation.goldengym.dao.TrainerDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String pwd=request.getParameter("newPassword");
String cpwd=request.getParameter("confirmPassword");
String email=request.getParameter("id");
	boolean isError=false;
	if(ValidateUtils.isEmpty(pwd))
		isError=true;
	
	if(ValidateUtils.isEmpty(cpwd))
		isError=true;
	else if(pwd!=null && !pwd.equals(cpwd))
	{
		isError=true;
		request.setAttribute("cpwd", "confrim password does not match");
		
	}
	if (isError) {
		request.getRequestDispatcher("ResetPassword.jsp").forward(request, response);
	} else {
	email=ValidateUtils.base64decode(email);
	if(new MemberDAO().isMemberEmail(email))
	{
	new MemberDAO().resetPassword(pwd, email);
	
	}
	else 	if(new TrainerDAO().isTrainerEmail(email))
	{
	new TrainerDAO().resetPassword(pwd, email);
	
	}else 	if(new AdminDAO().isAdminEmail(email))
	{
	new AdminDAO().resetPassword(pwd, email);
	
	}


		request.setAttribute("msglogin","<div class='alert alert-info'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a> " +
				"successfully changed! login to continue</div>  ");
		request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
		
	}
	
	}

}
