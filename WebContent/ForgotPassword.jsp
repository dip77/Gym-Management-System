<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<link rel="icon" href="photo's/goldenGym1.ico">
</head>
<body>
	<%@ include file="Header.jsp"%>

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

	<form action="ForgotPasswordServlet" method="post"
		style="margin-top: 130px;" class="w3-animate-left">
		<div class="container">
			<div class="w3-quarter">&emsp;</div>
			<div class="panel panel-default w3-half w3-card-8">
				<div class="panel-heading w3-theme" style="font-size: 24px;"
					align="center">
					<i class="fa-edit fa"></i> Forgot Password
				</div>
				<div class="panel-body">
					<div class="w3-row w3-animate-zoom">${msglogin }</div>
					<div class="w3-row w3-animate-zoom">${username }</div>
					<div class="w3-row">
						<div class="w3-col m3" style="font-size: 23px; font-weight: 800;">Email</div>
						<div class="w3-col m9">
							<input required type="email" value="${param.email}" name="email"
								class="w3-input" placeholder="Email">
						</div>

					</div>
					<br />
					<div class="w3-row" align="right">
						<div class="w3-col m3">
							<input type="submit" class="w3-btn w3-theme" />
						</div>
						<div class="w3-col m3">
							<input type="reset" class="w3-btn w3-red" />
						</div>
					</div>
					<div class="w3-row" align="right">
						<a href="LoginPage.jsp">Login Quickly ? </a>
					</div>
				</div>
			</div>
			<div class="w3-quarter">&emsp;</div>
		</div>
	</form>
	<div style="margin-top: 380px;">
		<%@ include file="GFooter.jsp"%>
	</div>
</body>
</html>