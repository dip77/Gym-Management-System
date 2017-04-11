
<%@ include file="MainHeader.jsp"%>
<body>

	<nav class=" navbar navbar-default w3-theme w3-card-8 w3-animate-top">
		<div class="container-fluid ">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav" id="menu">
					<li><a href="index.jsp" id="home"><i class="fa-home fa"
							style="font-size: 24px"> Home</i></a></li>
					<li class="dropdown" id="activity"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"><i class="fa fa-sitemap"
							style="font-size: 24px"> Activity</i><span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="ActivityYoga.jsp">Yoga</a></li>
							<li><a href="ActivityPranayam.jsp">Pranayam</a></li>
							<li><a href="ActivityStretching.jsp">Stretching</a></li>
							<li><a href="#">CARDAIO</a></li>
						</ul></li>
					<li class="dropdown" id="activity"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"><i class="fa-bolt fa"
							style="font-size: 24px"> Gym</i><span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li class="w3-theme"></li>
							<li><a href="Equipments.jsp">Equipment</a></li>
							<li><a href="UserPackageListServlet">Package</a></li>
							<li><a href="GuestScheduleListServlet">Schedule</a></li>
							<li><a href="GuestTrainerIntro.jsp">Trainer</a></li>

						</ul></li>

					<li id="About"><a href="AboutUS.jsp"><i class="fa-user fa"
							style="font-size: 24px;"> About Us</i></a></li>
					<li id="Contact"><a href="Contact-us.jsp"><i
							class="fa-phone fa" style="font-size: 24px;"> Contact Us</i></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li id="logIn"><a href="LoginPage.jsp"><span
							class="fa fa-lock"></span> Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<script>
		$(document)
				.ready(
						function() {
							$(
									"#home,#logIn ,  #activity ,#Equipment , #gym , #About ,#Contact , #member")
									.mouseleave(function() {
										$(this).addClass("w3-theme ");
										$(this).css({
											"transition" : "1s"
										});
										$(this).removeClass("w3-card-16 ");
									});

							$(
									"#home,#logIn  , #activity ,#Equipment , #gym, #About ,#Contact , #member")
									.mouseenter(
											function() {
												$(this).addClass(
														"w3-white w3-card-16");
												$(this).removeClass("w3-theme");
											});
						});
	</script>