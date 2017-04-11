package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.MemberBean;
import com.digimation.goldengym.dao.MemberDAO;

public class MemberEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");
		MemberBean cityBeanObj =new MemberDAO().getMemberListByPK(Integer.parseInt(id));
		request.setAttribute("memberBean",cityBeanObj);
		request.getRequestDispatcher("MemberEdit.jsp").forward(request, response);
	}

}
