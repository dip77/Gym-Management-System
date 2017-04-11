<%@page import="com.digimation.goldengym.bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MemberUpdate</title>
<link rel="icon" href="photo's/goldenGym1.ico">
</head>
<body>
	<header><%@ include file="UserHeader.jsp"%></header>


	<div class="w3-container" align="center">
		<div class="panel panel-default">
			<div class="panel-heading w3-theme" style="font-size: 20px;"><i class="fa-edit fa"></i>&emsp; ${memberBean.firstName}'s Edit
				Profile</div>
			<div class="panel-body">

				<form action="MemberEditValidateServlet?id=${param.id}"
					method="post">
					<div class="w3-animate-left  " style="margin-top: 20px;">
						<div class="w3-row">
							<label class="w3-col m2"> Name </label> <span class="w3-col m2">
								<input required type="text" name="firstName" id="firstName"
								placeholder="First Name" class="w3-input"
								value="${memberBean.firstName}" />

							</span>

							<div class="w3-col s1">&emsp;</div>

							<span class="w3-col m2"> <input required type="text"
								name="lastName" value="${memberBean.lastName}" id="lastName"
								placeholder="Last Name" class="w3-input" />
							</span>
						</div>
						<br />
						<div class="w3-row">
							<label class="w3-col m2"> Email</label> <span class="w3-col m5">
								<input required type="email" name="email" readonly="readonly"
								id="email" value="${memberBean.email}"
								placeholder="example@goldenGym.com" class="w3-input" />${msgemail}
							</span>
						</div>
						<br />
						<div class="w3-row">
							<%
								String ml = "unchecked", fml = "unchecked";
								MemberBean memberBean = (MemberBean) request
										.getAttribute("memberBean");
								String gen = memberBean.getGender();
								if (gen != null && gen.equals("m"))
									ml = "checked";
								else if (gen != null)
									fml = "checked";
							%>
							<label class="w3-col m2"> Gender </label> <span class="w3-col m2">
								<input required class="  w3-radio" type="radio" name="gender"
								value="male" <%=ml%> checked> <label
								class="w3-validate">Male</label>
							</span> <span class="w3-col m2"> <input required
								class="w3-radio  " type="radio" name="gender" value="female"
								<%=fml%>> <label class="w3-validate">Female</label>
							</span> <span class="w3-col s1" style="font-size: 20px; color: red;">*</span>
						</div>
						<br />
						<div class="w3-row">
							<label class="w3-col m2"> Date of Birth </label>
							<div class="w3-col m5">
								<input required type="date" class="w3-input" name="DOB"
									value="${memberBean.dob}" id="DOB" />
							</div>
						</div>
						<br />
						<div class="w3-row">
							<label class="w3-col m2"> Address </label>
							<div class="w3-col m5">
								<textarea class="w3-input" name="address" id="address"
									placeholder="Address">${memberBean.address}</textarea>
							</div>
						</div>
						<br />

						<div class="w3-row">
							<label class="w3-col m2"> Mobile </label>
							<div class="w3-col m5">
								<input required type="number" class="w3-input" maxlength="10"
									placeholder="Mobile Number" name="mobile"
									value="${memberBean.mobile}" id="mobile" /> ${msgmobile}
							</div>
						</div>

						<br />
						<div class="w3-row">
							<label class="w3-col m2"> Password </label>
							<div class="w3-col m5">
								<input required type="password" placeholder="Create Password"
									readonly="readonly" value="${memberBean.password}"
									class="w3-input" name="password" id="password" /> ${msgpwd}
							</div>
						</div>
						<br /> <br />
						<div class="w3-row">
							<label class="w3-col m2"> City </label>
							<div class="w3-col m5">
								<input required type="text" class="w3-input" name="city"
									value="${memberBean.city}" placeholder="City" id="password" />
							</div>
						</div>
						<br /> <br /> <br /> <br />
						<div class="w3-row">
							<label class="w3-col m2"> &nbsp;</label>
							<div class="w3-col m3">
								<input required type="submit"
									class="w3-theme w3-round-xlarge w3-btn" />
							</div>
							<div class="w3-col m3">
								<input required type="reset"
									class="w3-round-xlarge w3-red w3-btn" />
							</div>

						</div>
						<br />
					</div>
				</form>
			</div>
		</div>
	</div>


<%@ include file="GFooter.jsp" %>
	
</body>
</html>