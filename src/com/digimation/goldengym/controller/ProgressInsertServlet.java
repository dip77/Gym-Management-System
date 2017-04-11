package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ProgressBean;
import com.digimation.goldengym.dao.ProgressDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class ProgressInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String memberId=request.getParameter("user");
	String startDate=request.getParameter("startDate");
	boolean isError=false;
	if(memberId.equals("-1"))
		isError=true;
	if(ValidateUtils.isEmpty(startDate))
		isError=true;
	if (isError) {
		
		request.getRequestDispatcher("ProgressInsert.jsp").forward(request, response);
		
	} else {

		ProgressBean progressBean=new ProgressBean();
		progressBean.setMemberId(Integer.parseInt(memberId));
		progressBean.setStartDate(startDate);
		
		if(new ProgressDAO().addProgress(progressBean))
		{
			request.setAttribute("msginsert", "succesfully inserted");
			request.getRequestDispatcher("ProgressListServlet").forward(request, response);
		}
		else
		{
			request.setAttribute("msginsert", "failed to  insert");
			request.getRequestDispatcher("ProgressInsert.jsp").forward(request, response);
		}
		
	}
	
	}

}
