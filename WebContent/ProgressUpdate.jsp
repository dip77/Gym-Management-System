<%@page import="com.digimation.goldengym.bean.ProgressBean"%>
<%@page import="com.digimation.goldengym.dao.MemberDAO"%>
<%@page import="com.digimation.goldengym.bean.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProgressUpdate</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>

	<form action="ProgressValidateServlet?id=${param.id}" method="post">
		<div class="w3-container w3-half">
			<div class="w3-row">
				<label class="w3-col m3">User</label>
				<div class="w3-col m9">

					<select name="user" class="w3-input">
						<%
							ProgressBean progressBean = (ProgressBean) request
									.getAttribute("progressBean");
							ArrayList listofuser = new MemberDAO().getMemberList();
							String ac = progressBean.getMemberId() + "";
							for (int i = 0; i < listofuser.size(); i++) {

								MemberBean memberBean = (MemberBean) listofuser.get(i);

								String tmp = "unselected";
								if (ac != null
										&& Integer.parseInt(ac) == memberBean.getMemberId())
									tmp = "selected";
						%>
						<option value="<%=memberBean.getMemberId()%>" <%=tmp%>><%=memberBean.getEmail()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
			<br />
			<div class="w3-row">
				<label class="w3-col m3"> Start Date </label>
				<div class="w3-col m9">
					<input required   type="date" name="startDate" class="w3-input"
						value="${progressBean.startDate}"> <br>
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