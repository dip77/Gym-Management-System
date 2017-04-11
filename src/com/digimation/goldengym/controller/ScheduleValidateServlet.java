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

public class ScheduleValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScheduleBean scheduleBean=new ScheduleBean();
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String activityId=request.getParameter("activity");
		String day=request.getParameter("day");
		String id=request.getParameter("id");
		boolean isError=false;
		scheduleBean.setDay(Integer.parseInt(day));
		if(ValidateUtils.isEmpty(startTime))
			isError=true;
		else
			scheduleBean.setStartTime(startTime);
		if(ValidateUtils.isEmpty(endTime))
			isError=true;
		else
			scheduleBean.setEndTime(endTime);
		if(activityId.equals("-1"))
			isError=true;
		else
			scheduleBean.setActivityId(Integer.parseInt(activityId));
		
		scheduleBean.setDay(Integer.parseInt(day));
		if(isError)
		{
			request.setAttribute("scheduleBean",scheduleBean);
			request.getRequestDispatcher("ScheduleUpdate.jsp").forward(request, response);
		}
		else
		{
		scheduleBean.setScheduleId(Integer.parseInt(id));	
		scheduleBean.setScheduleTimeId(new ScheduleTimeDAO().getScheduleTimeID(startTime, endTime));
			if(new ScheduleDAO().updateSchedule(scheduleBean))
			{
				request.setAttribute("msgupdate", "succesffully updated");
				request.getRequestDispatcher("ScheduleListServlet").forward(request, response);
			}
			else
			{
				request.setAttribute("msgupdate", "failed to update");
				request.getRequestDispatcher("ScheduleUpdate.jsp").forward(request, response);
			}
	
		}

	}

}
