<%@page import="com.digimation.goldengym.bean.SubscriptionBean"%>
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
	<header><%@ include file="UserHeader.jsp"%></header>


	<div class="container">

		<h2 style="text-transform: capitalize;">${memberBean.firstName}'s Current Plan
		 <a href="MemberAllPlanServlet" class="w3-btn w3-theme" style="font-size: 24px;"><i class="fa fa-reorder"></i>&emsp; View All Plans </a></h2>
		<div class="panel panel-default w3-card-8 w3-animate-bottom">
			<div class="panel-heading w3-theme">
				<table>
					<tr>
						<td>StartDate</td>
						<td>EndDate</td>
						<td>MemberType</td>
						<td>Activity</td>
						<td>PackageName</td>
						<td>Duration</td>
						<td>Amount</td>
					</tr>
				</table>
			</div>
			<div class="panel-body">

				<table>

					<%
						ArrayList<SubscriptionBean> subscriptionBeans=(ArrayList)request.getAttribute("subscriptionBeans");
								SubscriptionBean subscriptionBean=subscriptionBeans.get(subscriptionBeans.size()-1);
					%>
					<tr>

						<td><%=subscriptionBean.getStartDate()%></td>
						<td><%=subscriptionBean.getEndDate()%></td>
						<td><%=subscriptionBean.getMemberType()%></td>
						<td><%=subscriptionBean.getActivity()%></td>
						<td><%=subscriptionBean.getPackageName()%></td>
						<td><%=subscriptionBean.getDuration()+" Month"%></td>
						<td><%=subscriptionBean.getAmount()%></td>

					</tr>

				</table>
			</div> 
		</div>
 
	</div>
<div style="margin-top: 260px">

<%@ include file="GFooter.jsp" %>
</div>
</body>
</html>