<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
<%@ include file="AdminHeader.jsp" %>
<%@ include file="AdminSideBar.jsp" %>
	<div class="w3-container w3-col m7">
		<div class="panel panel-primary w3-card-16" align="center">
			<div class="panel-heading w3-theme">
				<label
					style="font-size: 24px; letter-spacing: 10px; font-style: italic; font-weight: 700;"
					class="w3-animate-zoom"><i class="fa-edit fa"></i> User
					Inquiry</label>
			</div>
			<div class="panel-body ">

				<form action="UserInquiryInsertServlet" method="post">
					<div class="w3-container">
						<div class="w3-row">
							<div class="w3-col m3">
								<label>First Name</label>
							</div>
							<div class="w3-col m6">
								<input required type="text" name="firstName"
									placeholder="First Name" class="w3-input"
									value="${param.firstName }">
							</div>
						</div>

						<div class="w3-row">
							<div class="w3-col m3">
								<label>Last Name</label>
							</div>
							<div class="w3-col m6">
								<input required type="text" name="lastName"
									placeholder="Last Name" class="w3-input"
									value="${param.lastName }">
							</div>
						</div>

						<div class="w3-row">
							<div class="w3-col m3">
								<label>Email</label>
							</div>
							<div class="w3-col m6">
								<input required type="email" name="email" placeholder="Email"
									class="w3-input" value="${param.email }">
							</div>
						</div>
						<div class="w3-row">
							<div class="w3-col m3">
								<label>Mobile</label>
							</div>
							<div class="w3-col m6">

								<input required type="text" name="mobile" placeholder="mobile"
									class="w3-input" value="${param.mobile }">
							</div>
						</div>

						<div class="w3-row">
							<div class="w3-col m3">
								<label>Inquiry</label>
							</div>
							<div class="w3-col m6">
								<textarea name="message" class="w3-input" required
									placeholder="Inquiry">${param.firstName}</textarea>
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
		<script type="text/javascript">
		$(document).ready(function() {
			$("#userInquiry").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>
</body>
</html>