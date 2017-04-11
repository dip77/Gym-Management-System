package com.digimation.goldengym.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.goldengym.bean.MemberBean;
import com.digimation.goldengym.bean.TrainerBean;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 * Servlet implementation class MemberGenerateQRcodeServlet
 */
public class MemberGenerateQRcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberGenerateQRcodeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		TrainerBean trainerBean = (TrainerBean) session
				.getAttribute("trainerBean");
		MemberBean memberBean = (MemberBean) session.getAttribute("memberBean");
		if (memberBean != null) {

			// creating qr code
			ByteArrayOutputStream out = QRCode
					.from(memberBean.getFirstName() + "-"
							+ memberBean.getLastName() + "-"
							+ memberBean.getEmail() + "-"
							+ memberBean.getIsActive()).to(ImageType.GIF)
					.stream();

			FileOutputStream fout = new FileOutputStream(new File(
					"E:\\GoldenGym\\WebContent\\upload\\QRCode\\"
							+ memberBean.getMemberId()
							+ memberBean.getFirstName() + ".gif"));
			fout.write(out.toByteArray());
			fout.flush();
			fout.close();

			request.getRequestDispatcher("MemberICard.jsp").forward(request,
					response);
			// ending creating coder

		} else if (trainerBean != null) {
			// creating qr code
			ByteArrayOutputStream out = QRCode
					.from(trainerBean.getFirstName() + "-"
							+ trainerBean.getLastName() + "-"
							+ trainerBean.getExperiance() + "-"
							+ trainerBean.getEmail() + "-"
							+ trainerBean.getIsActive() + "-"
							+ trainerBean.getDob()).to(ImageType.GIF).stream();

			FileOutputStream fout = new FileOutputStream(new File(
					"F:\\java\\eclipse workspace\\GoldenGym\\WebContent\\upload\\QRCode\\"
							+ trainerBean.getTrainerId()
							+ trainerBean.getFirstName() + ".gif"));
			fout.write(out.toByteArray());
			fout.flush();
			fout.close();

			request.getRequestDispatcher("MemberICard.jsp").forward(request,
					response);
			// ending creating coder

		}
	}

}
