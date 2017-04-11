<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="icon" href="photo's/goldenGym1.ico">
</head>
<body>
	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>
	<div class="w3-container w3-col m7">
		<div class="panel panel-primary w3-card-16" align="center">
			<div class="panel-heading w3-theme">
				<label
					style="font-size: 24px; letter-spacing: 10px; font-style: italic; font-weight: 700;"
					class="w3-animate-zoom"><i class="fa-edit fa"></i> Change
					Password</label>
			</div>
			<div class="panel-body ">
				<form action="AdminResetPasswordServlet" class="w3-container"
					method="post">
					<div class="w3-row">
						<div class="w3-col m3">
							<label>Old Password</label>
						</div>
						<div class="w3-col m6">
							<input required class="w3-input" placeholder="Old Password" type="password"
								name="oldPassword" value="${param.oldPassword}">
						</div>
					</div>

					<div class="w3-row">
						<div class="w3-col m3">
							<label>New Password</label>
						</div>
						<div class="w3-col m6">
							<input required class="w3-input" placeholder="Create New Password" type="password"
								name="newPassword" value="${param.newPassword}">
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-col m3">
							<label>Confirm Password</label>
						</div>
						<div class="w3-col m6">
							<input required class="w3-input" placeholder="Confirm new Password" type="password"
								name="confirmPassword" value="${param.confirmPassword}">
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


				</form>
			</div>

		</div>
	</div>

</body>
</html>