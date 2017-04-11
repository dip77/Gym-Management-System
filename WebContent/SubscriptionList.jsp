<%@page import="com.digimation.goldengym.bean.SubscriptionBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | SubscriptionList</title>
<link rel="icon" href="photo's/goldenGym1.ico">
</head>
<body>

	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>

	<div class="w3-col s1">&nbsp;</div>
	<div class="w3-col m8">

		 
		<br />
		<div class="panel panel-default">
			<div class="panel-heading w3-theme-l2">${msgdelete}
					${msginsert} ${msgupdate}</div>
		</div>



		<table border="2" class="table table-hover w3-card-8">
			<thead class="w3-theme text-uppercase">

				<tr>
					<td>First name</td>
					<td>Last name</td>
					<td>Email</td>
					<td>Package</td>
					<td>Activity</td>
					<td>Amount</td>
					<td>Start Date</td>
					<td>End Date</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody style="font-size: 12px;">
				<tr>
					<%
						ArrayList<SubscriptionBean> listOfSubscriptionBeans=(ArrayList)request.getAttribute("listofsubscription");
														for(int i=0;i<listOfSubscriptionBeans.size();i++)
														{

															SubscriptionBean subscriptionBean=listOfSubscriptionBeans.get(i);
					%>
				
				<tr>
					<td><%=subscriptionBean.getFirstName()%></td>
					<td><%=subscriptionBean.getLastName()%></td>
					<td><%=subscriptionBean.getEmail()%></td>
					<td><%=subscriptionBean.getPackageName()%></td>
					<td><%=subscriptionBean.getActivity()%></td>
					<td><%=subscriptionBean.getAmount()%></td>
					<td><%=subscriptionBean.getStartDate()%></td>
					<td><%=subscriptionBean.getEndDate()%></td>
					<td><a
						href="SubscriptionDeleteServlet?id=<%=subscriptionBean.getSubscriptionId()%>"><img
							src="photo's/Recycle Bin.ico" height="30" width="30" /> </a></td>

				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#subscription").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>

</body>
</html>