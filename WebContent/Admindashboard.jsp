<%@page import="com.digimation.goldengym.dao.FeedbackDAO"%>
<%@page import="com.digimation.goldengym.dao.UserInquiryDAO"%>
<%@page import="com.digimation.goldengym.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | DashBoard</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>

	<div class="w3-container w3-col m8">
		<div class="w3-row " align="center">
			<h1 class="w3-theme-d3 w3-col m12">
				<i class="fa-tachometer fa"></i> &nbsp;Admin Dashboard
			</h1>
		</div>
		<br />
		<div class="w3-row w3-animate-zoom">
			<div class="w3-col m12">
				<div class="panel panel-default gujju-card-8">
					<div align="center" class="panel-body w3-theme-d2"
						style="font-weight: bold;">Total</div>
				</div>
			</div>
		</div>
		<div class="w3-row">
			<div class="panel panel-primary w3-animate-zoom w3-col m3 w3-card-16">
				<div class="panel-heading w3-theme-d2">
					<i class="fa-user-plus fa" style="font-size: 24px"></i>Registration
				</div>
				<div class="panel-body" style="font-size: 16px; word-spacing: 6px"
					align="center"><%=new MemberDAO().getMemberList().size() %></div>
			</div>

			<div class="w3-col m1">&nbsp;</div>
			<div class="panel panel-primary w3-animate-zoom w3-col m4 w3-card-16">
				<div class="panel-heading w3-theme-d2">
					<i class="fa-edit fa" style="font-size: 24px">&nbsp; User
						Inquiry</i>
				</div>
				<div class="panel-body" align="center"><%=new UserInquiryDAO().getUserInquiryList().size() %></div>
			</div>
			<div class="w3-col m1">&nbsp;</div>
			<div class="panel panel-primary w3-animate-zoom w3-col m3 w3-card-16">
				<div class="panel-heading w3-theme-d2">
					<i class="fa-user-plus fa" style="font-size: 24px"></i>Feedback
				</div>
				<div class="panel-body" style="font-size: 16px; word-spacing: 6px"
					align="center"><%= new FeedbackDAO().getFeedbackList().size() %></div>
			</div>
		</div>

		<div class="w3-row w3-animate-zoom">
			<div class="w3-col m12">
				<div class="panel panel-default gujju-card-8">
					<div align="center" class="panel-body w3-theme-d2"
						style="font-weight: bold;" id="date"><script type="text/javascript">
							document.getElementById('date').innerHTML = "Today : "
									+ new Date().getDate()
									+ "/"
									+ (new Date().getMonth() + 1)
									+ "/"
									+ new Date().getFullYear();
						</script></div>
				</div>
			</div>
		</div>
		<div class="w3-row ">
			<div class="panel panel-primary w3-animate-zoom w3-col m3 w3-card-16">
				<div class="panel-heading w3-theme-d2">
					<i class="fa-user-plus fa" style="font-size: 24px"></i>Registration
				</div>
				<div class="panel-body" style="font-size: 16px; word-spacing: 6px"
					align="center"><%=new MemberDAO().getRegularMemberList().size() %></div>
			</div>

			<div class="w3-col m1">&nbsp;</div>
			<div class="panel panel-primary w3-animate-zoom w3-col m4 w3-card-16">
				<div class="panel-heading w3-theme-d2">
					<i class="fa-edit fa" style="font-size: 24px">&nbsp; User
						Inquiry</i>
				</div>
				<div class="panel-body" align="center"><%= new UserInquiryDAO().getRegularFeedbackList().size() %></div>
			</div>
			<div class="w3-col m1">&nbsp;</div>
			<div class="panel panel-primary w3-animate-zoom w3-col m3 w3-card-16">
				<div class="panel-heading w3-theme-d2">
					<i class="fa-user-plus fa" style="font-size: 24px"></i>Feedback
				</div>
				<div class="panel-body" style="font-size: 16px; word-spacing: 6px"
					align="center"><%= new FeedbackDAO().getRegularFeedbackList().size() %></div>
			</div>
		</div>
	</div>
	
<div class="w3-quarter">&nbsp;</div>
		<script type="text/javascript">
		$(document).ready(function() {
			$("#dashboard").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>
</body>
</html>