<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Admin | Activity</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>

	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>
	<form action="ActivityValidateServlet?id=${param.id}" method="post"
		class="w3-half">

		<div class="w3-row w3-theme w3-animate-zoom" align="center">
			<h2>
				<i class="fa fa-cubes"></i> &emsp; Activity Update
			</h2>
		</div>
		<br /> ${msgupdate}

		<div class="w3-animate-left w3-container ">
			<div class=" w3-row">

				<div class="w3-col m2">
					<label>Activity</label>
				</div>

				<div class="w3-col m9">
					<input required   type="text" name="activity" maxlength="20"
						class="w3-input" placeholder="Activity"
						value="${activityBean.activity}" />
				</div>
<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>

			</div>
			<br />
			<div class="w3-row w3-animate-bottom" align="center">
				<div class="w3-col m2">
					<input required   type="submit"
						class=" w3-round-xxlarge w3-btn w3-theme" />
				</div>

				<div class="w3-col m4">
					<input required   type="reset" class="w3-round-xxlarge w3-btn w3-red" />
				</div>
			</div>
		</div>
	</form>
	<div class="w3-quarter">&nbsp;</div>
</body>
</html>
