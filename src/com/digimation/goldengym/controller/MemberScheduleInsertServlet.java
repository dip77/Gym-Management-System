package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.MemberScheduleBean;
import com.digimation.goldengym.dao.MemberScheduleDAO;

public class MemberScheduleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
boolean  isError=false;
String activityId=request.getParameter("activity");
String scheduleTimeId=request.getParameter("startTime");
String memebrId=request.getParameter("user");
String trainerId=request.getParameter("trainer");

if(activityId.equals("-1"))
	isError=true;

if(scheduleTimeId.equals("-1"))
	isError=true;

if(memebrId.equals("-1"))
	isError=true;

if(trainerId.equals("-1"))
	isError=true;

if(isError)
{
	request.getRequestDispatcher("MemberScheduleInsert.jsp").forward(request, response);
}
else
{
	MemberScheduleBean memberScheduleBean=new MemberScheduleBean();
	memberScheduleBean.setActivityId(Integer.parseInt(activityId));
	memberScheduleBean.setScheduleTimeId(Integer.parseInt(scheduleTimeId));
	memberScheduleBean.setMemberId(Integer.parseInt(memebrId));
	memberScheduleBean.setTrainerId(Integer.parseInt(trainerId));
	memberScheduleBean.setScheduleId(new MemberScheduleDAO().getScheduleID(Integer.parseInt(scheduleTimeId),
			Integer.parseInt(activityId)));
	if(new MemberScheduleDAO().addMemberSchedule(memberScheduleBean))
	{
		request.setAttribute("msginsert","succesfully inserted");
		request.getRequestDispatcher("MemberScheduleListServlet").forward(request, response);
	}
	else
	{
		request.setAttribute("msginsert"," failed to insert");
		request.getRequestDispatcher("MemberScheduleInsert.jsp").forward(request, response);
	}
}
	
	
	}

	
}
