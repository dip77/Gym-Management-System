package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.goldengym.bean.TrainerBean;
import com.digimation.goldengym.dao.TrainerDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class TrainerResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String oldPassword=request.getParameter("oldPassword");
		String newPassword=request.getParameter("newPassword");
		String confirmPassword=request.getParameter("confirmPassword");
		boolean isError=false;
		if(ValidateUtils.isEmpty(oldPassword))
			isError=true;
		
		if(ValidateUtils.isEmpty(newPassword))
			isError=true;
		if(ValidateUtils.isEmpty(confirmPassword))
			isError=true;
		else if(newPassword!=null && !newPassword.equals(confirmPassword)){
			isError=true;
			request.setAttribute("msgcpwd", "confirm password does not match");
		}
		
		if (isError) {
			request.getRequestDispatcher("TrainerChangePassword.jsp").forward(request, response);
		} else {

			TrainerBean trainerBean=new TrainerBean();
			trainerBean.setPassword(newPassword);
			HttpSession session=request.getSession();
			TrainerBean trainerBean2=(TrainerBean)session.getAttribute("trainerBean");
			trainerBean.setPassword(newPassword);
			trainerBean.setTrainerId(trainerBean2.getTrainerId());
			if(new TrainerDAO().resetPassword(trainerBean))
			{
				session.removeAttribute("trainerBean");
				request.setAttribute("msglogin", "succesfully changed! please login again to continue");
				request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("TrainerChangePassword.jsp").forward(request, response);
			}
		}
		
			

	}

}
