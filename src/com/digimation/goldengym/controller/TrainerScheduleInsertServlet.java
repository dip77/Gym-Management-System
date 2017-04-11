package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.TrainerScheduleBean;
import com.digimation.goldengym.dao.TrainerScheduleDAO;

public class TrainerScheduleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean  isError=false;
		String activityId=request.getParameter("activity");
		String scheduleTimeId=request.getParameter("startTime");
		String memebrId=request.getParameter("trainer");

		if(activityId.equals("-1"))
			isError=true;

		if(scheduleTimeId.equals("-1"))
			isError=true;

		if(memebrId.equals("-1"))
			isError=true;

		if(isError)
		{
			request.getRequestDispatcher("TrainerScheduleInsert.jsp").forward(request, response);
		}
		else
		{
			TrainerScheduleBean trainerScheduleBean=new TrainerScheduleBean();
			trainerScheduleBean.setActivityId(Integer.parseInt(activityId));
			trainerScheduleBean.setScheduleTimeId(Integer.parseInt(scheduleTimeId));
			trainerScheduleBean.setTrainerId(Integer.parseInt(memebrId));
			trainerScheduleBean.setScheduleId(new TrainerScheduleDAO().getScheduleID(Integer.parseInt(scheduleTimeId),
					Integer.parseInt(activityId)));
			if(new TrainerScheduleDAO().addTrainerSchedule(trainerScheduleBean))
			{
				request.setAttribute("msginsert","succesfully inserted");
				request.getRequestDispatcher("TrainerScheduleListServlet").forward(request, response);
			}
			else
			{
				request.setAttribute("msginsert"," failed to insert");
				request.getRequestDispatcher("TrainerScheduleInsert.jsp").forward(request, response);
			}
		}
			

	}

}
