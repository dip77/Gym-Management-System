<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About us</title>
</head>
<body>
<%@ include file="UserHeader.jsp" %>
	<form action="MemberFeedbackInsertServlet" method="post">
		<div class="w3-container ">
<div class="w3-quarter" style="margin-top: 200px;	">&nbsp;</div>
			<div class="panel panel-primary w3-card-16 w3-half" align="center">
				<div class="panel-heading w3-theme">
					<label
						style="font-size: 24px; letter-spacing: 10px; font-style: italic; font-weight: 700;"
						class="w3-animate-zoom"> Feedback</label>
				</div>
				<div class="panel-body ">

					<div class="w3-container">
						<div class="w3-row">
							<div class="w3-col m3">
								<label>Feedback</label>
							</div>
							<div class="w3-col m6">
								<textarea required class="w3-input" name="feedback"></textarea>
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
				</div>
			</div>
			<div class="w3-quarter" style="margin-top: 200px;">&nbsp;</div>
		</div>
	</form>
	<div style="margin-top: 200px;">
<%@ include file="GFooter.jsp" %>
</div></body>
</html>