package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ScheduleBean;
import com.digimation.goldengym.dao.ScheduleDAO;

public class GuestScheduleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<ScheduleBean> listOfScheduleBeans=new ScheduleDAO().getScheduleList();
		request.setAttribute("listofschedule", listOfScheduleBeans);
		request.getRequestDispatcher("GuestScheduleList.jsp").forward(request, response);
	}

}
