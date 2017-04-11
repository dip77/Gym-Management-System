<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProgressDetailUpdate</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>

<%@ include file="AdminHeader.jsp" %>
<%@ include file="AdminSideBar.jsp" %>

<form action="ProgressDetailValidateServlet?id=${param.id}" method="post">
<div class="w3-half w3-container w3-animate-right">
<div class="w3-row">
<label class="w3-col m3">
weight
</label>
	<div class="w3-col m6">
<input required   class="w3-input" type="number" name="weight" value="${progressBean.weight}"><br>
	</div>
</div>
<br />

<div class="w3-row">
<label class="w3-col m3">
height
</label>
	<div class="w3-col m6">
<input required   class="w3-input" type="number" name="height" value="${progressBean.height}"><br>

	</div>
</div>
<br />
<div class="w3-row">
<label class="w3-col m3">
chest
</label>
	<div class="w3-col m6">
<input required   class="w3-input" type="number" name="chest" value="${progressBean.chest}"><br>

	</div>
</div>
<br />


<div class="w3-row">
<label class="w3-col m3">
thigh
</label>
	<div class="w3-col m6">
<input required   class="w3-input" type="number" name="thigh" value="${progressBean.thigh}"><br>
	</div>
</div>
<br />

<div class="w3-row">
<label class="w3-col m3">
wrist
</label>
	<div class="w3-col m6">
<input required   class="w3-input" type="number" name="wrist" value="${progressBean.wrist}"><br>

	</div>
</div>
<br />

<div class="w3-row">
<label class="w3-col m3">
biceps

</label>
	<div class="w3-col m6">

<input required   class="w3-input" type="number" name="biceps" value="${progressBean.biceps}"><br>
	</div>
</div>
<br />

<div class="w3-row">
<label class="w3-col m3">
forearms

</label>
	<div class="w3-col m6">

<input required   class="w3-input" type="number" name="forearms" value="${progressBean.forearms}"><br>
	</div>
</div>
<br />

<div class="w3-row">
<label class="w3-col m3">
bodyfat

</label>
	<div class="w3-col m6">
<input required   class="w3-input" type="number" name="bodyfat" value="${progressBean.bodyfat}"><br>

	</div>
</div>


<br />
<div class="w3-row">
<label class="w3-col m3">
<input  class="w3-btn w3-theme" type="submit">

</label>
	<div class="w3-col m6">
<input  type="reset" class="w3-red w3-btn">

	</div>
</div>


 </div>
</form>

</body>
</html>