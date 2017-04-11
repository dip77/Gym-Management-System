<%@page import="com.digimation.goldengym.util.ValidateUtils"%>
<%@page import="com.digimation.goldengym.bean. ProgressDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Progress Details</title>


</head>
<body>

	<header><%@ include file="UserHeader.jsp"%></header>
	<%
		ArrayList< ProgressDetailBean>  progressDetailBeans=(ArrayList)request.getAttribute("memberProgressDetailBeans");
	%>

	<script src="js/Chartjs/jquery-1.7.2.min.js" type="text/javascript"></script>
	<link href="css/ChartCss/jquery.jqChart.css" rel="stylesheet" />

	<script src="js/Chartjs/jquery.jqChart.min.js" type="text/javascript"></script>

	<script lang="javascript" type="text/javascript">
		 	 
		$(document).ready(
				function() {
					$('#jqChart').jqChart(
							{
								title : {
									text : '${memberBean.firstName} Progress Card'
								},
								animation : {
									duration : 3
								},
								shadows : {
									enabled : true
								},
								series : [
<%for(int i=0;i<2;i++)
{
 ProgressDetailBean  progressDetailBean= progressDetailBeans.get(i);%>							
										{
											type : 'column',
											
												<%if(i %2==0){%>
											title : '<%=((ProgressDetailBean)progressDetailBeans.get(0)).getStartDate()%>' ,
											fillStyle : '#009688',
											<%}
											else{%>
											title : '<%=((ProgressDetailBean)progressDetailBeans.get(0)).getEndDate()%>' ,
											fillStyle : 'black',
											<%}%>
											data : [ [ 'Height[CM]', <%=progressDetailBean.getHeight()%> ],
													[ 'Weight[KG]', <%=progressDetailBean.getWeight()%> ],
													[ 'Biceps[CM]', <%=progressDetailBean.getBiceps()%> ],
													[ 'Chest[CM]', <%=progressDetailBean.getChest()%> ],
													[ 'Forearms[CM]', <%=progressDetailBean.getForearms()%> ],
													[ 'Thigh[CM]', <%=progressDetailBean.getThigh()%> ],
											 
											]
										},
										
	<%}%>									
										 
								]
							});
				});
	</script>



	<div style="margin-top: 130px;" class="w3-container w3-animate-bottom ">
		<div class="w3-row" align="center">
		<div class="w3-col m4">
			<a href="MemberAllProgressServlet" class="w3-btn w3-theme w3-round-xxlarge" style="font-size: 24px;"><i class="fa fa-reorder "></i> &emsp; All Details</a>
		</div>
		</div>
		<br />
		<div class="w3-row">

			<div id="jqChart" class="w3-card-16"></div>

		</div>
	</div>
	<div style="margin-top: 160px;">
	<%@ include  file="GFooter.jsp" %></div>
</body>
</html>
