package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ActivityBean;
import com.digimation.goldengym.bean.MemberScheduleBean;
import com.digimation.goldengym.dao.ActivityDAO;
import com.digimation.goldengym.dao.MemberScheduleDAO;

public class MemberScheduleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemberScheduleBean> listOfMemberScheduleBeans=new MemberScheduleDAO().getMemberScheduleList();
		request.setAttribute("listofmemberschedule", listOfMemberScheduleBeans);
		request.getRequestDispatcher("MemberScheduleList.jsp").forward(request, response);
	
	}

}
