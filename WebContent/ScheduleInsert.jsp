<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.digimation.goldengym.dao.ScheduleTimeDAO"%>
<%@page import="com.digimation.goldengym.bean.ScheduleTimeBean"%>
<%@page import="com.digimation.goldengym.bean.ActivityBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.goldengym.dao.ActivityDAO"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Admin | Schedule</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>

	<form action="ScheduleInsertServlet" method="post">
		<div class=" w3-container w3-half">
			<div class="w3-row">

				<div class="w3-col m2">
					<label>Start Time</label>
				</div>
				<div class="w3-col m4">
					<select name="startTime" class="w3-round-large w3-input">
						<%
							ArrayList listofscheduleTime = new ScheduleTimeDAO()
									.getScheduleTimeList();
							for (int i = 0; i < listofscheduleTime.size(); i++) {
								ScheduleTimeBean scheduleTimeBean = (ScheduleTimeBean) listofscheduleTime
										.get(i);
								String ac = request.getParameter("startTime");
								String tmp = "unselected";
								if (ac != null && ac.equals(scheduleTimeBean.getStartTime()))
									tmp = "selected";
						%>
						<option value="<%=scheduleTimeBean.getStartTime()%>" <%=tmp%>><%=scheduleTimeBean.getStartTime()%></option>
						<%
							}
						%>
					</select>

				</div>

			</div>
			<br />
			<div class="w3-row">

				<div class="w3-col m2">
					<label>End Time</label>
				</div>
				<div class="w3-col m4">
					<select name="endTime" class="w3-round-large w3-input">
						<%
							listofscheduleTime = new ScheduleTimeDAO().getScheduleTimeList();
							for (int i = 0; i < listofscheduleTime.size(); i++) {
								ScheduleTimeBean scheduleTimeBean = (ScheduleTimeBean) listofscheduleTime
										.get(i);
								String ac = request.getParameter("endTime");
								String tmp = "unselected";
								if (ac != null && ac.equals(scheduleTimeBean.getEndTime()))
									tmp = "selected";
						%>
						<option value="<%=scheduleTimeBean.getEndTime()%>" <%=tmp%>><%=scheduleTimeBean.getEndTime()%></option>
						<%
							}
						%>
					</select>

				</div>

			</div>
			<br />

			<div class="w3-row">
				<div class="w3-col m2">
					<label>Activity</label>
				</div>
				<div class="w3-col m4">
					<select name="activity" class="w3-round-large w3-input">
						<option value="-1">Select Activity</option>
						<%
							ArrayList listofactivity = new ActivityDAO().getActivityList();
							for (int i = 0; i < listofactivity.size(); i++) {
								ActivityBean activityBean = (ActivityBean) listofactivity
										.get(i);
								String ac = request.getParameter("activity");
								String tmp = "unselected";
								if (ac != null && ac.equals(activityBean.getActivity()))
									tmp = "selected";
						%>
						<option value="<%=activityBean.getActivityId()%>" <%=tmp%>><%=activityBean.getActivity()%></option>

					</select>
					<%
						}
					%>
				</div>
			</div>
			<br />
			<div class="w3-row">
				<div class="w3-col m2">
					<label class="w3-validate"> Day </label>
				</div>

				<div class="w3-col m4">
					<%
						String s[] = { "unselected", "unselected", "unselected",
								"unselected", "unselected", "unselected", "unselected",
								"unselected" };
						String ac = request.getParameter("day");
						if (ac != null)
							s[Integer.parseInt(ac)] = "selected";
					%>
					<select name="day" class="w3-round-large w3-input">
						<option value="0" <%=s[0]%>>Sunday</option>
						<option value="1" <%=s[1]%>>Monday</option>
						<option value="2" <%=s[2]%>>Tuesday</option>
						<option value="3" <%=s[3]%>>Wednesday</option>
						<option value="4" <%=s[4]%>>Thursday</option>
						<option value="5" <%=s[5]%>>Friday</option>
						<option value="6" <%=s[6]%>>Saturday</option>
					</select>

				</div>
			</div>
			<br />
			<div class="w3-row" align="center">
				<div class="w3-col m2">
					<input required   type="submit" class="w3-round-xxlarge w3-btn w3-theme" />
				</div>

				<div class="w3-col m4">
					<input required   type="reset" class="w3-round-xxlarge w3-btn w3-red" />
				</div>
			</div>
		</div>

	</form>
			<script type="text/javascript">
		$(document).ready(function() {
			$("#treeSchedule").slideDown();
			$("#listSchedule").addClass("w3-theme");
			$("#schedulesdr").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>
	
</body>
</html>
