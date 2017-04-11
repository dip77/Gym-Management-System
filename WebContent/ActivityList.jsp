<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.goldengym.bean.ActivityBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ActivityList</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>
 

	<div class="w3-col m1">&nbsp;</div>
	<div class="w3-col m6">

		<div class="w3-row">
			<div class="w3-col m3">
				<a href="ActivityInsert.jsp" class="w3-theme w3-btn">Add
					Activity</a>
			</div>
		</div>
<div class="panel panel-default">
    <div class="panel-heading w3-theme-l2">${msgdelete} ${msginsert} ${msgupdate}</div>
  </div>
  
		<div class="w3-col m1">&nbsp;</div>
		<table class="table table-hover w3-card-8">
			<thead class="w3-theme text-uppercase">
				<tr>
					<td>Activity</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<%
		ArrayList <ActivityBean> listOfActivity=(ArrayList)request.getAttribute("listofactivity");
																				for(int i=0;i<listOfActivity.size();i++)
																				{

																					ActivityBean activityBean=listOfActivity.get(i);
				%>
				<tr>
					<td><%=activityBean.getActivity()%></td>
					<td><a
						href="ActivityUpdateServlet?id=<%=activityBean.getActivityId()%>"><img
							src="photo's/edit.ico" height="30" width="30" /></a> <a
						href="ActivityDeleteServlet?id=<%=activityBean.getActivityId()%>"><img
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
			$("#activity").addClass("w3-theme");
			$("#activity").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>

</body>
</html>