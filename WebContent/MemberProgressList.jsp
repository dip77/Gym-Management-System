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
	<header><%@ include file="UserHeader.jsp"%></header>

	

 

		<table border="1" class="table table-hover w3-card-8">
			<thead class="w3-theme text-uppercase">

				<tr>
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
					<td><%=progressBean.getStartDate()%></td>
					<td><%=progressBean.getEndDate()%></td>
					<td>
					<a	href="MemberAllProgressDetailServlet?id=<%=progressBean.getMemberId()%>">
					<i class="fa-bar-chart fa">progress card</i></a></td>
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