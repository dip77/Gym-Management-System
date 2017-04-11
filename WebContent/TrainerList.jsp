<%@page import="com.digimation.goldengym.bean.TrainerBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Trainer List</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>

	<div class="w3-col m1">&nbsp;</div>

	<div class="w3-col m7">
 

		
		<div class="w3-row">
			<div class="w3-col m3">
				<a href="TrainerRegistration.jsp" class="w3-theme w3-btn">Add
					Trainer</a>
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
					<td colspan="3">Action</td>
				</tr>
			</thead>
			<tbody>

				<%
					ArrayList<TrainerBean> trainerBeans=(ArrayList)request.getAttribute("listoftrainer");
								for(int i=0;i<trainerBeans.size();i++)
								{
									TrainerBean trainerBean=trainerBeans.get(i);
				%>

				<tr>
					<td><%=trainerBean.getFirstName()%></td>
					<td><%=trainerBean.getLastName()%></td>
					<td><%=trainerBean.getEmail()%></td>
					<td><%=trainerBean.getGender()%></td>
					<td><%=trainerBean.getMobile()%></td>
					<td><%=trainerBean.getCity()%></td>

					<td><a
						href="TrainerUpdateServlet?id=<%=trainerBean.getTrainerId()%>"><img
							src="photo's/edit.ico" height="30" width="30" /> </a></td>
					<td><a
						href="TrainerDeleteServlet?id=<%=trainerBean.getTrainerId()%>"><img
							src="photo's/Recycle Bin.ico" height="30" width="30" /> </a></td>
					<td><a
						href="TrainerInfoServlet?id=<%=trainerBean.getTrainerId()%>"><i
							class="fa-edit  fa" style="font-size: 30px;"></i> </a></td>

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
			$("#trainerdr").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>
	
</body>
</html>