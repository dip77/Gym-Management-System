<%@page import="com.digimation.goldengym.bean.TrainerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TrainerUpdate</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>

	<header><%@ include file="TrainerHeader.jsp"%></header>
	<form action="TrainerEditValidateServlet?id=${param.id}" method="post" >
		<div class="w3-animate-left w3-container"  align="center">
			<div class="w3-row">
			<h1 class="w3-theme"> Trainer Update Details</h1>
			</div>
			<br>
			<div class="w3-row">
				<label class="w3-col m3"> Name </label>
				<div class="w3-col m4">
					<input required   type="text" name="firstName" id="firstName"
						placeholder="First Name" class="w3-input"
						value="${trainerBean.firstName}" />
	
				</div>
					
				<div class="w3-col s1">&emsp;</div>

				<div class="w3-col m4">
					<input required   type="text" name="lastName" value="${trainerBean.lastName}"
						id="lastName" placeholder="Last Name" class="w3-input" />
				</div>
			</div>
			<br />
			<div class="w3-row">
				<label class="w3-col m3"> Email</label>
				<div class="w3-col m9">
					<input required   type="email" name="email" readonly="readonly" id="email"
						value="${trainerBean.email}" placeholder="example@goldenGym.com"
						class="w3-input" />${msgemail}
				</div>
			</div>
			<br />
			<div class="w3-row">
				<%
					String ml = "unchecked", fml = "unchecked";

					TrainerBean trainerBean = (TrainerBean) request.getAttribute("trainerBean");
					String gen = trainerBean.getGender();
					if (gen != null && gen.equals("m"))
						ml = "checked";
					else if (gen != null)
						fml = "checked";
				%>
				<label class="w3-col m3"> Gender </label>
				<div class="w3-col m3">
					<input required   class="  w3-radio" type="radio" name="gender" value="male"
						<%=ml%> checked> <label class="w3-validate">Male</label>
				</div>
				<div class="w3-col m3">
					<input required   class="w3-radio  " type="radio" name="gender" value="female"
						<%=fml%>> <label class="w3-validate">Female</label>
				</div>
				<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
			</div>
			<br /> 
			<div class="w3-row">
				<label class="w3-col m3"> Password </label>
				<div class="w3-col m9">
					<input required   type="password" placeholder="Create Password"
						readonly="readonly" value="${trainerBean.password}"
						class="w3-input" name="password" id="password" /> ${msgpwd}
				</div>
			</div>
			  <br />
			<div class="w3-row">
				<label class="w3-col m3"> City </label>
				<div class="w3-col m9">
					<input required   type="text" class="w3-input" name="city"
						value="${trainerBean.city}" placeholder="City" id="password" />
				</div>
			</div>
			 <br />
			<div class="w3-row">
				<label class="w3-col m3"> Date of Birth </label>
				<div class="w3-col m9">
					<input required   type="date" class="w3-input" name="DOB" value="${trainerBean.dob}" id="DOB" />
				</div>
			</div>
			  <br />
			<div class="w3-row">
				<label class="w3-col m3"> Address </label>
				<div class="w3-col m9">
					<textarea class="w3-input" name="address" id="address"
						placeholder="Address">${trainerBean.address}</textarea>
				</div>
			</div>
			   <br />
			 <div class="w3-row">
				<label class="w3-col m3"> Mobile </label>
				<div class="w3-col m9">
					<input required   type="number" class="w3-input" maxlength="10"
						placeholder="Mobile Number" name="mobile" value="${trainerBean.mobile}" id="mobile" />
						${msgmobile}
				</div>
			</div>
			  <br /> <br />
			<div class="w3-row">
				<label class="w3-col m3"> &nbsp;</label>
				<div class="w3-col m3">
					<input required   type="submit" class="w3-theme w3-round-xlarge w3-btn" />
				</div>
				<div class="w3-col m3">
					<input required   type="reset" class="w3-round-xlarge w3-red w3-btn" />
				</div>

			</div>
			<br />
		</div>
	</form>
	<%@include file="GFooter.jsp" %>
</body>
</html>