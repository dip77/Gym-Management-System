<%@page import="com.digimation.goldengym.bean.PackageDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.digimation.goldengym.dao.PackageDAO"%>
<%@page import="com.digimation.goldengym.bean.PackageBean"%>
<%@page import="com.digimation.goldengym.bean.MemberTypeBean"%>
<%@page import="com.digimation.goldengym.bean.MemberBean"%>
<%@page import="java.util.List"%>
<%@page import="com.digimation.goldengym.dao.MemberTypeDAO"%>
<%@page import="com.digimation.goldengym.bean.ActivityBean"%>
<%@page import="com.digimation.goldengym.dao.ActivityDAO"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin |PackageDetailUpdate</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>
	<form action="PackageDetailValidateServlet?id=${param.id}"
		method="post" class="w3-half">
		<div class="w3-container">
			<div class="w3-row">
				<label class="w3-col m3"> Package</label>
				<div class="w3-col m9">
					<select name="package" class="w3-round-large w3-input">


						<%
							PackageDetailBean packageDetailBean=(PackageDetailBean)request.getAttribute("packageDetailBean");
																																																							ArrayList<PackageBean> listofpackage= new PackageDAO().getPackageList();
																																																						for(int i=0;i<listofpackage	.size();i++)
																																																						{
																																																							PackageBean packageBean=(PackageBean)listofpackage.get(i);
																																																							String ac=packageDetailBean.getPackageId()+"";
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
			<br>
			<div class="w3-row">
				<label class="w3-col m3">Activity </label>
				<div class="w3-col m9">
					<select name="activity" class="w3-round-large w3-input">


						<%
							ArrayList<ActivityBean> listofactivity= new ActivityDAO().getActivityList();
																																																			for(int i=0;i<listofactivity.size();i++)
																																																			{
																																																				ActivityBean activityBean=(ActivityBean)listofactivity.get(i);
																																																				String ac=packageDetailBean.getActivityId()+"";
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
			<br> <br>
			<div class="w3-row">
				<label class="w3-col m3">Amount</label>
				<div class="w3-col m9">
					<input required   type="number" name="amount" class="w3-input"
						value="${packageDetailBean.amount}"> <br>
				</div>
			</div>
			<div class="w3-row">
				<label class="w3-col m3"> Member Type</label>
				<div class="w3-col m9">

					<select name="memberType" class="w3-input">
						<%
							List listofmembertype= new MemberTypeDAO().list();
											for(int i=0;i<listofmembertype.size();i++)
												{
							MemberTypeBean memberTypeBean=(MemberTypeBean)listofmembertype.get(i);
								String ac=memberTypeBean.getMemberTypeId()+"";
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
	</form>

</body>
</html>