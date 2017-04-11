package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.MemberScheduleBean;
import com.digimation.goldengym.dao.MemberScheduleDAO;

public class MemberScheduleValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String activityId=request.getParameter("activity");
		String scheduleTimeId=request.getParameter("startTime");
		String memebrId=request.getParameter("user");
		String trainerId=request.getParameter("trainer");
		String id=request.getParameter("id");
			MemberScheduleBean memberScheduleBean=new MemberScheduleBean();
			memberScheduleBean.setActivityId(Integer.parseInt(activityId));
			memberScheduleBean.setScheduleTimeId(Integer.parseInt(scheduleTimeId));
			memberScheduleBean.setTrainerId(Integer.parseInt(trainerId));
			memberScheduleBean.setMemberId(Integer.parseInt(memebrId));
			memberScheduleBean.setMemberScheduleId(Integer.parseInt(id));
			memberScheduleBean.setScheduleId(new MemberScheduleDAO().getScheduleID(Integer.parseInt(scheduleTimeId),
					Integer.parseInt(activityId)));
			
			if(new MemberScheduleDAO().updateMemberSchedule(memberScheduleBean))
			{
				request.setAttribute("msgupdate","succesfully updated");
				request.getRequestDispatcher("MemberScheduleListServlet").forward(request, response);
			}
			else
			{
				request.setAttribute("memberscheduleBean",memberScheduleBean);
				request.setAttribute("msgupdate"," failed to updated");
				request.getRequestDispatcher("MemberScheduleUpdate.jsp").forward(request, response);
			}
		

	}

}
