package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.MemberTypeBean;
import com.digimation.goldengym.dao.MemberTypeDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class MemberTypeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String memberType=request.getParameter("memberType");
	boolean isError=false;
	if(ValidateUtils.isEmpty(memberType))
		isError=true;
	if(isError)
	{
		response.sendRedirect("MemberTypeInsert.jsp");
	}
	else
	{
		MemberTypeBean memberTypeBean=new MemberTypeBean();
		memberTypeBean.setMemberType(memberType);
		if(new MemberTypeDAO().insert(memberTypeBean))
		{
			request.setAttribute("msginsert", memberType+" succesfully inserted.");
			request.getRequestDispatcher("MemberTypeListServlet").forward(request, response); 
		}
		else
		{
			request.setAttribute("msginsert", "failed to add!");
			request.getRequestDispatcher("MemberTypeInsert.jsp").forward(request, response);
		}
	}
		
}

}
