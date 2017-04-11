package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.SubscriptionBean;
import com.digimation.goldengym.dao.SubscriptionDAO;

public class SubscriptionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<SubscriptionBean> listOfSubscriptionBeans=new SubscriptionDAO().getSubscriptionList();
		request.setAttribute("listofsubscription", listOfSubscriptionBeans);
		request.getRequestDispatcher("SubscriptionList.jsp").forward(request, response);

		
	}

}
