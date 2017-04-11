package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.dao.ProgressDAO;

public class ProgressDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String id=request.getParameter("id");	
	if(new ProgressDAO().removeProgress(Integer.parseInt(id)))
				request.setAttribute("msgdelete", " successfully delete");
			else
				request.setAttribute("msgdelete", " failed to delete");
			request.getRequestDispatcher("ProgressListServlet").forward(request, response);
		

		
	}

}
