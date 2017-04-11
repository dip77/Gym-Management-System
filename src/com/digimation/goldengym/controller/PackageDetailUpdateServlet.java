package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.PackageDetailBean;
import com.digimation.goldengym.dao.PackageDetailDAO;

public class PackageDetailUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		PackageDetailBean activityBeanObj =new PackageDetailDAO().getPackageListByPK(Integer.parseInt(id));
		request.setAttribute("packageDetailBean",activityBeanObj);
		request.getRequestDispatcher("PackageDetailUpdate.jsp").forward(request, response);

	
	}

}
