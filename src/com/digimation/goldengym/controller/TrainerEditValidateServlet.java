package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.goldengym.bean.TrainerBean;
import com.digimation.goldengym.dao.TrainerDAO;
import com.digimation.goldengym.dao.CityDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class TrainerEditValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String trainerId=request.getParameter("id");
		String firstName=request.getParameter("firstName");
		String password=request.getParameter("password");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String city=request.getParameter("city");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		String Dob=request.getParameter("DOB");
		boolean isError=false;
		TrainerBean trainerBean=new TrainerBean();
		if(ValidateUtils.isEmpty(mobile))
		{
			isError=true;
		}
		
		else if(mobile.length()!=10){
			trainerBean.setMobile(mobile);
			request.setAttribute("msgmobile", "enter correct mobile no");
		}
		else
			trainerBean.setMobile(mobile);
		
		if(ValidateUtils.isEmpty(address))
		{
			isError=true;
		}
		
		else
			trainerBean.setAddress(address);
		
		if(ValidateUtils.isEmpty(Dob))
		{
			isError=true;
		}
		
		else
			trainerBean.setDob(Dob);
		
		if(ValidateUtils.isEmpty(firstName))
		{
			isError=true;
		}
		
		else
			trainerBean.setFirstName(firstName);
		if(ValidateUtils.isEmpty(lastName))
		{
			isError=true;
		}
		else
			trainerBean.setLastName(lastName);
		if(ValidateUtils.isEmpty(email))
		{
			isError=true;
			request.setAttribute("msgemail", "please enter email");
		}
		else if(!ValidateUtils.EmailFormatValidator(email))
		{
			trainerBean.setEmail(email);
			isError=true;
			request.setAttribute("msgemail", "please enter valid email");
		}
		else
			trainerBean.setEmail(email);
		trainerBean.setCityId(new CityDAO().getCityID(city));
		trainerBean.setGender(gender);
		trainerBean.setPassword(password);
		HttpSession session=request.getSession();
		TrainerBean trainerBean2=(TrainerBean)session.getAttribute("trainerBean");
		trainerBean.setExperiance(trainerBean2.getExperiance());
		if(isError)
		{
		request.setAttribute("trainerBean", trainerBean);
			request.getRequestDispatcher("TrainerEdit.jsp").forward(request, response);
		
		}
		else
		{
		if(gender.equals("male"))
			trainerBean.setGender("m");
		else
			trainerBean.setGender("f");
			trainerBean.setTrainerId(Integer.parseInt(trainerId));
			if(new TrainerDAO().updateTrainer(trainerBean))
			{
				request.setAttribute("msgupdate", " successfully updated");
				request.getRequestDispatcher("TrainerHeader.jsp").forward(request, response);
			
			}
			else
			{
				request.setAttribute("trainerBean", trainerBean);
				request.setAttribute("msgupdate", " failed to update ");
				request.getRequestDispatcher("TrainerEdit.jsp").forward(request, response);
				
			}
		}

	}

}
