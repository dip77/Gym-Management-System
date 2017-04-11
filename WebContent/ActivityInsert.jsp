<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Admin | Activity</title>
 <link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>

	<header><%@ include file="AdminHeader.jsp"%></header>
<%@ include file="AdminSideBar.jsp" %>
<form action="ActivityInsertServlet" method="post">
${msginsert}
<div class="w3-animate-left w3-container w3-half">
	 <div class=" w3-row" >
		
		<div class="w3-col m2">
		 <label>Activity</label>
		</div>
	
		<div class="w3-col m9">
			<input required   type="text" name="activity" value="${param.activity}"  maxlength="20" class="w3-input" placeholder="Activity"/>
		</div>
	<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
	
	 </div>
	 <br /> 
	 <div class="w3-row w3-animate-bottom" align="center" >
		<div class="w3-col m2">
		<input    type="submit" class=" w3-round-xxlarge w3-btn w3-theme" />
		</div>
	
		<div class="w3-col m4">
			<input    type="reset"   class="w3-round-xxlarge w3-btn w3-red"   />
		</div>
	 </div>
</div>
</form>
</body>
</html>
