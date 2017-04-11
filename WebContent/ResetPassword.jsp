<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" href="photo's/goldenGym1.ico">
</head>
<body>

	<%@ include file="Header.jsp"%>
	<form action="ResetPasswordServlet?id=${param.id}" method="post" >

		<div class="container">
			<div class="w3-quarter">&emsp;</div>
			<div class="panel panel-default w3-half w3-card-8">
				<div class="panel-heading w3-theme" style="font-size: 24px;"
					align="center">
					<i class="fa-edit fa"></i> Reset Password
				</div>
				<div class="panel-body">
					<div class="w3-row">
						<div class="w3-col m3" style="font-size: 15px; font-weight: 800;">New
							Password</div>
						<div class="w3-col m9">
							<input required type="password" name="newPassword"
								placeholder="Create new Password" autofocus
								value="${param.newPassword}" class="w3-input">
						</div>

					</div>
					<br />
					<div class="w3-row">
						<div class="w3-col m3" style="font-size: 12px; font-weight: 800;">Confirm
							Password</div>
						<div class="w3-col m9">

							<input required type="password" name="confirmPassword"
								placeholder="Confirm Password" value="${param.confirmPassword}"
								class="w3-input ">${cpwd} ${msgcpwd}
						</div>

					</div>
					<br />
					<div class="w3-row" align="right">
						<div class="w3-col m3">
							<input type="submit" class="w3-btn w3-theme" />
						</div>
						<div class="w3-col m3">
							<input type="reset" class="w3-btn w3-red" />
						</div>
					</div>
					<div class="w3-row" align="right">
						<a href="LoginPage.jsp">Login Quickly ? </a>
					</div>
				</div>
			</div>
			<div class="w3-quarter">&emsp;</div>
		</div>
	</form>
	 

	<div style="margin-top: 380px;">
		<%@ include file="GFooter.jsp"%>
	</div>
</body>
</html>