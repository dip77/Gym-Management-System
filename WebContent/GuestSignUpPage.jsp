<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration | Golden Gym</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="" method="post">

		<div class="w3-animate-right w3-container">

			<div class="w3-row w3-theme-d2 w3-animate-zoom" align="center">
				<h2>
					<i class="fa-user-plus fa"></i> Member Registration
				</h2>
			</div>
			<br />

			<div class="w3-row  ">
				<div class="alert alert-danger w3-col m3 ">
					<strong style="font-size: 24px;">* </strong> Fields are  .
				</div>
			</div>
			<div class="w3-row">
				<label class="w3-col m2"> Name </label>
				<div class="w3-col m4">
					<input required   type="text" name="firstName" id="firstName"
						placeholder="First Name" class="w3-input" />

				</div>

				<div class="w3-col s1">&emsp;</div>

				<div class="w3-col m4">
					<input required   type="text" name="lastName" id="lastName"
						placeholder="Last Name" class="w3-input" />
				</div>
				<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
			</div>
			<br />
			<div class="w3-row">
				<label class="w3-col m2"> Email</label>
				<div class="w3-col m9">
					<input required   type="email" name="email" id="email"
						placeholder="example@goldenGym.com" class="w3-input" />
				</div>
				<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
			</div>
			<br />
			<div class="w3-row">
				<label class="w3-col m2"> Gender </label>
				<div class="w3-col m2">
					<input required   class="  w3-radio" type="radio" name="gender" value="male"
						checked /> <label class="w3-validate">Male</label>
				</div>
				<div class="w3-col m2">
					<input required   class="w3-radio  " type="radio" name="gender" value="female" />
					<label class="w3-validate">Female</label>
				</div>
				<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
			</div>
			<br />
			<div class="w3-row">
				<label class="w3-col m2"> Date of Birth </label>
				<div class="w3-col m9">
					<input required   type="date" class="w3-input" name="DOB" id="DOB" />
				</div>
				<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
			</div>
			<br />
			<div class="w3-row">
				<label class="w3-col m2"> Addreas </label>
				<div class="w3-col m9">
					<textarea class="w3-input" name="address" id="address"
						placeholder="Address"></textarea>
				</div>
				<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
			</div>
			<br />

			<div class="w3-row">
				<label class="w3-col m2"> Mobile </label>
				<div class="w3-col m9">
					<input required   type="number" class="w3-input"
						placeholder="Mobile Number" name="mobile" id="mobile" />
				</div>
				<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
			</div>

			<br />
			<div class="w3-row">
				<label class="w3-col m2"> Password </label>
				<div class="w3-col m9">
					<input required   type="password" placeholder="Create Password"
						class="w3-input" name="password" id="password" />
				</div>
				<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
			</div>
			<br />

			<div class="w3-row">
				<label class="w3-col m2"> Confirm-Password </label>
				<div class="w3-col m9">
					<input required   type="password" class="w3-input"
						placeholder="Confirm Password" name="confirmPassword"
						id="confirmPassword" />
				</div>
				<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
			</div>

			<br />
			<div class="w3-row">
				<label class="w3-col m2"> City </label>
				<div class="w3-col m9">
					<input required   type="text" class="w3-input" name="city"
						placeholder="City" id="city" />
				</div>
				<div class="w3-col s1" style="font-size: 20px; color: red;">*</div>
			</div>
			<br /> <br />
			<div class="w3-row">
				<label class="w3-col m2"> &nbsp;</label>
				<div class="w3-col m3">
					<input required   type="submit" class="w3-round-xlarge 	w3-theme w3-btn" />
				</div>
				<div class="w3-col m3">
					<input required   type="reset" class="w3-round-xlarge w3-red w3-btn" />
				</div>

			</div>
			<br />


		</div>
	</form>
	<%@ include file="GFooter.jsp"%>
</body>
</html>