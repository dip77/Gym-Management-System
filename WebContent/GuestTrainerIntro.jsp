<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Gym Trainer Information</title>

<link rel="icon" href="photo's/goldenGym1.ico"  ></head>

<body>
	<%@ include file="Header.jsp"%>

	<div class="w3-container">

		<div class="w3-row w3-theme-l2" align="center">
			<h1>Trainers Information</h1>
		</div>
		<div class="w3-half">
			<div class="w3-row">
				<div class="w3-col m3">
					<font style="font-size: 26px">Harsh Raval</font> <br />
				</div>
			</div>
			<div class="w3-row">
				<div class="w3-col m6 w3-animate-left">
					<img alt="harsh" src="photo's/Trainer/trainer-11.jpg"
						class="w3-card-8" />
				</div>

				<div class="w3-col m3">
					<!-- Trigger the modal with a button -->
					Abs Trainer<br /> <a data-toggle="modal" data-target="#harsh">More
						Detail</a>
				</div>
			</div>

			<br />

			<div class="w3-row">
				<div class="w3-col m3">
					<font style="font-size: 26px">Tyler Brown</font> <br />
				</div>
			</div>
			<div class="w3-row">
				<div class="w3-col m6 w3-animate-left">
					<img alt="harsh" src="photo's/Trainer/trainer-89.jpg"
						class="w3-card-8" />
				</div>

				<div class="w3-col m3">
					<!-- Trigger the modal with a button -->
					Personal Trainer<br /> <a data-toggle="modal" data-target="#Tyler">More
						Detail</a>
				</div>
			</div>

			<br />

			<div class="w3-row">
				<div class="w3-col m4">
					<font style="font-size: 26px">Sonal Chauhan</font> <br />
				</div>
			</div>
			<div class="w3-row">
				<div class="w3-col m6 w3-animate-left">
					<img alt="harsh" src="photo's/Trainer/trainer-55.jpg"
						class="w3-card-8" />
				</div>

				<div class="w3-col m3">
					<!-- Trigger the modal with a button -->
					Cardio Trainer <br /> <a data-toggle="modal" data-target="#sonal">More
						Detail</a>
				</div>
			</div>

			<br />

			<div class="w3-row">
				<div class="w3-col m4">
					<font style="font-size: 26px">Vijay Kapoor</font> <br />
				</div>
			</div>
			<div class="w3-row">
				<div class="w3-col m6 w3-animate-left">
					<img alt="harsh" src="photo's/Trainer/trainer-77.jpg"
						class="w3-card-8" />
				</div>

				<div class="w3-col m3">
					<!-- Trigger the modal with a button -->
					Streching Trainer <br /> <a data-toggle="modal"
						data-target="#vijay">More Detail</a>
				</div>
			</div>




		</div>



		<!-- right side -->


		<div class="w3-half">
			<div class="w3-row">
				<div class="w3-col m9" align="right">
					<font style="font-size: 26px">Naomi Staver</font> <br />
				</div>
			</div>
			<div class="w3-row">

				<div class="w3-col m3">
					<!-- Trigger the modal with a button -->
					Pilates Trainer<br /> <a data-toggle="modal" data-target="#naomi">More
						Detail</a>
				</div>
				<div class="w3-col m6 w3-animate-right">
					<img alt="naomi" src="photo's/Trainer/trainer-22.jpg"
						class="w3-card-8" />
				</div>
			</div>
			<br />
			<div class="w3-row">
				<div class="w3-col m9" align="right">
					<font style="font-size: 26px">Vatsal Patel</font> <br />
				</div>
			</div>

			<div class="w3-row">

				<div class="w3-col m3">
					<!-- Trigger the modal with a button -->
					Yoga Trainer<br /> <a data-toggle="modal" data-target="#vatsal">More
						Detail</a>
				</div>
				<div class="w3-col m6 w3-animate-right">
					<img alt="naomi" src="photo's/Trainer/trainer-44.jpg"
						class="w3-card-8" />
				</div>
			</div>

			<br />
			<div class="w3-row">
				<div class="w3-col m9" align="right">
					<font style="font-size: 26px">Caitlin Harrison</font> <br />
				</div>
			</div>

			<div class="w3-row">

				<div class="w3-col m3">
					<!-- Trigger the modal with a button -->
					Personal Traine<br /> <a data-toggle="modal"
						data-target="#caitlin">More Detail</a>
				</div>
				<div class="w3-col m6 w3-animate-right">
					<img alt="naomi" src="photo's/Trainer/trainer-33.jpg"
						class="w3-card-8" />
				</div>
			</div>


			<br />
			<div class="w3-row">
				<div class="w3-col m9" align="right">
					<font style="font-size: 26px">Nirav Shah</font> <br />
				</div>
			</div>

			<div class="w3-row">

				<div class="w3-col m3">
					<!-- Trigger the modal with a button -->
					Pranayam Trainer<br /> <a data-toggle="modal" data-target="#nirav">More
						Detail</a>
				</div>
				<div class="w3-col m6 w3-animate-right">
					<img alt="naomi" src="photo's/Trainer/trainer-66.jpg"
						class="w3-card-8" />
				</div>
			</div>



		</div>


	</div>

	<!-- Harsh raval -->
	<div class="modal fade" id="harsh" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content w3-animate-left">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Harsh Raval</h4>
				</div>
				<div class="modal-body">
					<div align="center">
						<img src="photo's/Trainer/trainer-11.jpg" class="w3-card-8" />
					</div>
					<br />
					<p>Harsh is a fitness professional involved in exercise
						prescription and instruction. He motivate clients by setting goals
						and providing feedback and accountability to clients. He also
						measure their client's strengths and weaknesses with fitness
						assessments. These fitness assessments may also be performed
						before and after an exercise program to measure their client's
						improvements in physical fitness. If a trainer suspects that one
						of his or her clients has a medical condition that could prevent
						the client from safe participation in an exercise program, they
						must refer the client to the proper health professional for prior
						clearance.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>

	<!--Sonal-->
	<div class="modal fade" id="sonal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content w3-animate-left">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Sonal Chauhan</h4>
				</div>
				<div class="modal-body">
					<div align="center">
						<img src="photo's/Trainer/trainer-55.jpg" class="w3-card-8" />
					</div>
					<br />
					<p>Sonal Chauhan is a fitness professional involved in exercise
						prescription and instruction. She motivate clients by setting
						goals and providing feedback and accountability to clients. She
						also measure their client's strengths and weaknesses with fitness
						assessments. These fitness assessments may also be performed
						before and after an exercise program to measure their client's
						improvements in physical fitness. If a trainer suspects that one
						of his or her clients has a medical condition that could prevent
						the client from safe participation in an exercise program, they
						must refer the client to the proper health professional for prior
						clearance.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>




	<!-- Naomi-->
	<div class="modal fade" id="naomi" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content w3-animate-right">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Naomi Staver</h4>
				</div>
				<div class="modal-body">
					<div align="center">
						<img src="photo's/Trainer/trainer-22.jpg" class="w3-card-8" />
					</div>
					<br />
					<p>Naomi Staver is a fitness professional involved in exercise
						prescription and instruction. She motivate clients by setting
						goals and providing feedback and accountability to clients. She
						also measure their client's strengths and weaknesses with fitness
						assessments. These fitness assessments may also be performed
						before and after an exercise program to measure their client's
						improvements in physical fitness. If a trainer suspects that one
						of his or her clients has a medical condition that could prevent
						the client from safe participation in an exercise program, they
						must refer the client to the proper health professional for prior
						clearance.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>


	<!-- Caitlin -->
	<div class="modal fade" id="caitlin" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content w3-animate-right">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Caitlin Harrison</h4>
				</div>
				<div class="modal-body">
					<div align="center">
						<img src="photo's/Trainer/trainer-33.jpg" class="w3-card-8" />
					</div>
					<br />
					<p>Caitlin Harrison is a fitness professional involved in
						exercise prescription and instruction. he motivate clients by
						setting goals and providing feedback and accountability to
						clients. He also measure their client's strengths and weaknesses
						with fitness assessments. These fitness assessments may also be
						performed before and after an exercise program to measure their
						client's improvements in physical fitness. If a trainer suspects
						that one of his or her clients has a medical condition that could
						prevent the client from safe participation in an exercise program,
						He must refer the client to the proper health professional for
						prior clearance.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>


	<!-- nirav -->
	<div class="modal fade" id="nirav" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content w3-animate-right">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Nirav Shah</h4>
				</div>
				<div class="modal-body">
					<div align="center">
						<img src="photo's/Trainer/trainer-66.jpg" class="w3-card-8" />
					</div>
					<br />
					<p>Nirav Shah is a fitness professional involved in exercise
						prescription and instruction. He motivate clients by setting goals
						and providing feedback and accountability to clients. He also
						measure their client's strengths and weaknesses with fitness
						assessments. These fitness assessments may also be performed
						before and after an exercise program to measure their client's
						improvements in physical fitness. If a trainer suspects that one
						of his or her clients has a medical condition that could prevent
						the client from safe participation in an exercise program, they
						must refer the client to the proper health professional for prior
						clearance.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>


	<!-- Tyler  -->
	<div class="modal fade" id="Tyler" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content w3-animate-left">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Harsh Raval</h4>
				</div>
				<div class="modal-body">
					<div align="center">
						<img src="photo's/Trainer/trainer-89	.jpg" class="w3-card-8" />
					</div>
					<br />
					<p>Tyler Brown is a fitness professional involved in exercise
						prescription and instruction. He motivate clients by setting goals
						and providing feedback and accountability to clients. He also
						measure their client's strengths and weaknesses with fitness
						assessments. These fitness assessments may also be performed
						before and after an exercise program to measure their client's
						improvements in physical fitness. If a trainer suspects that one
						of his or her clients has a medical condition that could prevent
						the client from safe participation in an exercise program, they
						must refer the client to the proper health professional for prior
						clearance.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>



	<!-- vijay  -->
	<div class="modal fade" id="vijay" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content w3-animate-left">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Vijay Kapoor</h4>
				</div>
				<div class="modal-body">
					<div align="center">
						<img src="photo's/Trainer/trainer-77.jpg" class="w3-card-8" />
					</div>
					<br />
					<p>Vijay Kapoor is a fitness professional involved in exercise
						prescription and instruction. He motivate clients by setting goals
						and providing feedback and accountability to clients. He also
						measure their client's strengths and weaknesses with fitness
						assessments. These fitness assessments may also be performed
						before and after an exercise program to measure their client's
						improvements in physical fitness. If a trainer suspects that one
						of his or her clients has a medical condition that could prevent
						the client from safe participation in an exercise program, they
						must refer the client to the proper health professional for prior
						clearance.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>


	<!-- vatsal -->
	<div class="modal fade" id="vatsal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content w3-animate-zoom">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Vatsal Patel</h4>
				</div>
				<div class="modal-body">
					<div align="center">
						<img src="photo's/Trainer/trainer-44.jpg" class="w3-card-8" />
					</div>
					<br />
					<p>Vatsal Patel is a fitness professional involved in exercise
						prescription and instruction. He motivate clients by setting goals
						and providing feedback and accountability to clients. He also
						measure their client's strengths and weaknesses with fitness
						assessments. These fitness assessments may also be performed
						before and after an exercise program to measure their client's
						improvements in physical fitness. If a trainer suspects that one
						of his or her clients has a medical condition that could prevent
						the client from safe participation in an exercise program, they
						must refer the client to the proper health professional for prior
						clearance.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	<footer><%@ include file="GFooter.jsp"%></footer>
</body>
</html>