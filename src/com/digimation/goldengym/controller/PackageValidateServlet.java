package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.PackageBean;
import com.digimation.goldengym.dao.PackageDAO;
import com.digimation.goldengym.util.ValidateUtils;
public class PackageValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PackageBean packageBean=new PackageBean();
		String packageName=request.getParameter("packageName");
		String duration=request.getParameter("duration");
		String id=request.getParameter("id");
		boolean isError=false;
		if(ValidateUtils.isEmpty(packageName))
			isError=true;
		else if(new PackageDAO().isPackageExists(packageName))
		{
			isError=true;
			packageBean.setPackageName(packageName);
			request.setAttribute("msgpkg", "Package name already xxists");
		}
		else
		packageBean.setPackageName(packageName);
		
		if(ValidateUtils.isEmpty(duration))
			isError=true;
		else
			packageBean.setDuration(Integer.parseInt(duration));
		if(isError)
		{
		request.setAttribute("packageBean", packageBean);
			request.getRequestDispatcher("PackageUpdate.jsp").forward(request, response);
		}
		else
		{
			packageBean.setPackageId(Integer.parseInt(id));
			if(new PackageDAO().updatePackage(packageBean))
			{
				request.setAttribute("insert","succesffuly inserted");
				request.getRequestDispatcher("PackageListServlet").forward(request, response);
			}
			else
			{
				request.setAttribute("packageBean", packageBean);
				request.setAttribute("insert","failed to insert");
				request.getRequestDispatcher("PackageUpdate.jsp").forward(request, response);
			}
		}

	}

}
