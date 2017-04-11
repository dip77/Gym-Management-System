<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Admin | Schedule Time</title>
<link rel="stylesheet" href="css/bootstrap.min.css" rel="stylesheet" type="text/css"  />
<link rel="stylesheet" href="css/w3.css" rel="stylesheet" type="text/css" />
<link href="css/w3-theme-deep-purple.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>	
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>

   <link rel="icon" href="photo's/goldenGym1.ico"  ></head>

<body>

<header><%@ include file="AdminHeader.jsp" %></header>
<%@ include file="AdminSideBar.jsp" %>
	
<form action="ScheduleTimeInsertServlet" method="post">
<div class="w3-container w3-half">
	
	<div class="w3-row">
		<div class="w3-col m2">
		<label class="w3-validate">Start Time </label>
		</div>
	
		<div class="w3-col m4">
			<input required   type="time" value="${param.startTime}" name="startTime" class="w3-round-large w3-input"   />
		</div> 
	 </div>
	 <br />
	<div class="w3-row">
		<div class="w3-col m2">
		<label class="w3-validate">End Time </label>
		</div>
	
		<div class="w3-col m4">
			<input required   type="time" name="endTime" value="${param.endTime}" class="w3-round-large w3-input"   />
		</div>
	 </div>
	 <br />
	 <div class="w3-row" align="center">
		<div class="w3-col m2">
		<input required   type="submit" class="w3-round-xxlarge w3-btn w3-theme" />
		</div>
	
		<div class="w3-col m4">
			<input required   type="reset"   class="w3-round-xxlarge w3-btn w3-red"   />
		</div>
	 </div>
</div>
</form>
		<script type="text/javascript">
		$(document).ready(function() {
			$("#treeSchedule").slideDown();
			$("#listSchedule").addClass("w3-theme");
			$("#scheduletsdr").addClass("w3-theme-d3 w3-card-8 ");

		});
	</script>
	
</body>
</html>
