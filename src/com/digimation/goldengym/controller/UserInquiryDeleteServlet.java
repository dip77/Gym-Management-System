package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.dao.UserInquiryDAO;

/**
 * Servlet implementation class UserInquiryDeleteServlet
 */
public class UserInquiryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInquiryDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id=Integer.parseInt(request.getParameter("id").trim());
	if(new UserInquiryDAO().removeUserInquiry(id))
	{
		request.setAttribute("msgdelete", "record Deleted");
		request.getRequestDispatcher("UserInquiryListServlet").forward(request, response);
	}
	else {

		request.setAttribute("msgdelete", "record can not be Deleted");
		request.getRequestDispatcher("UserInquiryListServlet").forward(request, response);
	}
		// TODO Auto-generated method stub
	}

}
