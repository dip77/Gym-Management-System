<%@page import="com.digimation.goldengym.bean.FeedbackBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<%@ include file="AdminHeader.jsp"%>
	<%@ include file="AdminSideBar.jsp"%>

	<div class="w3-col s1">&nbsp;</div>
	<div class="w3-col m8">
<div class="panel panel-default">
    <div class="panel-heading w3-theme-l2">${msgdelete} ${msginsert} ${msgupdate}</div>
  </div>

	<table border="1" class="table table-hover w3-card-8 ">
		<thead class="w3-theme">
			<tr>
				<td>Feedback</td>
				<td>Date</td>
				<td colspan="2">Action</td>
			</tr>
		</thead>
		<tbody>
			<%
				ArrayList <FeedbackBean> feedbackBeans = (ArrayList) request.getAttribute("listofFeedback"); 
				for(int i=0;i<feedbackBeans.size();i++)
				{
				 FeedbackBean bean =feedbackBeans.get(i);
			%>
			<tr>
				<td><%=bean.getFeedback()%></td>
				<td><%=bean.getDate()%></td>
				<td><a
					href="FeedbackDeleteServlet?id=<%=bean.getFeedback_id()%>">
						Delete</a></td>
				<td><a href="FeedbackEditServlet?id=<%=bean.getFeedback_id()%>">
						Edit</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#feedback").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>

</body>
</html>