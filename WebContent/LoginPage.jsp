<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Login Page</title>
<link rel="icon" href="photo's/goldenGym1.ico" />
</head>
<body>
	<header><%@ include file="Header.jsp"%></header>
	<!-- 
	<img class="testimg" src=" photo's/gallery/gallery_66.jpg"  alt="boat"
			style="width: 100%; min-height: 550px; max-height: 700px; opacity:0.1 ; position: absolute;" />
		 -->

	<div id="myCarousel" class="carousel slide" data-ride="carousel"
		style="width: 100%; min-height: 550px; max-height: 700px; opacity: 0.1; position: absolute;">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
			<li data-target="#myCarousel" data-slide-to="4"></li>
			<li data-target="#myCarousel" data-slide-to="5"></li>
			<li data-target="#myCarousel" data-slide-to="6"></li>
			<li data-target="#myCarousel" data-slide-to="7"></li>
			<li data-target="#myCarousel" data-slide-to="8"></li>
			<li data-target="#myCarousel" data-slide-to="9"></li>
		</ol>
		<!-- Wrapper for slides -->
		<div class=" carousel-inner" role="listbox">
			<div class="item active ">
				<img src="photo's/gallery/gallery_66.jpg"
					style="width: 100%; min-height: 550px; max-height: 700px;"
					alt="Chania" />
			</div>
			<div class="item">
				<img src="photo's/gallery/gallery_5.jpg" alt="Chania"
					style="width: 100%; min-height: 550px; max-height: 700px;" />
			</div>
			<div class="item">
				<img src="photo's/gallery/gallery_4.jpg" alt="Flower"
					style="width: 100%; min-height: 550px; max-height: 700px;" />
			</div>
			<div class="item">
				<img src="photo's/gallery/gallery_11.jpg" alt="Flower"
					style="width: 100%; min-height: 550px; max-height: 700px;" />
			</div>
			<div class="item">
				<img src="photo's/gallery/gallery_44.jpg" alt="Flower"
					style="width: 100%; min-height: 550px; max-height: 700px;" />
			</div>
			<div class="item">
				<img src="photo's/gallery/gallery_55.jpg" alt="Flower"
					style="width: 100%; min-height: 550px; max-height: 700px;" />
			</div>
			<div class="item">
				<img src="photo's/gallery/gallery_77.png" alt="Flower"
					style="width: 100%; min-height: 550px; max-height: 700px;" />
			</div>
			<div class="item">
				<img src="photo's/gallery/gallery_88.jpg" alt="Flower"
					style="width: 100%; min-height: 550px; max-height: 700px;" />
			</div>
			<div class="item">
				<img src="photo's/gallery/gallery_120.jpg" alt="Flower"
					style="width: 100%; min-height: 550px; max-height: 700px;" />
			</div>
			<div class="item">
				<img src="photo's/gallery/gallery_1.jpg" alt="Flower"
					style="width: 100%; min-height: 550px; max-height: 700px;" />
			</div>
		</div>
		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span
			class="fa-hand-o-left fa glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="fa-hand-o-right fa glyphicon glyphicon-chevron-right"
			aria-hidden="true"></span> <span class="sr-only">Next</span>
		</a>
	</div>

	<div class="w3-container " style="margin-top: 80px;">
		<div class="w3-col m3">.</div>
		<div class="panel panel-default w3-card-16 w3-col m6 w3-animate-left">
			<div class="panel-heading w3-theme">
				<div class="w3-row" align="center">
					<label
						style="font-size: 24px; letter-spacing: 10px; font-style: italic; font-weight: 700;"
						class="w3-animate-zoom"><i class="fa-lock fa"></i> Login
						Here</label>
				</div>
			</div>
			<div class="panel-body">
				<form action="LoginServlet" method="post">
					<div align="center" style="text-transform: capitalize;">
						${msglogin}
							<div class=" w3-row">
							<label class="w3-col m2" style="font-size: 18px;"> Email
							</label>
							<div class="w3-col m9">
								<input type="email" maxlength="30" name="email" id="email"
									value="${param.email}" placeholder="example@goldenGym.com"
									class="w3-input " required style="opacity: 0.6;" />
								<div style="color: red; text-transform: uppercase;">${msgemail}</div>
							</div>
						</div>

						<br />
						<div class="w3-animate-right w3-row">
							<label class="w3-col m2" style="font-size: 18px;">
								Password </label>
							<div class="w3-col m9">
								<input type="password" name="password" maxlength="30" placeholder="Password"
									value="${param.password}" id="password" class="w3-input"
									required style="opacity: 0.6;" />
								<div style="color: red; text-transform: uppercase;">${msgpassword}</div>
							</div>
						</div>
						<br />
						<div class="w3-animate-bottom w3-row">
							<label class="w3-col m4"> <input type="submit"
								class="w3-btn w3-theme" /></label>
							<div class="w3-col m4">
								<input type="reset" class=" w3-btn w3-red" />
							</div>
						</div>
						<div class="w3-row w3-animate-right" align="right">
							<a href="ForgotPassword.jsp">Forget Password ?</a>
						</div>
					</div>

				</form>

			</div>
		</div>
		<div class="w3-col m3">.</div>
	</div>

	<div class="w3-quarter">&nbsp;</div>

	<footer style="margin-top: 340px;"><%@ include
		file="GFooter.jsp"%></footer>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#logIn").addClass("w3-theme-l2 w3-card-24 ");
			$("#logIn").removeClass("w3-theme");
		});
	</script>

</body>
</html>
