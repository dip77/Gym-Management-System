<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PackageUpdate</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<header><%@ include file="AdminHeader.jsp"%>
	<%@ include file="AdminSideBar.jsp"%>
	<form action="PackageValidateServlet?id=${param.id}" method="post">
		<div class="w3-container w3-half">
			<div class="w3-row">
				<label class="w3-col m3">Package Name </label>
				<div class="w3-col m9">
					<input required   type="text" name="packageName"
						value="${packageBean.packageName}" class="w3-input"
						maxlength="20"> ${msgpkg}
				</div>
			</div>
			<br>
			<div class="w3-row">
				<label class="w3-col m3"> Duration</label>
			<div class="w3-col m9">
				<input required   type="number" name="duration" value="${packageBean.duration}"
					max="12" class="w3-input">
			</div>
			</div>
			<br> <br />
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