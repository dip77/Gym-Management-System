<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="MainHeader.jsp"%>
<%
	if (session.getAttribute("trainerBean") == null) {

		request.setAttribute(
				"msglogin",
				"<div class='alert alert-danger'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a> please login to continue</div>  ");
		request.getRequestDispatcher("LoginPage.jsp").forward(request,
				response);
	}
%>

<nav class="navbar navbar-default w3-theme-d1 w3-card-8 w3-animate-top">
<div class="container-fluid">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#myNavbar">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a class="navbar-brand  w3-theme-d1" href="TrainerIndexPage.jsp"
			id="home"><i class="fa-home fa" style="font-size: 24px;"></i>Home
		</a>
	</div>
	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav" id="menu">
			<li id="schedule"><a
				href="TrainerScheduleDisplayServlet?id=${trainerBean.trainerId}"><i
					class="fa-newspaper-o fa" style="font-size: 24px"></i>
					&nbsp;Schedule</a></li>
			<li id="detail"><a
				href="MemberDisplayServlet?id=${trainerBean.trainerId}"><i
					class="fa-edit fa" style="font-size: 24px"></i> &nbsp;Member
					Details</a></li>

		</ul>
		<ul class="nav navbar-nav navbar-right">

			<li class="dropdown" id="edit"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <img
					src="upload/photo/${trainerBean.photo}" class="w3-circle"
					style="height: 40px; width: 50px;  position: inherit;margin-top: -12px;" />
					 <i style="text-transform:capitalize;">${trainerBean.firstName} ${trainerBean.lastName}</i><span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<li class="w3-theme"></li>
					<li><a href="TrainerEditServlet?id=${trainerBean.trainerId}">Edit
							Profile</a></li>
					<li><a
						href="TrainerChangePassword.jsp?id=${trainerBean.trainerId}">Change
							Password</a></li>
					<li><a href="TrainerLogoutServlet">Log out</a></li>
				</ul></li>
		</ul>
	</div>
</div>
</nav>

<script>
	$(document).ready(function() {
		$("#home,#schedule,#detail , #progress,#edit").mouseleave(function() {
			$(this).addClass("w3-theme-d1");
			$(this).css({
				"transition" : "1s"
			});
			$(this).removeClass("w3-card-16 ");
		});

		$("#home,#schedule ,#detail , #progress,#edit").mouseenter(function() {
			$(this).addClass("w3-white w3-card-16");
			$(this).removeClass("w3-theme-d1");
		});
	});
</script>
