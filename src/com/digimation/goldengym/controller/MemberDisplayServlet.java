package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.MemberScheduleBean;
import com.digimation.goldengym.dao.MemberScheduleDAO;

public class MemberDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");
		ArrayList<MemberScheduleBean> memberScheduleBeans=new MemberScheduleDAO().getMemberList(
				Integer.parseInt(id));
		request.setAttribute("memberScheduleBeans", memberScheduleBeans);
		request.getRequestDispatcher("MemberDisplay.jsp").forward(request, response);
	}

}
