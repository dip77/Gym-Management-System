<%@page import="com.digimation.goldengym.bean.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member List</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>
	<div class="w3-col s1">&nbsp;</div>
	<div class="w3-col m8">
		<div class="w3-row">
			<div class="w3-col m3">
				<a href="MemberRegistration.jsp" class="w3-theme w3-btn">Add
					Member</a>
			</div>
		</div>
		<br />
<div class="panel panel-default">
    <div class="panel-heading w3-theme-l2">${msgdelete} ${msginsert} ${msgupdate}</div>
  </div>

		<table border="2" class="table table-hover w3-card-8">
			<thead class="w3-theme text-uppercase">
				<tr>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Email</td>
					<td>Gender</td>
					<td>Mobile</td>
					<td>City</td>
					<td colspan="2">Action</td>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList<MemberBean> memberBeans=(ArrayList)request.getAttribute("listofmember");
									for(int i=0;i<memberBeans.size();i++)
									{
								MemberBean memberBean=memberBeans.get(i);
				%>

				<tr>
					<td><%=memberBean.getFirstName()%></td>
					<td><%=memberBean.getLastName()%></td>
					<td><%=memberBean.getEmail()%></td>
					<td><%=memberBean.getGender()%></td>
					<td><%=memberBean.getMobile()%></td>
					<td><%=memberBean.getCity()%></td>

					<td><a
						href="MemberUpdateServlet?id=<%=memberBean.getMemberId()%>"><img
							src="photo's/edit.ico" height="30" width="30" /> </a> <a
						href="MemberDeleteServlet?id=<%=memberBean.getMemberId()%>"><img
							src="photo's/Recycle Bin.ico" height="30" width="30" /></a></td>
					<td><a
						href="MemberInfoServlet?id=<%=memberBean.getMemberId()%>"><i
							class="fa-info fa" style="font-size: xx-large;"></i></a></td>

				</tr>
				<%
					}
				%>
			</tbody>

		</table>
	</div> 
		<script type="text/javascript">
		$(document).ready(function() {
			$("#treeUser").slideDown();
			$("#list").addClass("w3-theme");
			$("#memberdr ").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>
	</body>
</html>