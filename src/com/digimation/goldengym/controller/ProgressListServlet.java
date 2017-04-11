package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ProgressBean;
import com.digimation.goldengym.dao.ProgressDAO;

public class ProgressListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<ProgressBean> listOfProgressBeans=new ProgressDAO().getProgressList();
		request.setAttribute("listofprogress", listOfProgressBeans);
		request.getRequestDispatcher("ProgressList.jsp").forward(request, response);
	}

}
