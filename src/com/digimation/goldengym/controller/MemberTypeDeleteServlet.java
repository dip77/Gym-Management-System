package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.dao.MemberTypeDAO;
public class MemberTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberTypeId = request.getParameter("id");

		if (new MemberTypeDAO().delete(Integer.parseInt(memberTypeId))) {
			request.setAttribute("msgdelete", "successfully deleted!");
			request.getRequestDispatcher("MemberTypeListServlet").forward(request, response);

		} else {
			request.setAttribute("msgdelete", "unable to delete!");
			request.getRequestDispatcher("MemberTypeList.jsp").forward(request, response);
			
		}

	}

}
