package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.goldengym.bean.MemberBean;
import com.digimation.goldengym.bean.ProgressBean;
import com.digimation.goldengym.bean.ProgressDetailBean;
import com.digimation.goldengym.dao.ProgressDAO;
import com.digimation.goldengym.dao.ProgressDetailDAO;

public class MemberAllProgressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	HttpSession session=request.getSession();
	MemberBean memberBean=(MemberBean)session.getAttribute("memberBean");
	
		ArrayList<ProgressBean> listOfProgressBeans=new ProgressDAO().
				getProgressList(memberBean.getMemberId());
		request.setAttribute("listofprogress", listOfProgressBeans);
		request.getRequestDispatcher("MemberProgressList.jsp").forward(request, response);
		
	}

}
