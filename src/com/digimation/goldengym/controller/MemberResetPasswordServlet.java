package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.goldengym.bean.MemberBean;
import com.digimation.goldengym.dao.AdminDAO;
import com.digimation.goldengym.dao.MemberDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class MemberResetPasswordServlet extends HttpServlet {
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
			request.getRequestDispatcher("MemberChangePassword.jsp").forward(request, response);
		} else {

			MemberBean memberBean=new MemberBean();
			memberBean.setPassword(newPassword);
			HttpSession session=request.getSession();
			MemberBean memberBean2=(MemberBean)session.getAttribute("memberBean");
			memberBean.setPassword(newPassword);
			memberBean.setMemberId(memberBean2.getMemberId());
			if(new MemberDAO().resetPassword(memberBean))
			{
				session.removeAttribute("memberBean");
				request.setAttribute("msglogin", "succesfully changed! please login again to continue");
				request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("MemberChangePassword.jsp").forward(request, response);
			}
		}

	}

}
