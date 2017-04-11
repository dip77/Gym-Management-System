
<footer class="w3-container w3-theme-d4">
	<div class="w3-row"
		style="font-family: cursive; font-stretch: wider; font-size: 25px;">
		<div class="w3-col m3">&nbsp; Gym</div>
		<div class="w3-col s1">&nbsp;</div>
		<div class="w3-col m2 ">
			<i class="fa fa-sitemap"></i> Activity
		</div>
		<div class="w3-col s1">&nbsp;</div>
		<div class="w3-col m2 ">
			<%
				if (session.getAttribute("memberBean") == null
						&& session.getAttribute("adminBean") == null
						&& session.getAttribute("trainerBean") == null) {
			%>
			<i class="fa fa-phone"></i> <a href="Contact-us.jsp"
				style="cursor: help;"> Contact Us</a>
			<%
				} else if (session.getAttribute("trainerBean") != null) {
			%>
			<i class="fa fa-phone"></i> <a href="TrainerContact-US.jsp"
				style="cursor: help;"> Contact Us</a>
			 		
			 		<%} %>
			 		</div>
		<div class="w3-col s1">&nbsp;</div>
		<div class="w3-col m2">
			<a href="AboutUS.jsp"><i class="fa-group fa"></i> About Us</a>
		</div>
	</div>

	<div class="w3-row" style="font-family: cursive; font-stretch: wider;">
		<div class="w3-col m3 ">
			&nbsp;<a href="Equipments.jsp"> Equipment</a>
		</div>
		<div class="w3-col s1">&nbsp;</div>
		<div class="w3-col m2 ">
			<a href="AboutUS.jsp">Yoga</a>
		</div>
		<div class="w3-col s1">&nbsp;</div>
		<div class="w3-col m2 ">&nbsp;</div>
		<div class="w3-col s1">&nbsp;</div>
		<div class="w3-col m2 ">&nbsp;</div>
	</div>

	<div class="w3-row" style="font-family: cursive; font-stretch: wider;">
		<div class="w3-col m3 ">
			&nbsp;<a href="GuestTrainerIntro.jsp"> Trainers</a>
		</div>
		<div class="w3-col s1">&nbsp;</div>
		<div class="w3-col m2 ">
			<a href="#">Pranayam</a>
		</div>
	</div>

	<div class="w3-row" style="font-family: cursive; font-stretch: wider;">
		<div class="w3-col m3 ">
			<a href="#"> &nbsp; Schedule</a>
		</div>
		<div class="w3-col s1">&nbsp;</div>
		<div class="w3-col m2 ">
			<a href="#">Stretching</a>
		</div>
	</div>
	<div class="w3-row" style="font-family: cursive; font-stretch: wider;">
		<div class="w3-col m3 ">&nbsp;</div>
		<div class="w3-col s1">&nbsp;</div>
		<div class="w3-col m2 ">
			<a href="#">ABS</a>
		</div>
	</div>
	<div class="w3-row" style="font-family: cursive; font-stretch: wider;">
		<div class="w3-col m3 ">&nbsp;</div>
		<div class="w3-col s1">&nbsp;</div>
		<div class="w3-col m2 ">
			<a href="#">CARDAIO</a>
		</div>
	</div>

</footer>
