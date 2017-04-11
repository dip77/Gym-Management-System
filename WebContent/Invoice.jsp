<%@page import="com.digimation.goldengym.bean.MemberBean"%>
<%@page import="com.digimation.goldengym.bean.PackageDetailBean"%>
<%@page import="com.digimation.goldengym.bean.SubscriptionBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice</title>
<style type="text/css">
td {
	text-transform: capitalize;
}
</style>
</head>

<body>
	<%
	MemberBean memberBean= (MemberBean) request
	.getAttribute("memberBean");

	SubscriptionBean subscriptionBean = (SubscriptionBean) request
				.getAttribute("subscriptionBean");
		PackageDetailBean packageDetailBean = (PackageDetailBean) request
				.getAttribute("packageDetailBean");
	%>
	<%@include file="AdminHeader.jsp"%>
	<%@ include file="AdminSideBar.jsp"%>
	<a style="font-size: 23px; cursor: help;" align="center"
		onclick="printDiv('table1')" class="w3-btn w3-theme"> Print_card</a>
	<div id="table1">
		<table align="center"
			style="border-spacing: 20px; width: 1000px; padding: 10px; table-layout: auto; border-style: solid; border-width: medium;">
			<tr style="background-color: #05998B">
				<th colspan="4" style="font-size: 25px;">Golden Gym</th>
			</tr>

			<tr>
				<td style="font-weight: bold;">Name</td>
				<td><%=memberBean.getFirstName()%>&nbsp;</td>
				<td><%=memberBean.getLastName()%>&nbsp;</td>
			</tr>

			<tr>
				<td style="font-weight: bold;">Email</td>
				<td><%=memberBean.getEmail()%>&nbsp;</td>
			</tr>

			<tr>
				<td style="font-weight: bold;">Start Date</td>
				<td id="date">
 
					 <script type="text/javascript">
							document.getElementById('date').innerHTML = 
									+ new Date().getDate()
									+ "/"
									+ (new Date().getMonth() + 1)
									+ "/"
									+ new Date().getFullYear();
						</script> &nbsp;</td>
			</tr>

			<tr>
				<td style="font-weight: bold;">Package Name</td>
				<td><%=packageDetailBean.getPackageName()%>&nbsp;</td>
			</tr>

			<tr>
				<td style="font-weight: bold;">Duration</td>
				<td><%=packageDetailBean.getDuration()%>&nbsp; Month's</td>
			</tr>

			<tr>
				<td style="font-weight: bold;">Activity</td>
				<td><%=packageDetailBean.getActivity()%></td>
			</tr>

			<tr>
				<td style="font-weight: bold;">Member Type</td>
				<td><%=packageDetailBean.getMemberType()%></td>
			</tr>


			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td><b>Amount</b>
				</td>
				<td style="text-align: right; font-weight: 800;"><%=packageDetailBean.getAmount()%>/-
					only</td>
			</tr>

		</table>
	</div>
	<script type="text/javascript">

	function printDiv(divName) {
			var printContents = document.getElementById(divName).innerHTML;
			var originalContents = document.body.innerHTML;

			document.body.innerHTML = printContents;

			window.print();

			document.body.innerHTML = originalContents;
		}
	</script>

</body>
</html>