<%@page import="com.digimation.goldengym.bean.UserInquiryBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>




	<%@ include file="AdminHeader.jsp"%>
<%@ include file="AdminSideBar.jsp" %>
	<div class="container w3-col m7">
		<div class="panel panel-primary w3-card-16" align="center">
			<div class="panel-heading w3-theme">
				<label
					style="font-size: 24px; letter-spacing: 10px; font-style: italic; font-weight: 700;"
					class="w3-animate-zoom"><i class="fa-edit fa"></i> User
					Inquiry</label>
			</div>
			<div class="panel-body ">

				<form action="UserInquiryValidateServlet?id=${param.id}"
					method="post">
					<div class="w3-container">
						<div class="w3-row">
							<div class="w3-col m3">
								<label>First Name</label>
							</div>
							<div class="w3-col m6">
								<input required type="text" class="w3-input" name="firstName"
									value="${listofInquiry.firstName}">
							</div>
						</div>

						<div class="w3-row">
							<div class="w3-col m3">
								<label>Last Name</label>
							</div>
							<div class="w3-col m6">
								<input required type="text" name="lastName"
									value="${listofInquiry.lastName}" class="w3-input">
							</div>
						</div>

						<div class="w3-row">
							<div class="w3-col m3">
								<label>Email</label>
							</div>
							<div class="w3-col m6">
								<input required type="text" name="email"
									value="${listofInquiry.email}" class="w3-input">

							</div>
						</div>
						<div class="w3-row">
							<div class="w3-col m3">
								<label>Mobile</label>
							</div>
							<div class="w3-col m6">
								<input required type="text" name="mobile"
									value="${listofInquiry.mobile}" class="w3-input">

							</div>
						</div>

						<div class="w3-row">
							<div class="w3-col m3">
								<label>Inquiry</label>
							</div>
							<div class="w3-col m6">
								<textarea rows="" cols="" placeholder="Inquiry" name="message"
									class="w3-input">${listofInquiry.message}</textarea>
							</div>
						</div>

						<br />
						<div class="w3-row">
							<div class="w3-col m3">
								<label>Is Read</label>
							</div>
							<div class="w3-col m6">
								<input type="radio" name="isread" value="y">Yes <input
									type="radio" name="isread" value="n">no
							</div>
						</div>

						<br />
						<div class="w3-row">
							<div class="w3-col m3">
								<input type="submit" class="w3-btn w3-theme">
							</div>
							<div class="w3-col m6">
								<input type="reset" class="w3-btn w3-red">
							</div>
						</div>

					</div>
				</form>

			</div>
		</div>
	</div>
</body>
</html>