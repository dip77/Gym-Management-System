package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ProgressDetailBean;
import com.digimation.goldengym.dao.ProgressDetailDAO;

public class TrainerProgressDetailUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");
		ProgressDetailBean activityBeanObj =new ProgressDetailDAO().getProgressDetailListByPK(Integer.parseInt(id));
		request.setAttribute("progressBean",activityBeanObj);
		request.getRequestDispatcher("TrainerProgressDetailUpdate.jsp").forward(request, response);

	}

}
