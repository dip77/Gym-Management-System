package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean. MemberScheduleBean;
import com.digimation.goldengym.dao. MemberScheduleDAO;

public class MemberScheduleDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");
		ArrayList<MemberScheduleBean> subscriptionBeans=new  MemberScheduleDAO().getMemberSchedule
		(Integer.parseInt(id));
		request.setAttribute("memberScheduleBeans", subscriptionBeans);
		request.getRequestDispatcher("MemberScheduleDisplay.jsp").forward(request, response);

	}

}
