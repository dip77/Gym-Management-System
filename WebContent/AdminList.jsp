<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.goldengym.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdminList</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>

	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>
	<div class="w3-container 	w3-col m9">
		 <div class="w3-row">
			<div class="w3-col m3">
				<a href="AdminInsert.jsp" class="w3-theme w3-btn">Add Admin</a>
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
					<td>City</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>

				<%
					ArrayList<AdminBean> adminBeans=(ArrayList)request.getAttribute("listofadmin");
															for(int i=0;i<adminBeans.size();i++)
															{
																AdminBean adminBean=adminBeans.get(i);
				%>

				<tr>
					<td><%=adminBean.getFirstName()%></td>
					<td><%=adminBean.getLastName()%></td>
					<td><%=adminBean.getEmail()%></td>
					<td><%=adminBean.getGender()%></td>
					<td><%=adminBean.getCity()%></td>

					<td><a
						href="AdminUpdateServlet?id=<%=adminBean.getAdminId()%>"><img
							src="photo's/edit.ico" height="30" width="30" /></a> <a
						href="AdminDeleteServlet?id=<%=adminBean.getAdminId()%>"><img
							src="photo's/Recycle Bin.ico" height="30" width="30" /></a></td>

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
			$("#admindr ").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>
</body>
</html>