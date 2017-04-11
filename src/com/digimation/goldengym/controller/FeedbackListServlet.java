package com.digimation.goldengym.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.FeedbackBean;
import com.digimation.goldengym.dao.FeedbackDAO;

/**
 * Servlet implementation class FeedbackListServlet
 */
public class FeedbackListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackListServlet() {
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
		ArrayList<FeedbackBean> listofFeedback=new FeedbackDAO().getFeedbackList();
		
		request.setAttribute("listofFeedback", listofFeedback);
		request.setAttribute("msginsert", "Record Found  "+listofFeedback.size());
		request.getRequestDispatcher("FeedbackList.jsp").forward(request, response);

	}

}
