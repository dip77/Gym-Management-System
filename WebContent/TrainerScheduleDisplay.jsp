<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.goldengym.dao.TrainerScheduleDAO"%>
<%@page import="com.digimation.goldengym.bean.TrainerScheduleBean"%>
<%@page import="com.digimation.goldengym.dao.TrainerDAO"%>
<%@page import="com.digimation.goldengym.bean.TrainerBean"%>
<%@page import="com.digimation.goldengym.util.ValidateUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${trainerBean.firstName}'s | Schedule</title>

<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<%@ include file="TrainerHeader.jsp"%>
	<div class="container">
		<h2 style="text-transform: capitalize;">${trainerBean.firstName}'s Schedule</h2>
		<div class="panel panel-default">
			<div class="panel-heading w3-theme">
				<table>
					<tr>
						<td>Activity</td>
						<td>Start Time</td>
						<td>End Time</td>
						<td>Day</td>
					</tr>	
				</table>
			</div>
			<div class="panel-body">
				<table>
					<%
						ArrayList< TrainerScheduleBean>  trainerScheduleBeans=(ArrayList)request.getAttribute("trainerScheduleBeans");
					for(int i=0;i<trainerScheduleBeans.size();i++)
					{
						 TrainerScheduleBean  trainerScheduleBean= trainerScheduleBeans.get(i);
					%>
					<tr>

						<td><%=trainerScheduleBean.getActivity()%></td>
						<td><%=trainerScheduleBean.getStartTime()%></td>
						<td><%=trainerScheduleBean.getEndTime()%></td>
						<td><%=ValidateUtils.getDay(trainerScheduleBean.getDay())%></td>
						
					</tr>
					<%
						}
					
					%>


				</table>
			</div>
		</div>
	</div>
<%-- 	<table border="2">
		<tr>
			<td>Activity</td>
			<td>Start Time</td>
			<td>End Time</td>
			<td>Off Day1</td>
			<td>Off Day2</td>
		</tr>


		<%
			trainerScheduleBeans=(ArrayList)request.getAttribute("trainerScheduleBeans");
		for(int i=0;i<trainerScheduleBeans.size();i++)
		{
			 TrainerScheduleBean  trainerScheduleBean= trainerScheduleBeans.get(i);
		%>
		<tr>

			<td><%=trainerScheduleBean.getActivity()%></td>
			<td><%=trainerScheduleBean.getStartTime()%></td>
			<td><%=trainerScheduleBean.getEndTime()%></td>
			<td><%=ValidateUtils.getDay(trainerScheduleBean.getOffDay1())%></td>
			<%
				if(trainerScheduleBean.getOffDay2()==-1) {
			%>
			<td>-</td>
			<%
				}else{
			%>
			<td><%=ValidateUtils.getDay(trainerScheduleBean.getOffDay2())%></td>
		</tr>
		<%
			}
		}
		%>
	</table>
 --%>
</body>
</html>