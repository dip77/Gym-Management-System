package com.digimation.goldengym.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.dao.AdminDAO;
import com.digimation.goldengym.dao.MemberDAO;
import com.digimation.goldengym.dao.TrainerDAO;
import com.digimation.goldengym.util.Email;
import com.digimation.goldengym.util.ValidateUtils;

public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName=request.getParameter("email");
		
		boolean isError=false;
		if(ValidateUtils.isEmpty(userName))
		{
			isError=true;
			request.setAttribute("username", "please enter username");
		}
		else if(!ValidateUtils.EmailFormatValidator(userName))
		{
			isError=true;
			request.setAttribute("username", "<div class='alert alert-danger'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a> please enter valid email id </div>  ");
		}
		else if(!new MemberDAO().isMemberEmail(userName) && !new TrainerDAO().isTrainerEmail(userName) 
				&& !new AdminDAO().isAdminEmail(userName))
		{
			isError=true;
			request.setAttribute("username", " <div class='alert alert-danger'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a> please enter valid email id </div>   ");
		}
		if(isError)
		{
			request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
		}
		else
		{
				
				String tmp="http://localhost:6018/GoldenGym/ResetPassword.jsp?id="+
				ValidateUtils.base64encode(userName);
				String from="goldengym2016@gmail.com";
				String password="SaurabhDip";
				String subject="forgot password";
				String message="please click below link to change your password "+tmp;
				String []to=new String[1];
						to[0]=userName;
						if(new Email().sendMail(from, password, subject, message, to))
						{
							request.setAttribute("msglogin","<div class='alert alert-success'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a> succesfully send to  Your Email</div>  ");
							request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
						}
						else
						{
							request.setAttribute("msglogin","<div class='alert alert-danger'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>  failed!please try again!</div>  ");
							request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
						
						}
			}
	}

}
