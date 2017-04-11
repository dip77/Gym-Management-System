<%@page import="com.digimation.goldengym.dao.TrainerScheduleDAO"%>
<%@page import="com.digimation.goldengym.bean.TrainerScheduleBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TrainerScheduleList</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>
	<div class="w3-col m1">&nbsp;</div>

	<div class="w3-col m7">

	<div class="w3-row">
			<div class="w3-col m3">
				<a href="TrainerScheduleInsert.jsp" class="w3-theme w3-btn">Add
			Trainer Schedule</a>
			</div>
		</div>

<br/>

<div class="panel panel-default">
    <div class="panel-heading w3-theme-l2">${msgdelete} ${msginsert} ${msgupdate}</div>
  </div>

		<table border="2" class="table table-hover w3-card-8">
			<thead class="w3-theme text-uppercase">

				<tr>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Email</td>
					<td>Activity</td>
					<td>Start Time</td>
					<td>End Time</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList<TrainerScheduleBean> listOfTrainerSchedule=(ArrayList)request.getAttribute("listoftrainerschedule");

						for(int i=0;i<listOfTrainerSchedule.size();i++)
						{
							

							TrainerScheduleBean trainerScheduleBean=listOfTrainerSchedule.get(i);
				%>
				<tr>
					<td><%=trainerScheduleBean.getFirstName()%></td>
					<td><%=trainerScheduleBean.getLastName()%></td>
					<td><%=trainerScheduleBean.getEmail()%></td>
					<td><%=trainerScheduleBean.getActivity()%></td>
					<td><%=trainerScheduleBean.getStartTime()%></td>
					<td><%=trainerScheduleBean.getEndTime()%></td>

					<td><a
						href="TrainerScheduleUpdateServlet?id=<%=trainerScheduleBean.getTrainerScheduleId()%>"><img
							src="photo's/edit.ico" height="30" width="30" /> </a> <a
						href="TrainerScheduleDeleteServlet?id=<%=trainerScheduleBean.getTrainerScheduleId()%>"><img
							src="photo's/Recycle Bin.ico" height="30" width="30" /> </a></td>
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
			$("#trainersdr").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>
	
</body>
</html>