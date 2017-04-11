package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ActivityBean;
import com.digimation.goldengym.dao.ActivityDAO;

public class ActivityUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");
		ActivityBean activityBeanObj =new ActivityDAO().getActivityListByPK(Integer.parseInt(id));
		request.setAttribute("activityBean",activityBeanObj);
		request.getRequestDispatcher("ActivityUpdate.jsp").forward(request, response);

	}

}
