package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.UserInquiryBean;
import com.digimation.goldengym.dao.UserInquiryDAO;

public class UserInquiryEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); // TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserInquiryBean arrayList = new UserInquiryDAO()
				.getUserInquiryByPK(Integer.parseInt(request.getParameter("id")
						.trim()));
		request.setAttribute("listofInquiry", arrayList);
		request.getRequestDispatcher("Contact-usUpdate.jsp").forward(request,
				response);

	}
}
