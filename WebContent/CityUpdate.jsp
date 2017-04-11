<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | City Update</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<header><%@ include file="AdminHeader.jsp"%></header>

	<%@ include file="AdminSideBar.jsp"%>

	${mscityname}
	<form action="CityValidateServlet?id=${param.id}" method="post"
		class="w3-half">

		<div class="w3-animate-left w3-container">
			<div class="w3-row w3-theme w3-animate-zoom" align="center">
				<h2>
					<i class="fa fa-building-o"></i> &emsp; City Update
				</h2>
			</div>
			<br />
			<div class="w3-row">
				<div class="w3-col m2">
					<label> City</label>
				</div>
				<div class="w3-col m9">
					<input required   type="text" name="txtCityName" value="${cityBean.cityName}"
						placeholder="City Name" id="txtCityName" class="w3-input">
				</div>
			</div>
			<br />
			<div class="w3-animate-bottom w3-row" align="right">
				<div class=" w3-col m3">
					<input required   type="submit" class="w3-round-xxlarge w3-btn w3-purple" />
				</div>
				<div class="w3-col m3">
					<input required   type="reset" class="w3-btn w3-red w3-round-xxlarge" />
				</div>

			</div>
		</div>
	</form>
	<div class="w3-quarter">&nbsp;</div>

</body>
</html>