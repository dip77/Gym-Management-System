package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.MemberTypeBean;
import com.digimation.goldengym.dao.MemberTypeDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class MemberTypeValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberType=request.getParameter("memberType");
		String memberTypeId=request.getParameter("id");
		System.out.println(memberType+memberTypeId);
		boolean isError=false;
		if(ValidateUtils.isEmpty(memberType))
			isError=true;
		if (isError) {
			response.sendRedirect("MemberTypeUpdateServlet");
		}
		else
		{
			MemberTypeBean memberTypeBean=new MemberTypeBean();
			memberTypeBean.setMemberTypeId(Integer.parseInt(memberTypeId));
			memberTypeBean.setMemberType(memberType);
			if(new MemberTypeDAO().update(memberTypeBean))
			{
				request.setAttribute("msgupdate", "successfully updated");
				request.getRequestDispatcher("MemberTypeListServlet").forward(request, response);
			}
			else
			{
				request.setAttribute("msgupdate", "failed to update!");
				request.getRequestDispatcher("MemberTypeUpdate.jsp").forward(request, response);
			}
		}
	}

}
