package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.MemberTypeBean;
import com.digimation.goldengym.dao.MemberTypeDAO;

public class MemberTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
List<MemberTypeBean> listOfMemberType = new MemberTypeDAO().list();
		
		if(listOfMemberType!=null)
		{
			request.setAttribute("listOfMemberType",listOfMemberType);
			request.getRequestDispatcher("MemberTypeList.jsp").forward(request, response);
		}

	}

}
