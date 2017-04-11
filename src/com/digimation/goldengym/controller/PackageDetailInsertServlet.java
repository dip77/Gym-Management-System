package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.PackageDetailBean;
import com.digimation.goldengym.dao.PackageDetailDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class PackageDetailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String packageId=request.getParameter("package");
		String activityId=request.getParameter("activity");
		String amount=request.getParameter("amount");
		String memberTypeId=request.getParameter("memberType");
		boolean isError=false;
		if(ValidateUtils.isEmpty(amount))
			isError=true;
		if(packageId.equals("-1"))
			isError=true;
		if(memberTypeId.equals("-1"))
			isError=true;
		if(activityId.equals("-1"))
			isError=true;
		if(isError)
		{
			request.getRequestDispatcher("PackageDetailInsert.jsp").forward(request, response);
		}
		else
		{
			PackageDetailBean packageDetailBean=new PackageDetailBean();
			packageDetailBean.setPackageId(Integer.parseInt(packageId));
			packageDetailBean.setActivityId(Integer.parseInt(activityId));
			packageDetailBean.setAmount(Integer.parseInt(amount));
			packageDetailBean.setMemberTypeId(Integer.parseInt(memberTypeId));
			if(new PackageDetailDAO().addPackage(packageDetailBean))
			{
				request.setAttribute("msginsert","successfully inserted");
				request.getRequestDispatcher("PackageDetailListServlet").forward(request, response);
			}
			else
			{
				request.setAttribute("msginsert","failed to insert");
				request.getRequestDispatcher("PackageDetailInsert.jsp").forward(request, response);
			}
			
		}
	}	

}
