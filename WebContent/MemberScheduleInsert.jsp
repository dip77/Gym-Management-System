<%@page import="com.digimation.goldengym.dao.TrainerDAO"%>
<%@page import="com.digimation.goldengym.bean.TrainerBean"%>
<%@page import="com.digimation.goldengym.dao.MemberDAO"%>
<%@page import="com.digimation.goldengym.bean.MemberTypeBean"%>
<%@page import="com.digimation.goldengym.bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.digimation.goldengym.dao.ScheduleTimeDAO"%>
<%@page import="com.digimation.goldengym.bean.ScheduleTimeBean"%>
<%@page import="com.digimation.goldengym.bean.ActivityBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.goldengym.dao.ActivityDAO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin |Member Schedule Insert</title>

<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>
	<form action="MemberScheduleInsertServlet" method="post"
		class="w3-half">

		<div class="w3-animate-left w3-container" style="margin-top: 20px;">
			<div class="w3-row" align="center">
				<h1 class="w3-theme">
					<i class="fa-user fa"></i>Member Schedule
				</h1>
			</div>
			<div class="w3-row">
				<label> Activity</label>
			</div>
			<div class="w3-row">
				<select name="activity" class="w3-input">
					<option value="-1">Select Activity</option>
					<%
						ArrayList listofactivity = new ActivityDAO().getActivityList();
						for (int i = 0; i < listofactivity.size(); i++) {
							ActivityBean activityBean = (ActivityBean) listofactivity
									.get(i);
							String ac = request.getParameter("activity");
							String tmp = "unselected";
							if (ac != null && ac.equals(activityBean.getActivityId() + ""))
								tmp = "selected";
					%>
					<option value="<%=activityBean.getActivityId()%>" <%=tmp%>><%=activityBean.getActivity()%></option>

				<%
					}
				%>
				</select>

			</div>
			<br /> <label class="w3-row">Time</label>
			<div class="w3-row">
				<select name="startTime" class="w3-input">
					<option value="-1">Select Time</option>
					<%
						ArrayList listofscheduleTime = new ScheduleTimeDAO()
								.getScheduleTimeList();
						for (int i = 0; i < listofscheduleTime.size(); i++) {
							ScheduleTimeBean scheduleTimeBean = (ScheduleTimeBean) listofscheduleTime

							.get(i);
							String ac = request.getParameter("startTime");
							String tmp = "unselected";
							if (ac != null
									&& ac.equals(scheduleTimeBean.getScheduleTimeId() + ""))
								tmp = "selected";
					%>
					<option value="<%=scheduleTimeBean.getScheduleTimeId()%>" <%=tmp%>><%=scheduleTimeBean.getStartTime() + "-"
						+ scheduleTimeBean.getEndTime()%></option>
					<%
						}
					%>

				</select>
			</div>

			<br /> <label class="w3-row">User</label>
			<div class="w3-row">
				<select name="user" class="w3-input">
					<option value="-1">Select User[By Email]</option>
					<%
						ArrayList listofuser = new MemberDAO().getMemberList();
						for (int i = 0; i < listofuser.size(); i++) {
							MemberBean memberBean = (MemberBean) listofuser.get(i);
							String ac = request.getParameter("user");
							String tmp = "unselected";
							if (ac != null
									&& Integer.parseInt(ac) == memberBean.getMemberId())
								tmp = "selected";
					%>
					<option value="<%=memberBean.getMemberId()%>" <%=tmp%>><%=memberBean.getEmail()%></option>
					<%
						}
					%>
				</select>
			</div>
			<br />
				<div class="w3-row">
					<label>Tranier</label>
				</div>
				<div class="row">

					<select class="w3-input" name="trainer" >
						<option value="-1">Select Trainer[By Email]</option>
						<%
						
						 listofuser = new TrainerDAO().getTrainerList();
							for (int i = 0; i < listofuser.size(); i++) {
								TrainerBean trainerBean = (TrainerBean) listofuser.get(i);
								String ac = request.getParameter("trainer");
								String tmp = "unselected";
								if (ac != null
										&& Integer.parseInt(ac) == trainerBean.getTrainerId())
									tmp = "selected";
						%>
						<option value="<%=trainerBean.getTrainerId()%>" <%=tmp%>><%=trainerBean.getEmail()%></option>
						<%
							}
						%>
					</select>
				</div>
			<br /> <br />
			
			<div class="w3-row">
				<input     type="submit" class="w3-theme w3-round-xlarge w3-btn" />
				<input  type="reset" class="w3-red w3-btn w3-round-xlarge">
			</div>
</div>
	</form>
</body>
</html>