package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ScheduleTimeBean;
import com.digimation.goldengym.dao.ScheduleTimeDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class ScheduleTimeValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String id=request.getParameter("id");
		ScheduleTimeBean activityBean=new ScheduleTimeBean();
		boolean isError=false;
	if(ValidateUtils.isEmpty(startTime))
	{
		isError=true;
	}
	
	else
		activityBean.setStartTime(startTime);
	if(ValidateUtils.isEmpty(endTime))
	{
		isError=true;
	}
	
	else
		activityBean.setEndTime(endTime);
	
	if(isError)
	{
		request.setAttribute("scheduleTimeBean", activityBean);
		request.getRequestDispatcher("ScheduleTimeUpdate.jsp").forward(request, response);
	}
		else
	{
		activityBean.setScheduleTimeId(Integer.parseInt(id));
		if(new ScheduleTimeDAO().updateScheduleTime(activityBean)){
			request.setAttribute("msgupdate", " successfully updated");
			request.getRequestDispatcher("ScheduleTimeListServlet").forward(request, response);
		}
			//in else duplicatation error may come
		else{
			request.setAttribute("msgupdate", "failed to update ");//use less
	    	request.getRequestDispatcher("ScheduleTimeUpdate.jsp").forward(request, response);
		}
	
	}

	}

}
