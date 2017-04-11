package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ActivityBean;
import com.digimation.goldengym.dao.ActivityDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class ActivityValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String activity=request.getParameter("activity");
		String id=request.getParameter("id");
		ActivityBean activityBean=new ActivityBean();
		boolean isError=false;
	if(ValidateUtils.isEmpty(activity))
	{
		isError=true;
	}
	
	else
		activityBean.setActivity(activity);
		
	if(isError)
	{
	request.setAttribute("activityBean", activityBean);
		request.getRequestDispatcher("ActivityUpdate.jsp").forward(request, response);
	}
		else
	{
		
		activityBean.setActivityId(Integer.parseInt(id));
		if(new ActivityDAO().updateActivity(activityBean)){
			request.setAttribute("msgupdate", " successfully updated");
			request.getRequestDispatcher("ActivityListServlet").forward(request, response);
		}
			//in else duplicatation error may come
		else{
			request.setAttribute("msgupdate", "failed to update "+activity);//use less
	    	request.getRequestDispatcher("ActivityUpdate.jsp").forward(request, response);
		}
	
	}

	}

}
