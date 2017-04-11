<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>

	<header><%@ include file="AdminHeader.jsp"%></header>
	<%@ include file="AdminSideBar.jsp"%>

	<form action="ScheduleTimeValidateServlet?id=${param.id}" method="post">
		<div class="w3-container w3-half">
			<div class="w3-row">
				<label class="w3-col m3">Start Time</label>
				<div class="w3-col m9">
					<input required   class="w3-input" type="time" name="startTime"
						value="${scheduleTimeBean.startTime}">
				</div>
			</div>
			<br />
			<div class="w3-row">
				<label class="w3-col m3">End Time</label>
				<div class="w3-col m9">
			<input required   type="time"class="w3-input" name="endTime"
				value="${scheduleTimeBean.endTime}">	
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