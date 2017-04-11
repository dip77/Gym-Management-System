<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | MemberTypeInsert</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>

<body>

	<header><%@ include file="AdminHeader.jsp"%></header>
<%@ include file="AdminSideBar.jsp" %>
	<form action="MemberTypeInsert" method="post" class="w3-half">
		<div class="w3-container">
			<div class="w3-row" align="center">
			<h1 class="w3-theme">
			<i class="fa-user-plus fa"></i>Member Type
			</h1>
			</div>
			
			
			<div class="w3-row">
				<div class="w3-col m9 ">${msgmsginsert}</div>
			</div>
			<div class="w3-row">
				<label class="w3-col m3">Member Type</label>
				<div class="w3-col m9">
					<input required   type="text" maxlength="15" class="w3-input"
						name="memberType" placeholder="Member Type" value="${param.memberType}" />
				</div>
			</div> 
			<br />
			<div class="w3-row">
				<label class="w3-col m3"> &nbsp;</label>
				<div class="w3-col m3">
					<input required   type="submit" class="w3-theme w3-round-xlarge w3-btn" />
				</div>
				<div class="w3-col m3">
					<input required   type="reset" class="w3-round-xlarge w3-red w3-btn" />
				</div>

			</div>
			
		</div>
	</form>
	<div class="w3-quarter">&nbsp;</div>
		<script type="text/javascript">
		$(document).ready(function() {
			$("#memberType").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>
	
</body>
</html>