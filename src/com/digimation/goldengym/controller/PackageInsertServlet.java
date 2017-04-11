package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.PackageBean;
import com.digimation.goldengym.dao.PackageDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class PackageInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String packageName=request.getParameter("packageName");
	String duration=request.getParameter("duration");
	boolean isError=false;
	if(ValidateUtils.isEmpty(packageName))
		isError=true;
	else if(new PackageDAO().isPackageExists(packageName))
	{
		isError=true;
		request.setAttribute("msgpkg", "Package name already xxists");
	}
	if(ValidateUtils.isEmpty(duration))
		isError=true;
	
	if(isError)
	{
		request.getRequestDispatcher("PackageInsert.jsp").forward(request, response);
	}
	else
	{
		PackageBean packageBean=new PackageBean();
		packageBean.setPackageName(packageName);
		packageBean.setDuration(Integer.parseInt(duration));
		if(new PackageDAO().addPackage(packageBean))
		{
			request.setAttribute("insert","succesffuly inserted");
			request.getRequestDispatcher("PackageListServlet").forward(request, response);
		}
		else
		{
			request.setAttribute("insert","failed to insert");
			request.getRequestDispatcher("PackageInsert.jsp").forward(request, response);
		}
	}
	}

}
