<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Admin | City Registration</title>

<link rel="icon" href="photo's/goldenGym1.ico"  ></head>

<body>
	<header><%@ include file="AdminHeader.jsp"%></header>

	<%@ include file="AdminSideBar.jsp"%>


	<form action="CityInsertServlet" method="post" class="w3-half">
		<div class="w3-animate-left w3-container">
			<div class="w3-row w3-theme w3-animate-zoom" align="center">
				<h2>
					<i class="fa fa-building-o"></i> &emsp; City Registration
				</h2>
			</div>
			<br />
			<div class="w3-row">
				<div class="w3-col m2">
					<label> City</label>
				</div>
				<div class="w3-col m9">
					<input required   type="text" name="txtCityName" placeholder="City Name"
						id="txtCityName" class="w3-input" />
				</div>
			</div>
			<br />
			<div class="w3-animate-bottom w3-row" align="right">
				<div class=" w3-col m3">
					<input required   type="submit" class="w3-round-xxlarge w3-btn w3-theme" />
				</div>
				<div class="w3-col m3">
					<input required   type="reset" class="w3-btn w3-red w3-round-xxlarge" />
				</div>

			</div>
		</div>
	</form>
	<div class="w3-quarter">&nbsp;</div>
		<script type="text/javascript">
		$(document).ready(function() {
			$("#city").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>
	
</body>
</html>
