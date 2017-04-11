package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ScheduleTimeBean;
import com.digimation.goldengym.dao.ScheduleTimeDAO;

public class ScheduleTimeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");
		ScheduleTimeBean activityBeanObj =new ScheduleTimeDAO().getScheduleTimeListByPK(Integer.parseInt(id));
		request.setAttribute("scheduleTimeBean",activityBeanObj);
		request.getRequestDispatcher("ScheduleTimeUpdate.jsp").forward(request, response);
	}

}
