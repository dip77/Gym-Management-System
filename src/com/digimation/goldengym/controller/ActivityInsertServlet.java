package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ActivityBean;
import com.digimation.goldengym.dao.ActivityDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class ActivityInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String activity=request.getParameter("activity");
		boolean isError=false;
		if(ValidateUtils.isEmpty(activity))
		{
			isError=true;
		}
		
		
		if(isError)
			request.getRequestDispatcher("ActivityInsert.jsp").forward(request, response);
		else
		{
			ActivityBean activityBeanObj=new ActivityBean();
			activityBeanObj.setActivity(activity);
			if(new ActivityDAO().addActivity(activityBeanObj)){
				request.setAttribute("msginsert", activity+" successfully added");
				request.getRequestDispatcher("ActivityListServlet").forward(request, response);
			}
			else{
				request.setAttribute("msginsert", "failed to add "+activity);
		    	request.getRequestDispatcher("ActivityInsert.jsp").forward(request, response);
			}
			}
		

	}

}
