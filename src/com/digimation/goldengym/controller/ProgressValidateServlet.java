package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ProgressBean;
import com.digimation.goldengym.dao.ProgressDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class ProgressValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memberId=request.getParameter("user");
		String startDate=request.getParameter("startDate");
		String id=request.getParameter("id");
		boolean isError=false;
		ProgressBean progressBean=new ProgressBean();
		progressBean.setMemberId(Integer.parseInt(memberId));
		progressBean.setProgressId(Integer.parseInt(id));
		if(ValidateUtils.isEmpty(startDate))
			isError=true;
		else
			progressBean.setStartDate(startDate);
		if (isError) {
			request.setAttribute("progressBean", progressBean);
			request.getRequestDispatcher("ProgressInsert.jsp").forward(request, response);
			
		} else {

			if(new ProgressDAO().updateProgress(progressBean))
			{
				request.setAttribute("msgupdate", "succesfully updated");
				request.getRequestDispatcher("ProgressListServlet").forward(request, response);
			}
			else
			{
				request.setAttribute("progressBean", progressBean);
				request.setAttribute("msgupdate", "failed to  updated");
				request.getRequestDispatcher("ProgressInsert.jsp").forward(request, response);
			}
			
		}
	}

}
