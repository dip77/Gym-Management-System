<%@page import="com.digimation.goldengym.bean.PackageBean"%>
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

	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>
	<div class="w3-col m1">&nbsp;</div>
	<div class="w3-col m7">


<div class="panel panel-default">
    <div class="panel-heading w3-theme-l2">${msgdelete} ${msginsert} ${msgupdate}</div>
  </div>

 
		<table border="2" class="table table-hover w3-card-8"> 
			<thead class="w3-theme text-uppercase">
			
			<tr>
				<td>Package Name</td>
				<td>Duration</td>
				<td>Action</td>
			</tr>
</thead>
<tbody> 
			<%
				ArrayList<PackageBean> listOfPackage=(ArrayList)request.getAttribute("listofpackage");
			for(int i=0;i<listOfPackage.size();i++)
			{

				PackageBean packageBean=listOfPackage.get(i);
			%>
			<tr>
				<td><%=packageBean.getPackageName()%></td>
				<td><%=packageBean.getDuration()%></td>
				<td><a
					href="PackageUpdateServlet?id=<%=packageBean.getPackageId()%>">edit</a>
					<a href="PackageDeleteServlet?id=<%=packageBean.getPackageId()%>">delete</a>

				</td>
			</tr>
			<%
				}
			%>
</tbody>
		</table>
	</div>

</body>
</html>