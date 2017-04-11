<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainer | Change Password</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<%@ include file="TrainerHeader.jsp"%>

	<form action="TrainerResetPasswordServlet" method="post">
		<div class="w3-container ">
			<div class="w3-row">

				<label class="w3-col m3">Old Password</label>
				<div class="w3-m8">
					<input required   type="password" name="oldPassword" class="w3-input"
						value="${param.oldPassword}">
				</div>
			</div>
			<div class="w3-row">

				<label class="w3-col m3">New Password</label>
				<div class="w3-m8">
					<input required   type="password" class="w3-input" name="newPassword"
						value="${param.newPassword}">
				</div>
			</div>
			<div class="w3-row">

				<label class="w3-col m3">Confirm Password </label>
				<div class="w3-m8">
					<input required   type="password" name="confirmPassword" class="w3-input"
						value="${param.confirmPassword}"> ${msgcpwd}
				</div>
			</div>
			<br />
			<div class="w3-row">
				<div class="w3-col m3">
					<input required   type="submit" class="w3-btn w3-theme">
				</div>
				<div class="w3-col m3">
					<input required   type="reset" class="w3-btn w3-red">
				</div>
			</div>
		</div>
	</form>
<footer style="margin-top: 120px;"> <%@ include file="GFooter.jsp" %></footer>
</body>
</html>