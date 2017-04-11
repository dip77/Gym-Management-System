<%@page import="com.digimation.goldengym.bean.CityBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>

	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>

	<div class="w3-container">
	<div class="w3-col m1">&nbsp; </div>
		<div class="w3-col m7">
	 			<div class="w3-row">
			<div class="w3-col m3">
				<a href="CityInsert.jsp" class="w3-theme w3-btn">Add
				City</a>
			</div>
		</div>

<br/>
			<div class="panel panel-default">
    <div class="panel-heading w3-theme-l2">${msgdelete} ${msginsert} ${msgupdate}</div>
  </div>
			
			<table border="2" class="table table-hover w3-card-8">
				<thead class="w3-theme text-uppercase">
					<tr>
						<td>City</td>
						<td>Action</td>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<CityBean> listOfCity=(ArrayList)request.getAttribute("listofcity");
									for(int i=0;i<listOfCity.size();i++)
									{
										
										CityBean cityBean=listOfCity.get(i);
					%>
					<tr>
						<td><%=cityBean.getCityName()%></td>
						<td><a href="CityUpdateServlet?id=<%=cityBean.getCityId()%>"><img
								src="photo's/edit.ico" height="30" width="30" /> </a> <a
							href="CityDeleteServlet?id=<%=cityBean.getCityId()%>"><img
								src="photo's/Recycle Bin.ico" height="30" width="30" /></a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
			<script type="text/javascript">
		$(document).ready(function() {
			$("#city").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>
</body>
</html>