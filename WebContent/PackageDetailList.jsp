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

	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>

	<div class="w3-col m1">&nbsp;</div>
	<div class="w3-col m7">

 
	<div class="w3-row">
			<div class="w3-col m3">
				<a href="PackageDetailInsert.jsp" class="w3-theme w3-btn">Add
		Package</a>
			</div>
		</div>

<br/>
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
					<td>Action</td>
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
					<td><a
						href="PackageDetailUpdateServlet?id=<%=packageBean.getPackageDetailId()%>"><img src="photo's/edit.ico" height="30" width="30" />
</a>
						<a
						href="PackageDetailDeleteServlet?id=<%=packageBean.getPackageDetailId()%>"><img src="photo's/Recycle Bin.ico" height="30" width="30" />
</a>
						<a
						href="SubscriptionInsert.jsp?id=<%=packageBean.getPackageDetailId()%>"><i class="fa-youtube-play fa"></i> subscribe</a>

					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
		<script type="text/javascript">
		$(document).ready(function() {
			$("#package").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>
	
</body>
</html>