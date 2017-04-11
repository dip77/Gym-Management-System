package com.digimation.goldengym.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.digimation.goldengym.bean.MemberBean;
import com.digimation.goldengym.bean.TrainerBean;
import com.digimation.goldengym.dao.CityDAO;
import com.digimation.goldengym.dao.MemberDAO;
import com.digimation.goldengym.dao.TrainerDAO;
import com.digimation.goldengym.dao.TrainerDAO;
import com.digimation.goldengym.util.ValidateUtils;

public class TrainerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		TrainerBean trainerBean=new TrainerBean();
		boolean isError=false;
		
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> items=null;
		
		String fieldName=null;
		String fieldValue=null;
		File file=null;
		String firstName = null,lastName= null,email = null,mobile= null,
		 address= null,gender= null,dob= null,password= null,confirmPassword= null,city = null,fileName= null,experience=null;
		ServletContext context = getServletContext();
		try {
		
			items=upload.parseRequest(request);
		for(int i=0;i<items.size();i++)
		{	
			FileItem item=items.get(i);
			if(item.isFormField())
			{
				fieldName=item.getFieldName();
				fieldValue=item.getString();
				
					if(fieldName.equals("firstName"))
					{
						firstName=fieldValue;
						System.out.println(firstName);
						}
					else if(fieldName.equals("dob"))
					{
						dob=fieldValue;
						System.out.println(dob);
					}
					else if(fieldName.equals("lastName"))
					{
						lastName=fieldValue;
					}
					else if(fieldName.equals("email"))
					{
						email=fieldValue;
					}
					else if(fieldName.equals("mobile"))
					{	
						mobile=fieldValue;
					}
					else if(fieldName.equals("address"))
					{
						address=fieldValue;
					}
					else if(fieldName.equals("gender"))
					{
						gender=fieldValue;
					}
					else if(fieldName.equals("DOB"))
					{
						dob=fieldValue;
					}
					else if(fieldName.equals("password"))
					{
						password=fieldValue;
					}
					else if(fieldName.equals("experiance"))
					{
						experience=fieldValue;
						System.out.println(experience);
					}
					else if(fieldName.equals("confirmPassword"))
					{
						confirmPassword=fieldValue;
					}
					else if(fieldName.equals("city"))
					{
						city=fieldValue;
					}
					

			}
			else
			{
				fieldName=item.getFieldName();
				fileName=item.getName();
				System.out.println("file name"+fieldName);
				String path = "F:\\java\\eclipse workspace\\GoldenGym/WebContent/upload/photo";
				file=new File(path+File.separator+fileName);
				if(fileName.isEmpty())
				{
					isError=true;
					request.setAttribute("msgfile","please select passport size photo");
				}
				else
				{
					if (context.getMimeType(fileName).equals("image/gif")
							|| context.getMimeType(fileName)
									.equals("image/jpeg")
							|| context.getMimeType(fileName)
									.equals("image/png"))
						try {
							item.write(file);
							trainerBean.setPhoto(fileName);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					else
							request.setAttribute("msgfile","Please upload files that end in types .png,.jpeg only.");

				}
			}
		}
		if(ValidateUtils.isEmpty(firstName))
	 		isError=true;
		else
			trainerBean.setFirstName(firstName);
	 	if(ValidateUtils.isEmpty(lastName))
	 		isError=true;
	 	else
	 		trainerBean.setLastName(lastName);
	 	if(ValidateUtils.isEmpty(email))
	 		isError=true;
	 	else if(!ValidateUtils.EmailFormatValidator(email))
	 	{
	 		isError=true;
	 		trainerBean.setEmail(email);
	 		request.setAttribute("msgemail", "please enter valid email");
	 		
	 	}
	 	else
	 		trainerBean.setEmail(email);
	 	if(ValidateUtils.isEmpty(password))
	 		isError=true;
	 	else
	 		trainerBean.setPassword(password);
	 	
	 	if(ValidateUtils.isEmpty(confirmPassword))
	 		isError=true;
	 	else if(password!=null && !password.equals(confirmPassword))
	 		request.setAttribute("msgcpwd", "confirm password does not match");
	 	if(ValidateUtils.isEmpty(mobile))
	 		isError=true; 	
	 	else if(mobile.length()<10){
	 		request.setAttribute("msgmobile", "please enter correct mobile no");
	 		trainerBean.setMobile(mobile);
	 	}
	 	else
	 		trainerBean.setMobile(mobile);
	 	if(ValidateUtils.isEmpty(address))
	 		isError=true;
	 	else
	 		trainerBean.setAddress(address);
	 	if(ValidateUtils.isEmpty(city))
	 		isError=true;
	 	else
	 		trainerBean.setCity(city);
	 	if(ValidateUtils.isEmpty(dob))
	 		isError=true;
	 	else
	 		trainerBean.setDob(dob);
	 	if(ValidateUtils.isEmpty(experience))
	 		isError=true;
	 	else
	 		trainerBean.setExperiance(Integer.parseInt( experience.trim()));
	 	
	 	if(isError)
	 	{
	 		request.setAttribute("trainerBean", trainerBean);
	 	
	 		request.getRequestDispatcher("TrainerRegistration.jsp").forward(request, response);
	 	}
	 	else
	 	{
	 			 		 		
	 		if(gender.equals("male"))
	 			trainerBean.setGender("m");
	 		else
	 			trainerBean.setGender("f");
	 			trainerBean.setCityId(new CityDAO().getCityID(city));
	 			
	 		if(new TrainerDAO().addTrainer(trainerBean))
	 		{
	 			request.setAttribute("msginsert", email+" is successfully added");
	 			request.getRequestDispatcher("TrainerListServlet").forward(request, response);
	 		}
	 		else
	 		{
	 			request.setAttribute("trainerBean", trainerBean);
	 			request.setAttribute("msginsert", " error occured");
	 			request.getRequestDispatcher("TrainerRegistration.jsp").forward(request, response);
	 		}
	 			
	 		}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
