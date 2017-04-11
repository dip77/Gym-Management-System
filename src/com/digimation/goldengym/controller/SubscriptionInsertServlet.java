package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.MemberBean;
import com.digimation.goldengym.bean.PackageDetailBean;
import com.digimation.goldengym.bean.SubscriptionBean;
import com.digimation.goldengym.dao.MemberDAO;
import com.digimation.goldengym.dao.PackageDetailDAO;
import com.digimation.goldengym.dao.SubscriptionDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class SubscriptionInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memberId=request.getParameter("user");
		String id=request.getParameter("id");
		boolean isError=false;
		if(ValidateUtils.isEmpty(memberId))
			isError=true;
		if (isError) {
			response.sendRedirect("SubscriptionInsert.jsp");
		}
		else
		{
			SubscriptionBean subscriptionBeanObj=new SubscriptionBean();
			subscriptionBeanObj.setMemberId(Integer.parseInt(memberId));
			subscriptionBeanObj.setPackageDetailId(Integer.parseInt(id));
			PackageDetailBean packageDetailBean= new PackageDetailDAO().getPackageListByPK(Integer.parseInt(id));
			subscriptionBeanObj.setDuration(new SubscriptionDAO().getDuration(Integer.parseInt(id)));
			if(new SubscriptionDAO().addSubscription(subscriptionBeanObj))
			{
				
				MemberBean memberBean=new MemberDAO().getMemberListByPK(Integer.parseInt(memberId));
				request.setAttribute("memberBean", memberBean);
				request.setAttribute("packageDetailBean",packageDetailBean);
				request.setAttribute("subscriptionBean",subscriptionBeanObj);
				//request.setAttribute("msginsert","succesfully inserted");
				request.getRequestDispatcher("Invoice.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msginsert","failed to insert");
				request.getRequestDispatcher("SubscriptionInsert.jsp").forward(request, response);
			}
			
		}
	}

}
