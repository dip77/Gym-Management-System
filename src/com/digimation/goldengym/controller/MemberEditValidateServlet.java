package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.MemberBean;
import com.digimation.goldengym.dao.CityDAO;
import com.digimation.goldengym.dao.MemberDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class MemberEditValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberBean memberBean=new MemberBean();
		String memberId=request.getParameter("id");
		String firstName=request.getParameter("firstName");
	 	String lastName=request.getParameter("lastName");
	 	String email=request.getParameter("email");
	 	String mobile=request.getParameter("mobile");
	 	String address=request.getParameter("address");
	 	String gender=request.getParameter("gender");
	 	String dob=request.getParameter("DOB");
	 	String city=request.getParameter("city");
	 	boolean isError=false;
	 	if(ValidateUtils.isEmpty(firstName))
	 		isError=true;
	 	else
	 		memberBean.setFirstName(firstName);
	 		
	 	if(ValidateUtils.isEmpty(lastName))
	 		isError=true;
	 	else 
	 		memberBean.setLastName(lastName);
	 	
	 	if(ValidateUtils.isEmpty(mobile))
	 		isError=true; 	
	 	else if(mobile.length()<10){
	 		request.setAttribute("msgmobile", "please enter correct mobile no");
	 		memberBean.setMobile(mobile);	
	 	}
	 	else 
	 	memberBean.setMobile(mobile);
	 	
	 	if(ValidateUtils.isEmpty(address))
	 		isError=true;
	 	else
	 		memberBean.setAddress(address);
	 	if(ValidateUtils.isEmpty(city))
	 		isError=true;
	 	else memberBean.setCity(city);
	 	if(ValidateUtils.isEmpty(dob))
	 		isError=true;
	 	else memberBean.setDob(dob);
	 	
	 	if(gender.equals("male"))
 			memberBean.setGender("m");
 		else
 			memberBean.setGender("f");
 			
 		
	 	memberBean.setMemberId(Integer.parseInt(memberId));
	 	if(isError)
	 	{
	 		request.setAttribute("memberBean", memberBean);
	 		request.getRequestDispatcher("MemberEdit.jsp").forward(request, response);
	 	}
	 	else
	 	{
	 		
	 		
	 		memberBean.setCityId(new CityDAO().getCityID(city));
	 		if(new MemberDAO().updateMember(memberBean))
	 		{
	 			request.setAttribute("msginsert", email+" is successfully updated");
	 			request.getRequestDispatcher("UserIndexPage.jsp").forward(request, response);
	 		}
	 		else
	 		{
	 			request.setAttribute("msginsert", " error occured");
	 			request.getRequestDispatcher("MemberEdit.jsp").forward(request, response);
	 		}
	 	}

	}

}
