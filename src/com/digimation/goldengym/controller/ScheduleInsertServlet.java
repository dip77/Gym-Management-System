package com.digimation.goldengym.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ScheduleBean;
import com.digimation.goldengym.dao.ScheduleDAO;
import com.digimation.goldengym.dao.ScheduleTimeDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class ScheduleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String activityId=request.getParameter("activity");
		String day=request.getParameter("day");
		boolean isError=false;
		if(ValidateUtils.isEmpty(startTime))
			isError=true;
		
		if(ValidateUtils.isEmpty(endTime))
			isError=true;
		
		if(activityId.equals("-1"))
			
			isError=true;
		
		if(isError)
		{
			response.sendRedirect("ScheduleInsert.jsp");
		}
		else
		{
			
		ScheduleBean scheduleTimeBean=new ScheduleBean();
		scheduleTimeBean.setDay(Integer.parseInt(day));
		scheduleTimeBean.setActivityId(Integer.parseInt(activityId));
		scheduleTimeBean.setStartTime(startTime);
		scheduleTimeBean.setEndTime(endTime);
		scheduleTimeBean.setScheduleTimeId(new ScheduleTimeDAO().getScheduleTimeID(startTime, endTime));
			if(new ScheduleDAO().addSchedule(scheduleTimeBean))
			{
				request.setAttribute("msginsert", "succesffully added");
				request.getRequestDispatcher("ScheduleListServlet").forward(request, response);
			}
			else
			{
				request.setAttribute("msginsert", "succesffully added");
				request.getRequestDispatcher("ScheduleInsert.jsp").forward(request, response);
			}
	
		}
		

	}

}
