package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.UserInquiryBean;
import com.digimation.goldengym.dao.UserInquiryDAO;
import com.digimation.goldengym.util.ValidateUtils;

/**
 * Servlet implementation class GuestUserInquiryServlet
 */
public class GuestUserInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuestUserInquiryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		String mobile = request.getParameter("mobile");
		boolean error = false;
		if (new ValidateUtils().isEmpty(firstName)) {
			error = true;
			request.setAttribute("msgfirstName", "enter First Name");

		}
		if (new ValidateUtils().isEmpty(lastName)) {
			error = true;
			request.setAttribute("msglastName", "enter last Name");

		}
		if (new ValidateUtils().isEmpty(mobile)) {
			error = true;
			request.setAttribute("msgmobile", "enter mobile number");

		}
		if (new ValidateUtils().isEmpty(email)) {
			error = true;
			request.setAttribute("msgemail", "enter email");

		}
		if (new ValidateUtils().isEmpty(message)) {
			error = true;
			request.setAttribute("msgmassage", "enter inquiry info");

		}
		if (error) {
			request.getRequestDispatcher("Contact-us.jsp").forward(request,
					response);
		} else {
			UserInquiryBean bean = new UserInquiryBean();
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setMessage(message);
			bean.setMobile(mobile);
			bean.setEmail(email);
			if (new UserInquiryDAO().addUsertInquiry(bean)) {
				request.setAttribute("msginsert", "<div class='alert alert-success'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a> Thanks For Inquiry Plz give us official 2 day's for replay</div> ");
				request.getRequestDispatcher("Contact-us.jsp").forward(
						request, response);
			} else {
				request.setAttribute("msginsert", "fail to insert");
				request.getRequestDispatcher("Contact-us.jsp").forward(
						request, response);
			}

		}
	}

}
