package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ActivityBean;
import com.digimation.goldengym.bean.AdminBean;
import com.digimation.goldengym.dao.ActivityDAO;
import com.digimation.goldengym.dao.AdminDAO;

public class AdminEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adminId=request.getParameter("id");
		AdminBean adminBeanObj =new AdminDAO().getAdminListByPK(Integer.parseInt(adminId));
		request.setAttribute("adminBean",adminBeanObj);
		request.getRequestDispatcher("AdminEdit.jsp").forward(request, response);

	}

}
