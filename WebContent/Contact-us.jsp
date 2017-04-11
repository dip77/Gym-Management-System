<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
<link rel="icon" href="photo's/goldenGym1.ico">
</head>
<body>
	<%@ include file="Header.jsp"%>

	<div class="w3-container">
		<div class="panel panel-primary w3-card-16" align="center">
			<div class="panel-heading w3-theme">
				<label
					style="font-size: 24px; letter-spacing: 10px; font-style: italic; font-weight: 700;"
					class="w3-animate-zoom"><i class="fa-edit fa"></i> User
					Inquiry</label>
			</div>
			<div class="panel-body ">

				<form action="GuestUserInquiryServlet" method="post">

					<div class="w3-container">
						<div class="w3-row">${msginsert }</div>
						<div class="w3-row">
							<div class="w3-col m3">
								<label>First Name</label>
							</div>
							<div class="w3-col m6">
								<input required type="text" name="firstName"
									placeholder="First Name" class="w3-input">
							</div>
						</div>

						<div class="w3-row">
							<div class="w3-col m3">
								<label>Last Name</label>
							</div>
							<div class="w3-col m6">
								<input required type="text" name="lastName"
									placeholder="Last Name" class="w3-input">
							</div>
						</div>

						<div class="w3-row">
							<div class="w3-col m3">
								<label>Email</label>
							</div>
							<div class="w3-col m6">
								<input required type="email" name="email" placeholder="Email"
									class="w3-input">
							</div>
						</div>
						<div class="w3-row">
							<div class="w3-col m3">
								<label>Mobile</label>
							</div>
							<div class="w3-col m6">

								<input type="text" name="mobile" maxlength="10"
									placeholder="mobile" class="w3-input" required
									pattern="[0-9]{10}">
							</div>
						</div>

						<div class="w3-row">
							<div class="w3-col m3">
								<label>Inquiry</label>
							</div>
							<div class="w3-col m6">
								<textarea name="message" class="w3-input" 
									placeholder="Inquiry" required > </textarea>
							</div>
						</div>

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

	<%@ include file="GFooter.jsp"%>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#Contact").addClass("w3-theme-l2  w3-card-24 ");
		});
	</script>

</body>
</html>