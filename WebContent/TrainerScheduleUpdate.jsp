<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.digimation.goldengym.bean.TrainerScheduleBean"%>
<%@page import="com.digimation.goldengym.bean.TrainerBean"%>
<%@page import="com.digimation.goldengym.dao.TrainerDAO"%>
<%@page import="com.digimation.goldengym.dao.ScheduleTimeDAO"%>
<%@page import="com.digimation.goldengym.bean.ScheduleTimeBean"%>
<%@page import="com.digimation.goldengym.bean.ActivityBean"%>
<%@page import="com.digimation.goldengym.dao.ActivityDAO"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TrainerScheduleUpdate</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>

	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>

	<form action="TrainerScheduleValidateServlet?id=${param.id}"
		method="post">
		<div class="w3-container w3-half">
			<div class="w3-row">
				<label class="w3-col m3"> Activity </label>

				<div class="w3-col m8">
					<select name="activity" class="w3-input">

						<%
							TrainerScheduleBean trainerScheduleBean = (TrainerScheduleBean) request
									.getAttribute("trainerscheduleBean");
							ArrayList listofactivity = new ActivityDAO().getActivityList();
							String ac = trainerScheduleBean.getActivity();
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
			</div>

			<br>
			<div class="w3-row">
				<label class="w3-col m3"> Time </label>
				<div class="w3-col m8">
					<select class="w3-input" name="startTime">

						<%
							ArrayList listofscheduleTime = new ScheduleTimeDAO()
									.getScheduleTimeList();
							ac = trainerScheduleBean.getScheduleTimeId() + "";
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
			</div>
			<br />

			<div class="w3-row">
				<label class="w3-col m3"> User </label>
				<div class="w3-col m8">
					<select class="w3-input" name="user">

						<%
							ArrayList listofuser = new TrainerDAO().getTrainerList();
							ac = trainerScheduleBean.getTrainerId() + "";
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
				<br />
				<br />
				<div class="w3-row">
					<label class="w3-col m2"> &nbsp;</label>
					<div class="w3-col m3">
						<input required   type="submit" class="w3-theme w3-round-xlarge w3-btn" />
					</div>
					<div class="w3-col m3">
						<input required   type="reset" class="w3-round-xlarge w3-red w3-btn" />
					</div>

				</div>

			</div>

		</div>
	</form>


</body>
</html>