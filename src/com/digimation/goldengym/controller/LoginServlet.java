package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.goldengym.bean.AdminBean;
import com.digimation.goldengym.bean.MemberBean;
import com.digimation.goldengym.bean.TrainerBean;
import com.digimation.goldengym.dao.AdminDAO;
import com.digimation.goldengym.dao.MemberDAO;
import com.digimation.goldengym.dao.TrainerDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	HttpSession session=request.getSession();
	AdminBean adminBean=new AdminDAO().isAdmin(email, password);
	TrainerBean trainerBean=new TrainerDAO().isTrainer(email, password);
	MemberBean memberBean=new MemberDAO().isMember(email, password);
	boolean isError=false;
	if(ValidateUtils.isEmpty(email)){
		request.setAttribute("msgemail", "please enter email");
	isError=true;	
	}
	if(ValidateUtils.isEmpty(password)){
		request.setAttribute("msgpassword", "please enter password");
		isError=true;	
	}	
	if (isError) {
		request.getRequestDispatcher("LoginPage.jsp").forward(request, response);	
	}
	else
	{
	if(adminBean!=null)
	{
	session.setAttribute("adminBean",adminBean);
	response.sendRedirect("Admindashboard.jsp");	
	
	}
	else if(memberBean!=null)
	{
	session.setAttribute("memberBean",memberBean);
	response.sendRedirect("MemberProgressDisplayServlet");
	
	}
	else if(trainerBean!=null)
	{
	session.setAttribute("trainerBean",trainerBean);
	response.sendRedirect("TrainerIndexPage.jsp");
	
	}	
	else
	{
		request.setAttribute("msglogin", "<div class='alert alert-danger'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a> invalid username or password </div>  ");
		request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
	}
	}
	
	
		
	}

}
