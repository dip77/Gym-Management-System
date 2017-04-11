package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ScheduleBean;
import com.digimation.goldengym.bean.ScheduleTimeBean;
import com.digimation.goldengym.dao.ScheduleTimeDAO;
import com.digimation.goldengym.util.ValidateUtils;
public class ScheduleTimeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		boolean isError=false;
		if(ValidateUtils.isEmpty(startTime))
			isError=true;
		
		if(ValidateUtils.isEmpty(endTime))
			isError=true;
		
		if(isError)
		{
			response.sendRedirect("ScheduleTimeInsert.jsp");
		}
		else
		{
			
		ScheduleTimeBean scheduleTimeBean=new ScheduleTimeBean();
		scheduleTimeBean.setStartTime(startTime);
		scheduleTimeBean.setEndTime(endTime);
			if(new ScheduleTimeDAO().addScheduleTime(scheduleTimeBean))
			{
				request.setAttribute("msginsert", "succesffully added");
				request.getRequestDispatcher("ScheduleTimeListServlet").forward(request, response);
			}
			else
			{
				request.setAttribute("msginsert", "succesffully added");
				request.getRequestDispatcher("ScheduleTimeInsert.jsp").forward(request, response);
			}
	
		}
		
	}

}
