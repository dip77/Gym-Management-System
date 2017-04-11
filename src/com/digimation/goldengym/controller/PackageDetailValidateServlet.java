package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.PackageDetailBean;
import com.digimation.goldengym.dao.PackageDetailDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class PackageDetailValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String amount=request.getParameter("amount");
		String memberTypeId=request.getParameter("memberType");
		String activityId=request.getParameter("activity");
		String packageId=request.getParameter("package");
		String id=request.getParameter("id");
	PackageDetailBean packageDetailBean=new PackageDetailBean();
	packageDetailBean.setActivityId(Integer.parseInt(activityId));
	packageDetailBean.setMemberTypeId(Integer.parseInt(memberTypeId));
	packageDetailBean.setPackageId(Integer.parseInt(packageId));
	packageDetailBean.setPackageDetailId(Integer.parseInt(id));
		boolean isError=false;
		if(amount.equals(""))
			isError=true; 	 	
		else
			packageDetailBean.setAmount(Integer.parseInt(amount));
		
		if(isError)
		{
			request.setAttribute("packageDetailBean", packageDetailBean);
			request.getRequestDispatcher("PackageDetailUpdate.jsp").forward(request, response);
		}
		else
		{
			
			if(new PackageDetailDAO().updatePackage(packageDetailBean))
			{
				request.setAttribute("msgupdate", "succesffully updated");
				request.getRequestDispatcher("PackageDetailListServlet").forward(request, response);
				
			}
			else
			{
				request.setAttribute("packageDetailBean", packageDetailBean);
				request.setAttribute("msgupdate", "failed to update");
				request.getRequestDispatcher("PackageDetailUpdate.jsp").forward(request, response);
				
			}
		}
		
	}

}
