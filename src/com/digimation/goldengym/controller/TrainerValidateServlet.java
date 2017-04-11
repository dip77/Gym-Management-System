package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.TrainerBean;
import com.digimation.goldengym.dao.CityDAO;
import com.digimation.goldengym.dao.TrainerDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class TrainerValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainerBean trainerBean=new TrainerBean();
		String trainerId=request.getParameter("id");
		String firstName=request.getParameter("firstName");
	 	String lastName=request.getParameter("lastName");
	 	String email=request.getParameter("email");
	 	String mobile=request.getParameter("mobile");
	 	String address=request.getParameter("address");
	 	String gender=request.getParameter("gender");
	 	String dob=request.getParameter("DOB");
	 	String city=request.getParameter("city");
	 	String password=request.getParameter("password");
	 	String experiance=request.getParameter("experiance");
	 	boolean isError=false;
	 	trainerBean.setPassword(password);	
	 	trainerBean.setEmail(email);
	 	if(ValidateUtils.isEmpty(firstName))
	 		isError=true;
	 	else
	 		trainerBean.setFirstName(firstName);
	 	if(ValidateUtils.isEmpty(lastName))
	 		isError=true;
	 	else
	 		trainerBean.setLastName(lastName);
	 	if(ValidateUtils.isEmpty(mobile))
	 		isError=true; 	
	 	else if(mobile.length()<10){
	 		request.setAttribute("msgmobile", "please enter correct mobile no");
	 		trainerBean.setMobile(mobile);	
	 	}
	 	else
	 		trainerBean.setMobile(mobile);
	 	
	 	if(ValidateUtils.isEmpty(city))
	 		isError=true;
	 	else
	 		trainerBean.setCity(city);
	 	if(ValidateUtils.isEmpty(experiance))
	 		isError=true;
	 	else
	 		trainerBean.setExperiance(Integer.parseInt(experiance));
	 	if(ValidateUtils.isEmpty(address))
	 		isError=true;
	 	else
	 		trainerBean.setAddress(address);
	 	if(ValidateUtils.isEmpty(dob))
	 		isError=true;
	 	else
	 		trainerBean.setDob(dob);
	 	
	 	if(gender.equals("male"))
 			trainerBean.setGender("m");
 		else
 			trainerBean.setGender("f");
	 	trainerBean.setTrainerId(Integer.parseInt(trainerId));
 		
	 	if(isError)
	 	{
	 		request.setAttribute("trainerBean", trainerBean);
	 		request.getRequestDispatcher("TrainerRegistration.jsp").forward(request, response);
	 	}
	 	else
	 	{
	 		
	 		
	 		
	 		trainerBean.setCityId(new CityDAO().getCityID(city));
	 		if(new TrainerDAO().updateTrainer(trainerBean))
	 		{
	 			request.setAttribute("msginsert", email+" is successfully updated");
	 			request.getRequestDispatcher("TrainerListServlet").forward(request, response);
	 		}
	 		else
	 		{
	 			request.setAttribute("msginsert", " error occured");
	 			request.getRequestDispatcher("TrainerUpdate.jsp").forward(request, response);
	 		}
	 	}
	

	}

}
