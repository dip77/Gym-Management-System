<%@page import="com.digimation.goldengym.dao.PackageDAO"%>
<%@page import="com.digimation.goldengym.bean.PackageBean"%>
<%@page import="com.digimation.goldengym.bean.MemberTypeBean"%>
<%@page import="com.digimation.goldengym.bean.MemberBean"%>
<%@page import="java.util.List"%>
<%@page import="com.digimation.goldengym.dao.MemberTypeDAO"%>
<%@page import="com.digimation.goldengym.bean.ActivityBean"%>
<%@page import="com.digimation.goldengym.dao.ActivityDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Package Detail</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>

<body>
	<header> <%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>
	<form action="PackageDetailInsertServlet" method="post" class="w3-half">
		<div class="w3-container">
			<div class="w3-theme" align="center">
				<h1>
					<i class="fa-calendar-o fa"></i> &nbsp; Package
				</h1>
			</div>
			<div class="w3-row">
				<label class="w3-col m3">Package</label>
				<div class="w3-col m9">
					<select name="package" class="w3-round-large w3-input">

						<option value="-1">Select Package</option>
						<%
							ArrayList<PackageBean> listofpackage= new PackageDAO().getPackageList();
																																																																			for(int i=0;i<listofpackage	.size();i++)
																																																																			{
																																																																				PackageBean packageBean=(PackageBean)listofpackage.get(i);
																																																																				String ac=request.getParameter("package");
																																																																				String tmp="unselected";
																																																																				if(ac!=null && ac.equals(packageBean.getPackageId()+""))
																																																																				tmp="selected";
						%>
						<option value="<%=packageBean.getPackageId()%>" <%=tmp%>><%=packageBean.getPackageName()%></option>


						<%
							}
						%>
					</select>
				</div>
			</div>
			<br />
			<div class="w3-row">
				<label class="w3-col m3"> Activity</label>
				<div class="w3-col m9">
					<select name="activity" class="w3-round-large w3-input">

						<option value="-1">Select Activity</option>
						<%
							ArrayList<ActivityBean> listofactivity= new ActivityDAO().getActivityList();
																																																												for(int i=0;i<listofactivity.size();i++)
																																																												{
																																																													ActivityBean activityBean=(ActivityBean)listofactivity.get(i);
																																																													String ac=request.getParameter("activity");
																																																													String tmp="unselected";
																																																													if(ac!=null && ac.equals(activityBean.getActivityId()+""))
																																																														tmp="selected";
						%>
						<option value="<%=activityBean.getActivityId()%>" <%=tmp%>><%=activityBean.getActivity()%></option>

					</select>
					<%
						}
					%>
				</div>
			</div>
			<br> <br />
			<div class="w3-row">
				<label class="w3-col m3"> Amount </label>
				<div class="w3-col m9">
					<input required   type="number" name="amount" placeholder="Amount"
						class="w3-input" value="${param.amount}"> <br>
				</div>
				<div class="w3-row">

					<label class="w3-col m3"> Member Type</label>

					<div class="w3-col m9">
						<select name="memberType" class="w3-input">

							<option value="-1">Select Member Type</option>
							<%
								List listofmembertype= new MemberTypeDAO().list();
																																																											for(int i=0;i<listofmembertype.size();i++)
																																																											{
																																																												MemberTypeBean memberTypeBean=(MemberTypeBean)listofmembertype.get(i);
																																																												String ac=request.getParameter("memberType");
																																																												String tmp="unselected";
																																																												if(ac!=null && ac.equals(memberTypeBean.getMemberTypeId()+""))
																																																													tmp="selected";
							%>
							<option value="<%=memberTypeBean.getMemberTypeId()%>" <%=tmp%>><%=memberTypeBean.getMemberType()%></option>


							<%
								}
							%>
						</select>
					</div>

				</div>
				<br />
				<div class="w3-row">
					<label class="w3-col m2"> &nbsp;</label>
					<div class="w3-col m3">
						<input required   type="submit" class="w3-theme w3-round-xlarge w3-btn" />
					</div>
					<div class="w3-col m3">
						<input required   type="reset" class="w3-round-xlarge w3-red w3-btn" />
					</div>

				</div>

			</div>
		</div>
	</form>
	<div class="w3-quarter">&nbsp;</div>
		<script type="text/javascript">
		$(document).ready(function() {
			$("#package").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>
	
</body>
</html>