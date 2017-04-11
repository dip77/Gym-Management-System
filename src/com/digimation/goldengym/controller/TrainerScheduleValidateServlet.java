package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.TrainerScheduleBean;
import com.digimation.goldengym.dao.TrainerScheduleDAO;

public class TrainerScheduleValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String activityId=request.getParameter("activity");
		String scheduleTimeId=request.getParameter("startTime");
		String memebrId=request.getParameter("user");
		String id=request.getParameter("id");
			TrainerScheduleBean trainerScheduleBean=new TrainerScheduleBean();
			trainerScheduleBean.setActivityId(Integer.parseInt(activityId));
			trainerScheduleBean.setScheduleTimeId(Integer.parseInt(scheduleTimeId));
			trainerScheduleBean.setTrainerId(Integer.parseInt(memebrId));
			trainerScheduleBean.setTrainerScheduleId(Integer.parseInt(id));
			trainerScheduleBean.setScheduleId(new TrainerScheduleDAO().getScheduleID(Integer.parseInt(scheduleTimeId),
					Integer.parseInt(activityId)));	
			
			if(new TrainerScheduleDAO().updateTrainerSchedule(trainerScheduleBean))
			{
				request.setAttribute("msgupdate","succesfully updated");
				request.getRequestDispatcher("TrainerScheduleListServlet").forward(request, response);
			}
			else
			{
				request.setAttribute("trainerscheduleBean",trainerScheduleBean);
				request.setAttribute("msgupdate"," failed to updated");
				request.getRequestDispatcher("TrainerScheduleUpdate.jsp").forward(request, response);
			}
		


	}

}
