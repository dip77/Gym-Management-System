package com.digimation.goldengym.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.goldengym.bean.ProgressDetailBean;
import com.digimation.goldengym.dao.ProgressDetailDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class TrainerProgressDetailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");
		// String wrist=request.getParameter("wrist");
		String chest = request.getParameter("chest");
		String forearms = request.getParameter("forearms");
		// String bodyfat=request.getParameter("bodyfat");
		String thigh = request.getParameter("thigh");
		String biceps = request.getParameter("biceps");
		boolean isError = false;

		if (ValidateUtils.isEmpty(weight))
			isError = true;

		if (ValidateUtils.isEmpty(height))
			isError = true;

		if (isError) {
			request.getRequestDispatcher("TrainerProgressDetailInsert.jsp")
					.forward(request, response);
		} else {

			ProgressDetailBean progressDetailBean = new ProgressDetailBean();
			progressDetailBean.setWeight(Double.valueOf(weight));
			progressDetailBean.setHeight(Double.valueOf(height));
			/*
			 * if(!ValidateUtils.isEmpty("5"))
			 * progressDetailBean.setWrist(Double.valueOf("5"));
			 */if (!ValidateUtils.isEmpty(chest))
				progressDetailBean.setChest(Double.valueOf(chest));
			/*
			 * if(!ValidateUtils.isEmpty("5"))
			 * progressDetailBean.setBodyfat(Double.valueOf("10"));
			 */if (!ValidateUtils.isEmpty(forearms))
				progressDetailBean.setForearms(Double.valueOf(forearms));
			if (!ValidateUtils.isEmpty(thigh))
				progressDetailBean.setThigh(Double.valueOf(thigh));
			if (!ValidateUtils.isEmpty(biceps))
				progressDetailBean.setBiceps(Double.valueOf(biceps));
			progressDetailBean.setProgressId(Integer.parseInt(id.trim()));
			if (new ProgressDetailDAO().addProgressDetail(progressDetailBean)) {
				request.setAttribute("msginsert", "succesfully inserted");
				request.setAttribute("id", id);
				request.getRequestDispatcher("TrainerProgressDisplayServlet")
						.forward(request, response);

			} else {
				request.setAttribute("msginsert", "succesfully inserted");
				request.getRequestDispatcher("TrainerProgressDetailInsert.jsp")
						.forward(request, response);

			}

		}

	}

}
