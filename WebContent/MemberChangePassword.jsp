<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<header><%@ include file="UserHeader.jsp"%></header>
<div class="w3-container">
	<div class="w3-quarter">.</div>
	<form action="MemberResetPasswordServlet" method="post">

		<div class=" w3-half" >
			<div class="panel panel-default">
				<div class="panel-heading w3-theme-l2">Change Password</div>
				<div class="panel-body">

					<label class="w3-row">Old Password</label>
					<div class="w3-row">
						<input required type="password" placeholder="old Password" class="w3-input"
							name="oldPassword" value="${param.oldPassword}">
					</div>
					<div class="w3-row">New Password</div>
					<div class="w3-row">
						<input required type="password" class="w3-input" placeholder="Create New Password"
							name="newPassword" value="${param.newPassword}">
					</div>

					<div class="w3-row">Confirm Password</div>
					<div class="w3-row">
						<input required type="password" class="w3-input" placeholder="Confirm Password"
							name="confirmPassword" value="${param.confirmPassword}">
						${msgcpwd}
					</div>
					<br />
					<div class="w3-row">
						<div class="w3-col m3">
							<input type="submit" class="w3-btn w3-theme">
						</div>

						<div class="w3-col m3">
							<input type="reset" class="w3-btn w3-red">
						</div>

					</div>

				</div>
			</div>
		</div>
	</form>
	<div class="w3-quarter">.</div>
	</div>
	<%@ include file="GFooter.jsp" %>
</body>
</html>