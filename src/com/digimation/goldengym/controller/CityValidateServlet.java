package com.digimation.goldengym.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.CityBean;
import com.digimation.goldengym.dao.CityDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class CityValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cityName=request.getParameter("txtCityName");
		String id=request.getParameter("id");
		CityBean cityBean=new CityBean();
		boolean isError=false;
	if(ValidateUtils.isEmpty(cityName))
	{
		isError=true;
		request.setAttribute("msgcityname", "*");
	}
	else if(ValidateUtils.validateText(cityName))
	{
		isError=true;
		request.setAttribute("mscityname", "please enter valid city name");
	}
	
	else
		cityBean.setCityName(cityName);
		
	if(isError)
	{
	request.setAttribute("cityBean", cityBean);
		request.getRequestDispatcher("CityUpdate.jsp").forward(request, response);
	}
		else
	{
		
		cityBean.setCityId(Integer.parseInt(id));
		if(new CityDAO().updateCity(cityBean)){
			request.setAttribute("msgcity", " successfully updated");
			request.getRequestDispatcher("CityListServlet").forward(request, response);
		}
			//in else duplicatation error may come
		else{
			request.setAttribute("msgcity", "failed to update "+cityName);//use less
	    	request.getRequestDispatcher("CityUpdate.jsp").forward(request, response);
		}
	
	}


}
}