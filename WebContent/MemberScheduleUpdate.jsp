<%@page import="com.digimation.goldengym.dao.TrainerDAO"%>
<%@page import="com.digimation.goldengym.bean.TrainerBean"%>
<%@page import="com.digimation.goldengym.bean.MemberScheduleBean"%>
<%@page import="com.digimation.goldengym.bean.MemberBean"%>
<%@page import="com.digimation.goldengym.dao.MemberDAO"%>
<%@page import="com.digimation.goldengym.dao.ScheduleTimeDAO"%>
<%@page import="com.digimation.goldengym.bean.ScheduleTimeBean"%>
<%@page import="com.digimation.goldengym.bean.ActivityBean"%>
<%@page import="com.digimation.goldengym.dao.ActivityDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MemberScheduleUpdate</title>
<link rel="icon" href="photo's/goldenGym1.ico">
</head>
<body>
	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>

	<form action="MemberScheduleValidateServlet?id=${param.id}"
		method="post" class="w3-half">
		<div class="w3-container">
			<label class="w3-row w3-col m3"> Activity</label>
			<div class="w3-row">
				<select name="activity" class="w3-input">

					<%
						MemberScheduleBean memberScheduleBean = (MemberScheduleBean) request
								.getAttribute("memberscheduleBean");
						ArrayList listofactivity = new ActivityDAO().getActivityList();
						String ac = memberScheduleBean.getActivity();
						for (int i = 0; i < listofactivity.size(); i++) {
							ActivityBean activityBean = (ActivityBean) listofactivity
									.get(i);

							String tmp = "unselected";
							if (ac != null && ac.equals(activityBean.getActivity() + ""))
								tmp = "selected";
					%>
					<option value="<%=activityBean.getActivityId()%>" <%=tmp%>><%=activityBean.getActivity()%></option>

					<%
						}
					%>
				</select>

			</div>
			<br> <label class="w3-row"> Time </label>
			<div class="w3-row">
				<select name="startTime" class="w3-input">

					<%
						ArrayList listofscheduleTime = new ScheduleTimeDAO()
								.getScheduleTimeList();
						ac = memberScheduleBean.getScheduleTimeId() + "";
						for (int i = 0; i < listofscheduleTime.size(); i++) {
							ScheduleTimeBean scheduleTimeBean = (ScheduleTimeBean) listofscheduleTime
									.get(i);

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

			<br /> <label class="w3-row"> Member</label>
			<div class="w3-row">
				<select name="user" class="w3-input">
					<%
						ArrayList listofuser = new MemberDAO().getMemberList();
						ac = memberScheduleBean.getMemberId() + "";
						for (int i = 0; i < listofuser.size(); i++) {
							MemberBean memberBean = (MemberBean) listofuser.get(i);

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
				<label class="w3-col m3"> Trainer </label>
				<div class="w3-col m8">
					<select class="w3-input" name="trainer">

						<%
							listofuser = new TrainerDAO().getTrainerList();
							ac = memberScheduleBean.getTrainerId() + "";
							for (int i = 0; i < listofuser.size(); i++) {
								TrainerBean trainerBean = (TrainerBean) listofuser.get(i);

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
					<input type="submit" class="w3-theme w3-round-xlarge w3-btn" /> <input
						type="reset" class="w3-red w3-btn w3-round-xlarge">
				</div>


			</div>
		</div>
	</form>

</body>
</html>