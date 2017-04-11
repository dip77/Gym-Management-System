package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.goldengym.bean.FeedbackBean;
import com.digimation.goldengym.bean.MemberBean;
import com.digimation.goldengym.dao.FeedbackDAO;
import com.digimation.goldengym.util.ValidateUtils;

/**
 * Servlet implementation class FeedbackValidateServlet
 */
public class FeedbackValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FeedbackValidateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id").trim());
		String feedback = request.getParameter("feedback");
		boolean isError = false;
		if (new ValidateUtils().isEmpty(feedback)) {
			isError = true;
			request.setAttribute("feedback", "enter some Feedback");

		}
		if (isError) {
			request.setAttribute("msgFeedback", "Enter some Feedback");
			request.getRequestDispatcher("FeedbackUpdate.jsp").forward(request,
					response);
		} else {
			FeedbackBean feedbackBean=new FeedbackBean();
			feedbackBean.setFeedback(feedback);
			feedbackBean.setFeedback_id(id);
HttpSession session =request.getSession();
			MemberBean f = (MemberBean) session.getAttribute("memberBean");

			feedbackBean.setMember_id(f.getMemberId());

			if(new FeedbackDAO().updateFeedback(feedbackBean)){
				request.getRequestDispatcher("FeedbackListServlet").forward(request, response);
			}
			
		}

	}

}
