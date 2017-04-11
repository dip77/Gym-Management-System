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
 * Servlet implementation class MemberFeedbackInsertServlet
 */
public class MemberFeedbackInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFeedbackInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String feedback = request.getParameter("feedback");
		boolean isError = false;
		if (new ValidateUtils().isEmpty(feedback)) {
			request.setAttribute("mscFeedback", "please enter some Feedback");
			isError = true;
		}
		if (isError) {
 			request.getRequestDispatcher("UserAboutUs.jsp").forward(request,
					response);
		} else {
			MemberBean f = (MemberBean) session.getAttribute("memberBean");
			FeedbackBean feedbackBean = new FeedbackBean();
			feedbackBean.setFeedback(feedback);

			feedbackBean.setMember_id(f.getMemberId());
			if (new FeedbackDAO().addFeedback(feedbackBean)) {
				request.setAttribute("msginsert", "Feedback Inserted");

				request.getRequestDispatcher("FeedbackMsg.jsp").forward(
						request, response);
			} else {

				request.setAttribute("msginsert", "Feedback failed to Inserted");

				request.getRequestDispatcher("FeedbackMsg.jsp").forward(
						request, response);
			}

		}

	
	}

}
