<%@page import="com.digimation.goldengym.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdminUpdate</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>

	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>
	<form action="AdminEditValidateServlet?id=${param.id}" method="post"
		class="w3-half">
		<div class="w3-animate-left w3-container" style="margin-top: 20px;">
			<div class="w3-row w3-theme w3-animate-zoom" align="center">
				<h2>
					<i class="fa fa-building-o"></i> &emsp; Admin Update
				</h2>
			</div>
			<br />
			<div class="w3-row">
				<label class="w3-col m2"> Name </label>
				<div class="w3-col m4">
					<input required   type="text" name="firstName" id="firstName"
						placeholder="First Name" class="w3-input"
						value="${adminBean.firstName}" />
	
				</div>

				<div class="w3-col s1">&emsp;</div>

				<div class="w3-col m4">
					<input required   type="text" name="lastName" value="${adminBean.lastName}"
						id="lastName" placeholder="Last Name" class="w3-input" />
				</div>
				<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
				
			</div>
			<br />
			<div class="w3-row">
				<label class="w3-col m2"> Email</label>
				<div class="w3-col m9">
					<input required   type="email" name="email" readonly="readonly" id="email"
						value="${adminBean.email}" placeholder="example@goldenGym.com"
						class="w3-input" />${msgemail}
				</div>
			<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
			
			</div>
			<br />
			<div class="w3-row">
				<%
					String ml = "unchecked", fml = "unchecked";

					AdminBean adminBean = (AdminBean) request.getAttribute("adminBean");
					String gen = adminBean.getGender();
					if (gen != null && gen.equals("m"))
						ml = "checked";
					else if (gen != null)
						fml = "checked";
				%>
				<label class="w3-col m2"> Gender </label>
				<div class="w3-col m2">
					<input required   class="  w3-radio" type="radio" name="gender" value="male"
						<%=ml%> checked> <label class="w3-validate">Male</label>
				</div>
				<div class="w3-col m2">
					<input required   class="w3-radio  " type="radio" name="gender" value="female"
						<%=fml%>> <label class="w3-validate">Female</label>
				</div>
				<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
			</div>
			<br /> <br />
			<div class="w3-row">
				<label class="w3-col m2"> Password </label>
				<div class="w3-col m9">
					<input required   type="password" placeholder="Create Password"
						readonly="readonly" value="${adminBean.password}"
						class="w3-input" name="password" id="password" /> ${msgpwd}
				</div>
			<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
			
			</div>
			<br /> <br />
			<div class="w3-row">
				<label class="w3-col m2"> City </label>
				<div class="w3-col m9">
					<input required   type="text" class="w3-input" name="city"
						value="${adminBean.city}" placeholder="City" id="password" />
				</div>
			<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
			
			</div>
			<br /> <br /> <br /> <br />
			<div class="w3-row">
				<label class="w3-col m2"> &nbsp;</label>
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
</body>
</html>