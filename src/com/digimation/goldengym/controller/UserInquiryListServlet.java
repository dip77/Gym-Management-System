package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.UserInquiryBean;
import com.digimation.goldengym.dao.UserInquiryDAO;

 public class UserInquiryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 public UserInquiryListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	 protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); // TODO Auto-generated method stub
	}

	 protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<UserInquiryBean> arrayList=new UserInquiryDAO().getUserInquiryList();
		 request.setAttribute("listofInquiry", arrayList);
		 request.getRequestDispatcher("UserInquiryList.jsp").forward(request, response);

	}

}
