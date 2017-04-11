<%@page import="com.digimation.goldengym.util.ValidateUtils"%>
<%@page import="com.digimation.goldengym.bean. MemberScheduleBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member | Schedule</title>
<link rel="icon" href="photo's/goldenGym1.ico">
</head>
<body>
	<header><%@ include file="UserHeader.jsp"%></header>

	<div class="container">
		<h2 style="text-transform: capitalize;">${memberBean.firstName}'s
			Schedule</h2>
		<div class="panel panel-default w3-card-8">
			<div class="panel-heading w3-theme ">
				<table>
					<tr>
						<td>Activity</td>
						<td>Start Time</td>
						<td>End Time</td>
						<td>Trainer</td>
						<td>Day</td>
					</tr>

				</table>
			</div>
			<div class="panel-body">
				<table>
					<%
						ArrayList< MemberScheduleBean>  memberScheduleBeans=(ArrayList)request.getAttribute("memberScheduleBeans");
													for(int i=0;i<memberScheduleBeans.size();i++)
													{
												 MemberScheduleBean  memberScheduleBean= memberScheduleBeans.get(i);
					%>
					<tr>

						<td><%=memberScheduleBean.getActivity()%></td>
						<td><%=memberScheduleBean.getStartTime()%></td>
						<td><%=memberScheduleBean.getEndTime()%></td>
						<td><%=memberScheduleBean.getTrainerName()%></td>
						
						<td><%=ValidateUtils.getDay(memberScheduleBean.getDay())%></td>
					</tr>
					<%
													}
					%>

				</table>

			</div>
		</div>
	</div>
	<div style="margin-top: 260px;">
		<%@ include file="GFooter.jsp"%></div>
</body>
</html>