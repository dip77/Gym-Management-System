
<%@ include file="MainHeader.jsp"%>

<nav class="navbar navbar-default w3-theme-d1 w3-card-8 w3-animate-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand  w3-theme" href="UserIndexPage.jsp" id="home"><i
				class="fa-home fa" style="font-size: 24px;"></i>Home </a>

		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav" id="menu">
				<li id="member"><a
					href="MemberPlanDisplayServlet?id=${memberBean.memberId}"><i
						class="fa-calendar-o fa" style="font-size: 24px"></i>
						&nbsp;Current Plan</a></li>
				<li id="member"><a
					href="MemberScheduleDisplayServlet?id=${memberBean.memberId}"><i
						class="fa-newspaper-o fa" style="font-size: 24px"></i>
						&nbsp;Schedule</a></li>
				<li id="member"><a
					href="MemberProgressDisplayServlet?id=${memberBean.memberId}"><i
						class="fa-bar-chart fa" style="font-size: 24px"></i>
						&nbsp;Progress Card</a></li>
				<li id="member"><a href="MemberGenerateQRcodeServlet"><i
						class="fa-newspaper-o fa" style="font-size: 24px"></i> &nbsp;Print
						Your ID Card</a></li>

				<li id="member"><a href="UserAboutUs.jsp"><i
						class="fa-group fa" style="font-size: 24px"></i> &nbsp;Feedback</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">

				<li class="dropdown" id="activity"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" style="text-transform: capitalize;"><i
						style="font-size: 24px;"><img alt="${memberBean.firstName }"
							src="upload/photo/${memberBean.photo}" class="w3-circle"
							style="height: 40px; width: 40px; position: inherit; margin-top: -12px;">
					</i> <i style="text-transform: capitalize;">${memberBean.firstName}
							${memberBean.lastName}</i><span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="w3-theme"></li>
						<li><a href="MemberEditServlet?id=${memberBean.memberId}">Edit
								Profile</a></li>
						<li><a
							href="MemberChangePassword.jsp?id=${memberBean.memberId}">Change
								Password</a></li>
						<li><a href="MemberLogoutServlet">Log out</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>

<script>
	$(document)
			.ready(
					function() {
						$(
								"#home,#logIn ,#signUp, #activity ,#Equipment , #gym , #About ,#Contact , #member")
								.mouseleave(function() {
									$(this).addClass("w3-theme-d1");
									$(this).css({
										"transition" : "1s"
									});
									$(this).removeClass("w3-card-16 ");
								});

						$(
								"#home,#logIn ,#signUp , #activity ,#Equipment , #gym, #About ,#Contact , #member")
								.mouseenter(function() {
									$(this).addClass("w3-white w3-card-16");
									$(this).removeClass("w3-theme-d1");
								});
					});
</script>
