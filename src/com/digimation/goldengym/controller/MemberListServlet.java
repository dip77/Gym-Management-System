package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.MemberBean;
import com.digimation.goldengym.dao.MemberDAO;

public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemberBean> listOfMemberBeans=new MemberDAO().getMemberList();
		request.setAttribute("listofmember", listOfMemberBeans);
		request.getRequestDispatcher("MemberList.jsp").forward(request, response);

	}

}
