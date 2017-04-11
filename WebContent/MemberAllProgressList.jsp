<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.goldengym.bean.ProgressDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProgressDetailList</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>

	<header><%@ include file="UserHeader.jsp"%></header>
	


	<%
 	ArrayList<ProgressDetailBean> listofprogressDetailBean=
  (ArrayList)request.getAttribute("listofprogressDetailBean");
 %>
 

	<table border="2" class="table table-hover w3-card-8 ">

		<thead class="w3-theme text-uppercase">
			<tr>
				<td>Date</td>
				<td>Bodyfat</td>
				<td>Height</td>
				<td>Weight</td>
				<td>Biceps</td>
				<td>Thigh</td>
				<td>Chest</td>
				<td>Forearms</td>
				<td>Wrist</td>
			</tr>
		</thead>
		<%
			for(int i=0;i<listofprogressDetailBean.size();i++)
				{
			ProgressDetailBean progressDetailBean=listofprogressDetailBean.get(i);
		%>
		<tr>
			<td><%=progressDetailBean.getDate()%></td>
			<td><%=progressDetailBean.getBodyfat()%></td>
			<td><%=progressDetailBean.getHeight()%></td>
			<td><%=progressDetailBean.getWeight()%></td>
			<td><%=progressDetailBean.getBiceps()%></td>
			<td><%=progressDetailBean.getThigh()%></td>
			<td><%=progressDetailBean.getChest()%></td>
			<td><%=progressDetailBean.getForearms()%></td>
			<td><%=progressDetailBean.getWrist()%></td>
		
		</tr>

		<%
			}
		%>
	</table>
	</div> 
</body>
</html>