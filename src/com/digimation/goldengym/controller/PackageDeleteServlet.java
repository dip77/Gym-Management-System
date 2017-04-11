package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.dao.PackageDAO;

public class PackageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");	
		if(new PackageDAO().removePackage(Integer.parseInt(id)))
					request.setAttribute("msgdelete", " successfully delete");
				else
					request.setAttribute("msgdelete", " failed to delete");
				request.getRequestDispatcher("PackageListServlet").forward(request, response);
		
	}

}
