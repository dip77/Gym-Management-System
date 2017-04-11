package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.TrainerBean;
import com.digimation.goldengym.dao.TrainerDAO;

public class TrainerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TrainerBean> listOfTrainerBeans=new TrainerDAO().getTrainerList();
		request.setAttribute("listoftrainer", listOfTrainerBeans);
		request.getRequestDispatcher("TrainerList.jsp").forward(request, response);

	}

}
