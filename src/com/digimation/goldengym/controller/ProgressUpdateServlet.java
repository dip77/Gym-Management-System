package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ProgressBean;
import com.digimation.goldengym.dao.ProgressDAO;

public class ProgressUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");
		ProgressBean activityBeanObj =new ProgressDAO().getProgressListByPK(Integer.parseInt(id));
		request.setAttribute("progressBean",activityBeanObj);
		request.getRequestDispatcher("ProgressUpdate.jsp").forward(request, response);

	}

}
