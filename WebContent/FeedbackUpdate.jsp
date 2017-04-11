<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
<form action="FeedbackValidateServlet?id=${param.id}" method="post">
<textarea  name="feedback">${feedbackbean.feedback}</textarea>
<input required   type="submit">
<input required   type="reset">
</form>
 
</body>
</html>