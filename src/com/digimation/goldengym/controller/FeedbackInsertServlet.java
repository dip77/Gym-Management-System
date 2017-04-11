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
 * Servlet implementation class FeedbackInsertServlet
 */
public class FeedbackInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String feedback = request.getParameter("feedback");
		boolean isError = false;
		if (new ValidateUtils().isEmpty(feedback)) {
			request.setAttribute("mscFeedback", "please enter some Feedback");
			isError = true;
		}
		if (isError) {
			request.getRequestDispatcher("Feedback.jsp").forward(request,
					response);
		} else {
			MemberBean f = (MemberBean) session.getAttribute("memberBean");
			FeedbackBean feedbackBean = new FeedbackBean();
			feedbackBean.setFeedback(feedback);

			feedbackBean.setMember_id(f.getMemberId());
			if (new FeedbackDAO().addFeedback(feedbackBean)) {
				request.setAttribute("msginsert", "Feedback Inserted");

				request.getRequestDispatcher("FeedbackListServlet").forward(
						request, response);
			} else {

				request.setAttribute("msginsert", "Feedback failed to Inserted");

				request.getRequestDispatcher("FeedbackListServlet").forward(
						request, response);
			}

		}

	}

}
