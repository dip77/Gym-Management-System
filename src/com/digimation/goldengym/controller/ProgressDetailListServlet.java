package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ProgressDetailBean;
import com.digimation.goldengym.dao.ProgressDetailDAO;

public class ProgressDetailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id"));
		ArrayList<ProgressDetailBean> ProgressDetailBean=new ProgressDetailDAO().
				getProgressDetailList(id);
		request.setAttribute("listofprogressDetailBean", ProgressDetailBean);
		request.getRequestDispatcher("ProgressDetailList.jsp").forward(request, response);
		

	
	}

}
