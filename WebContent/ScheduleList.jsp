<%@page import="com.digimation.goldengym.util.ValidateUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.goldengym.bean.ScheduleBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ScheduleList</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>

	<div class="w3-col m1">&nbsp;</div>

	<div class="w3-col m7">

	<div class="w3-row">
			<div class="w3-col m3">
				<a href="ScheduleInsert.jsp" class="w3-theme w3-btn">Add
					Schedule</a>
			</div>
		</div>

<br/>
<div class="panel panel-default">
    <div class="panel-heading w3-theme-l2">${msgdelete} ${msginsert} ${msgupdate}</div>
  </div>

		<table border="2" class="table table-hover w3-card-8">
			<thead class="w3-theme text-uppercase">

				<tr>
					<td>Start Time</td>
					<td>End Time</td>
					<td>Activity</td>
					<td>Day</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList<ScheduleBean> listOfSchedule=(ArrayList)request.getAttribute("listofschedule");
				for(int i=0;i<listOfSchedule.size();i++)
				{

					ScheduleBean scheduleBean=listOfSchedule.get(i);
				%>
				<tr>
					<td><%=scheduleBean.getStartTime()%></td>
					<td><%=scheduleBean.getEndTime()%></td>
					<td><%=scheduleBean.getActivity()%></td>
					<td><%=ValidateUtils.getDay(scheduleBean.getDay())%></td>
						<td><a
						href="ScheduleUpdateServlet?id=<%=scheduleBean.getScheduleId()%>"><img src="photo's/edit.ico" height="30" width="30" />
</a>
						<a
						href="ScheduleDeleteServlet?id=<%=scheduleBean.getScheduleId()%>"><img src="photo's/Recycle Bin.ico" height="30" width="30" />
</a>

					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
			<script type="text/javascript">
		$(document).ready(function() {
			$("#treeSchedule").slideDown();
			$("#listSchedule").addClass("w3-theme");
			$("#schedulesdr").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>
	
</body>
</html>