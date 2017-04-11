package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.TrainerBean;
import com.digimation.goldengym.dao.TrainerDAO;
public class TrainerEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String trainerId=request.getParameter("id");
		TrainerBean trainerBeanObj =new TrainerDAO().getTrainerListByPK(Integer.parseInt(trainerId));
		request.setAttribute("trainerBean",trainerBeanObj);
		request.getRequestDispatcher("TrainerEdit.jsp").forward(request, response);
	}

}
