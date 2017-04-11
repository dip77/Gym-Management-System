package com.digimation.goldengym.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.MemberTypeBean;
import com.digimation.goldengym.dao.MemberTypeDAO;

public class MemberTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberTypeId = Integer.parseInt(request.getParameter("id"));
		MemberTypeBean memberTypeBean = new MemberTypeDAO()
				.getByPK(memberTypeId);
		request.setAttribute("memberTypeBean", memberTypeBean);
		request.getRequestDispatcher("MemberTypeUpdate.jsp").forward(
				request, response);
	
}

}
