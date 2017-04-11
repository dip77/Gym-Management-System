package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.goldengym.bean.MemberBean;
import com.digimation.goldengym.bean.ProgressDetailBean;
import com.digimation.goldengym.dao.ProgressDetailDAO;

public class MemberProgressDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int id;
		HttpSession session=request.getSession();
				MemberBean memberBean=(MemberBean)session.getAttribute("memberBean");
				id=memberBean.getMemberId();
		ArrayList<ProgressDetailBean> progressDetailBeans = new ProgressDetailDAO()
				.getProgressDetailList(id);
		request.setAttribute("memberProgressDetailBeans", progressDetailBeans);
		request.getRequestDispatcher("ProgressDetailDisplay.jsp").forward(
				request, response);

	}

}
