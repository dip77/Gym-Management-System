 <style type="">
input{
outline: 0px;
}
</style>


<%@ include file="MainHeader.jsp"%>
<nav class="navbar navbar-default w3-theme " role="navigation"
	data-offset-top="208" style="color: white;">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#example-navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <i
				class="fa fa-navicon"></i>
		</button>
		<a class="navbar-brand  w3-theme" href="Admindashboard.jsp" id="home"><i
			class="fa-home fa" style="font-size: 24px;"></i>Home </a>
	</div>
	<div class="collapse navbar-collapse w3-card-8 w3-theme"
		id="example-navbar-collapse">


		<ul class="nav navbar-nav  navbar-right  ">
			<li class="w3-theme  dropdown " id="adminname"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown"> <i
					class="fa-user fa" style="text-transform: uppercase;">
						&emsp;${adminBean.firstName}&nbsp;${adminBean.lastName} </i> <b
					class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="AdminEditServlet?id=${adminBean.adminId}"><i
							class="fa-edit fa"></i>&emsp;Edit Profile</a></li>
					<li><a href="AdminChangePassword.jsp"><i class="fa fa-gear"></i>&emsp;
							Change Password</a></li>
					<li class="divider"></li>
					<li><a href="AdminLogoutServlet"><i class="fa-sign-in fa"></i>&emsp;
							Logout</a></li>
				</ul></li>
		</ul>
	</div>
</nav>
<script>
	$(document).ready(function() {
		$("#treeUser").slideUp(500);
		$("#treeSchedule").slideUp(500);

		$("#listUser").click(function() {
			$("#treeUser").slideToggle(500);

			$("#treeSchedule").slideUp(500);
		});

		$("#listSchedule").click(function() {
			$("#treeSchedule").slideToggle(500);

			$("#treeUser").slideUp(500);
		});

		$("span").mouseleave(function() {
			$(this).removeClass("w3-theme w3-card-8");

		});
		$("span").mouseenter(function() {
			$(this).addClass("w3-theme w3-card-8");

		});

		$("#home,	#adminname").mouseleave(function() {
			$(this).addClass("w3-theme");
			$(this).css({
				"transition" : "1s"
			});
			$(this).removeClass("w3-card-16 ");
		});

		$("#home,#adminname").mouseenter(function() {
			$(this).addClass("w3-white w3-card-16");
			$(this).removeClass("w3-theme");
		});
	});
</script>
