<%@page import="com.digimation.goldengym.bean.ProgressBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Progress List</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>

	<div class="w3-col m1">&nbsp;</div>

	<div class="w3-col m7">
 		<div class="w3-row">
			<div class="w3-col m3">
				<a href="ProgressInsert.jsp" class="w3-theme w3-btn">Add
					Progress</a>
			</div>
		</div>

		<br />
 <div class="panel panel-default">
    <div class="panel-heading w3-theme-l2">${msgdelete} ${msginsert} ${msgupdate}</div>
  </div>
 

		<table border="1" class="table table-hover w3-card-8">
			<thead class="w3-theme text-uppercase">

				<tr>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Email</td>
					<td>Start Time</td>
					<td>End Time</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList<ProgressBean> listofprogressbeans=(ArrayList)request.getAttribute("listofprogress");
						for(int i=0;i<listofprogressbeans.size();i++)
						{
							ProgressBean progressBean=listofprogressbeans.get(i);
				%>
				<tr>
					<td><%=progressBean.getFirstName()%></td>
					<td><%=progressBean.getLastName()%></td>
					<td><%=progressBean.getEmail()%></td>
					<td><%=progressBean.getStartDate()%></td>
					<td><%=progressBean.getEndDate()%></td>
					<td><a
						href="ProgressUpdateServlet?id=<%=progressBean.getProgressId()%>"><img
							src="photo's/edit.ico" height="30" width="30" /> </a> <a
						href="ProgressDeleteServlet?id=<%=progressBean.getProgressId()%>"><img
							src="photo's/Recycle Bin.ico" height="30" width="30" /> </a> <a
						href="ProgressDetailListServlet?id=<%=progressBean.getMemberId()%>"><i
							class="fa-bar-chart fa">progress card</a></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#progress").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>

</body>
</html>