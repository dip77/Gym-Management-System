package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.dao.FeedbackDAO;

/**
 * Servlet implementation class FeedbackDeleteServlet
 */
public class FeedbackDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackDeleteServlet() {
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
		int feedback_id=Integer.parseInt(request.getParameter("id").trim());
		if(new FeedbackDAO().removeFeedback(feedback_id))
		{
			request.setAttribute("msgdelete", "successfully Deleted");
			request.getRequestDispatcher("FeedbackListServlet").forward(request, response);
		}
		else {
			request.setAttribute("msgdelete", "Faild to Deleted");
			request.getRequestDispatcher("FeedbackListServlet").forward(request, response);
		}
		
		
	}

}
