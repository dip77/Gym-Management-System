<%@page import="com.digimation.goldengym.bean.SubscriptionBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" href="photo's/goldenGym1.ico">
</head>
<body>
	<header><%@ include file="UserHeader.jsp"%></header>


	<div class="container ">


		<h2 style="text-transform: capitalize;">${memberBean.firstName}'s
			ALl Plan</h2>
		<div class="w3-card-16">
			<table>
				<tr style="font-size: 20px;" class="w3-theme">
					<td>StartDate</td>
					<td>EndDate</td>
					<td>MemberType</td>
					<td>Activity</td>
					<td>PackageName</td>
					<td>Duration</td>
					<td>Amount</td>
				</tr>


				<%
					ArrayList<SubscriptionBean> subscriptionBeans = (ArrayList) request
							.getAttribute("subscriptionBeans");
					for (int i = 0; i < subscriptionBeans.size(); i++) {
						SubscriptionBean subscriptionBean = subscriptionBeans.get(i);
				%>


				<tr>

					<td><%=subscriptionBean.getStartDate()%></td>
					<td><%=subscriptionBean.getEndDate()%></td>
					<td><%=subscriptionBean.getMemberType()%></td>
					<td><%=subscriptionBean.getActivity()%></td>
					<td><%=subscriptionBean.getPackageName()%></td>
					<td><%=subscriptionBean.getDuration() + " Month"%></td>
					<td><%=subscriptionBean.getAmount()%></td>

				</tr>
				<%
					}
				%>

			</table>
		</div>
	</div>
	<div style="margin-top: 260px">

		<%@ include file="GFooter.jsp"%>
	</div>
</body>
</html>