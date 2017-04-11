<%@page import="com.digimation.goldengym.bean.UserInquiryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | User Inquiry</title>
<link rel="icon" href="photo's/goldenGym1.ico">
</head>
<body>


	<%@ include file="AdminHeader.jsp"%>
	<%@ include file="AdminSideBar.jsp"%>

	<div class="w3-col s1">&nbsp;</div>
	<div class="w3-col m8">
		<div class="w3-row">
			<div class="w3-col m3">
				<a href="UserInquiryInsert.jsp" class="w3-theme w3-btn">Add
					Inquiry</a>
			</div>
		</div>

		<br />

		<div class="panel panel-default">
			<div class="panel-heading w3-theme-l2">${msgdelete}
				${msginsert} ${msgupdate}</div>
		</div>

		<table border="1" class="table table-hover w3-card-8 ">
			<thead class="w3-theme">
				<tr>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Mobile</td>
					<td>Email</td>
					<td>Date</td>
					<td>Message</td>
					<td colspan="2">Action</td>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList <UserInquiryBean> list = (ArrayList) request.getAttribute("listofInquiry"); 
												for(int i=0;i<list.size();i++)
												{
												 UserInquiryBean bean =list.get(i);
				%>
				<tr>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getMobile()%></td>
					<td><%=bean.getEmail()%></td>
					<td><%=bean.getDate()%></td>
					<td><%=bean.getMessage()%></td>
					<td><a
						href="UserInquiryDeleteServlet?id=<%=bean.getUserInquiry()%>">
							Delete</a></td>
					<td><a
						href="UserInquiryEditServlet?id=<%=bean.getUserInquiry()%>">
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
			$("#userInquiry").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>

</body>
</html>