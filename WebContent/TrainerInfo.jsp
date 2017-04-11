<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member Info</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>

<a href="TrainerListServlet">back</a><br>
First Name :${memberBean.firstName}<br>
Last Name : ${memberBean.lastName}<br>
Email : ${memberBean.email}<br>
Gender : ${memberBean.gender}<br>
Mobile : ${memberBean.mobile}<br>
Address : ${memberBean.address}<br>
DOB : ${memberBean.dob}<br>
City : ${memberBean.city}<br>
Experiance : ${memberBean.experiance}

</body>
</html>