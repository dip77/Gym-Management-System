
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.digimation.goldengym.bean.CityBean"%>
<%@page import="com.digimation.goldengym.dao.CityDAO"%>
<%@page import="com.digimation.goldengym.bean.UserTypeBean"%>
<%@page import="com.digimation.goldengym.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.goldengym.dao.UserTypeDAO"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Member Registration</title>
<link href="css/w3.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="date_picker/css/datepicker.css" rel="stylesheet"
	type="text/css" />
<link href="date_picker/css/layout.css" rel="stylesheet" type="text/css" />
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/Jquery/jquery.min.js">
	
</script>

<script>
<% ArrayList<UserTypeBean> listOfUser=new UserTypeDAO().getUserTypeList();
			for(int i=0;i<listOfUser.size();i++){
				%>
				
				

	$(document).ready(function() {
 		$("#<%=listOfUser.get(i).getUserTypeId() %>").click(function() {

			$("#experience").hide(100);
			
		});
		 
	});
			<%} %>
</script>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>

<body class="col-*-*">
	<form action="AdminUserInsertServlet" method="post" class="w3-animate-zoom">
		<div class=" w3-center w3-container">

			<div class=" w3-row">
				<h1 class=" w3-purple w3-col m4 w3-label" style="font: bold;">Registration</h1>
			</div>
			<div class=" w3-row">
				<span class="w3-col m2"> <input required   type="text"
					placeholder="First Name" name="firstName" id="firstName" maxlength="15"
					class="w3-input w3-input"  /> </span> <span class="w3-col m2">
					<input required   type="text" placeholder="Last Name" name="lastName"
					id="lastname" class="w3-input w3-input"  /> </span>

			</div>
			<div class="w3-row">
			<% ArrayList<UserTypeBean> listOfUser=new UserTypeDAO().getUserTypeList();
			for(int i=0;i<listOfUser.size();i++){
			%>
				<span class="w3-col m2"> 
				<input required   class="w3-radio w3-validate"
					type="radio" maxlength="15" name="userType" value="<%=listOfUser.get(i).getUserTypeId() %>" id="trainer"> <label><%=listOfUser.get(i).getUserType() %></label>
<%} %>
			</div>
			<div class="w3-row" id="experience">
				<span class="w3-col m4"> <input required   type="number"
					name="experiance" placeholder="Experience" maxlength="3"
					class="w3-input w3-input" id="exp" /> </span>
			</div>
			<br />
			<div class="w3-row">
				<span class="w3-col m4"> <input required   type="email"
					placeholder="example@goldengym.com" name="email" id="email" maxlength="30"
					class="w3-input w3-input"  /> ${msgemail}</span>
			</div>
			<br />
			<div class="w3-row">
				<span class="w3-col m4"> <input required   type="password"
					placeholder="Create Password" name="password" id="passWord"
					class="w3-input w3-input"  />${msgpassword} </span>
			</div>
			<br />

			<div class="w3-row">
				<span class="w3-col m4"> <input required   type="password"
					placeholder="Confirm Password" name="confirmPassword"
					id="confirm_passWord" class="w3-input w3-input"  />${msgcpwd} </span>
			</div>
			<br />

			<div class="w3-row">

				<span class="w3-col m2"> <input required   class="w3-theme w3-radio"
					type="radio" name="gender" value="male" checked> <label>Male</label>
				</span> <span class="w3-col m2"> <input required  
					class="w3-radio w3-pinkw3-pink" type="radio" name="gender"
					value="female"> <label class="w3-validate">Female</label> </span>

			</div>
			<br />
			<div class="w3-row">
				<div class='w3-col m4'>
					Date of Birth <input required   type="date" name="dateofBirth"
						id="dateofBirth" class="w3-input" />
				</div>
			</div>
			<br />
			<div class="w3-row">
				<div class="w3-col m4">
					<textarea name="address" placeholder="Address" name="address" maxlength="100"
						class="w3-input"></textarea>
				</div>
			</div>
			<br />
			
			<div class="w3-row">
				<div class="w3-col m4">
					<input required   list="city" name="city" placeholder="City"
						style="text-transform: capitalize;" maxlength="15"
						class="w3-input" autocomplete="off" />
					<datalist id="city">
					
					<%
					ArrayList <CityBean>listOfCity=(ArrayList)new CityDAO().list();
			
					for(int i=0;i<listOfCity.size();i++ )
					{
						CityBean citybean=listOfCity.get(i);
					%>
					<option value="<%=citybean.getCityName() %>" ></option>
				<% }		
					%>

					</datalist>
				</div>
			</div>

			<br />

			<div class="w3-row">
				<div class="w3-col m4">
					<input required   type="number"  placeholder="Mobile No" maxlength="10"
						name="mobile" class="w3-input"  />${msgmobile}
				</div>
			</div>
			<br />
			<div class="w3-row">
				<div class="w3-col m2">
					<input required   type="submit" class="w3-btn w3-purple" />
				</div>
				<div class="w3-col m2">
					<input required   type="reset" id="reset" class="w3-btn w3-red" />
				</div>
			</div>

		</div>
	</form>

</body>
</html>
