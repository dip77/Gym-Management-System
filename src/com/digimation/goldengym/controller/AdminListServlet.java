package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.AdminBean;
import com.digimation.goldengym.dao.AdminDAO;

public class AdminListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AdminBean> listOfAdminBeans=new AdminDAO().getAdminList();
		request.setAttribute("listofadmin", listOfAdminBeans);
		request.getRequestDispatcher("AdminList.jsp").forward(request, response);
	}

}
