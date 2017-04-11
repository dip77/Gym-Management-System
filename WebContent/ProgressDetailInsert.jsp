<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
<%@ include file="AdminHeader.jsp" %>
<%@ include file="AdminSideBar.jsp" %>
<form action="ProgressDetailInsertServlet?id=${param.id}"  method="post">
<div class="w3-half w3-container">
<div class="w3-row">
<label class="w3-col m3">
weight
</label>
	<div class="w3-col m6">
<input required   class="w3-input" placeholder="" type="number" name="weight" value="${param.weight}"><br>
	</div>
</div>
<br />
<div class="w3-row">
<label class="w3-col m3">
height

</label>
	<div class="w3-col m6">
<input required   class="w3-input" placeholder="" type="number" name="height" value="${param.height}"><br>

	</div>
</div>
<br />

<div class="w3-row">
<label class="w3-col m3">
chest
</label>
	<div class="w3-col m6">

<input required   class="w3-input" placeholder="" type="number" name="chest" value="${param.chest}"><br>
	</div>
</div>
<br />
<div class="w3-row">
<label class="w3-col m3">
thigh
</label>
	<div class="w3-col m6">
<input required   class="w3-input" placeholder="" type="number" name="thigh" value="${param.thigh}"><br>

	</div>
</div>
<br />

<div class="w3-row">
<label class="w3-col m3">
biceps

</label>
	<div class="w3-col m6">
<input required   class="w3-input" placeholder="" type="number" name="biceps" value="${param.biceps}"><br>

	</div>
</div>
<br />
<div class="w3-row">
<label class="w3-col m3">
forearms
</label>
	<div class="w3-col m6">
<input required   class="w3-input" placeholder="" type="number" name="forearms" value="${param.forearms}"><br>

	</div>
</div>
<br />
		
<div class="w3-row">
<label class="w3-col m3">
forearms
</label>
	<div class="w3-col m6">
<input required   class="w3-input" placeholder="" type="number" name="forearms" value="${param.forearms}"><br>

	</div>
</div>
<br />
		
 
 
			<div class="w3-row">
				<label class="w3-col m2"> &nbsp;</label>
				<div class="w3-col m3">
					<input required   type="submit" class="w3-theme w3-round-xlarge w3-btn" />
				</div>
				<div class="w3-col m3">
					<input required    type="reset" class="w3-round-xlarge w3-red w3-btn" />
				</div>

			</div>
 
</div>
</form>
</body>
</html>