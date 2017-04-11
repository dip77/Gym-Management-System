<%@page import="com.digimation.goldengym.bean.PackageDetailBean"%>
<%@page import="com.digimation.goldengym.dao.PackageDetailDAO"%>
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

	<header><%@ include file="Header.jsp"%></header>

	<div class="w3-col m1">&nbsp;</div>
	<div class="w3-col m7">

 <div class="panel panel-default">
    <div class="panel-heading w3-theme-l2">${msgdelete} ${msginsert} ${msgupdate}</div>
  </div>
 
		<table border="2" class="table table-hover w3-card-8">
			<thead class="w3-theme text-uppercase">

				<tr>
					<td>Package Name</td>
					<td>Activity</td>
					<td>Member Type</td>
					<td>Amount</td>
					<td>Duration</td>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList<PackageDetailBean> listOfPackageDetail=(ArrayList)request.getAttribute("listofpackagedetail");
					for(int i=0;i<listOfPackageDetail.size();i++)
					{
						
						PackageDetailBean packageBean=listOfPackageDetail.get(i);
				%>
				<tr>
					<td><%=packageBean.getPackageName()%></td>
					<td><%=packageBean.getActivity()%></td>
					<td><%=packageBean.getMemberType()%></td>
					<td><%=packageBean.getAmount()%></td>
					<td><%=packageBean.getDuration()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>