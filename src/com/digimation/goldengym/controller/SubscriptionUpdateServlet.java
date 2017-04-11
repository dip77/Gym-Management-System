package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.SubscriptionBean;
import com.digimation.goldengym.dao.SubscriptionDAO;

public class SubscriptionUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");
		SubscriptionBean activityBeanObj =new SubscriptionDAO().getSubscriptionListByPK(Integer.parseInt(id));
		request.setAttribute("subscriptionBean",activityBeanObj);
		request.getRequestDispatcher("SubscriptionUpdate.jsp").forward(request, response);
	}

}
