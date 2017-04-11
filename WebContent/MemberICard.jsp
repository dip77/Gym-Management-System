<%@page import="com.digimation.goldengym.bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${memberBean.firstName} I-Card</title>
</head>
<body>
	<%@ include file="UserHeader.jsp"%>
	<a style="font-size: 23px; cursor: help;" align="center"
		onclick="printDiv('table1')" class="w3-btn w3-theme"> Print_card</a>
	<%
		MemberBean memberBean = (MemberBean) session
				.getAttribute("memberBean");
	%>
	<br />
	<br />
	<div class="w3-container" align="center">
		<div class="w3-quarter"></div>

		<div class="w3-half" align="center">
			<table id="table1" class="w3-border ">
				<tr>
					<td>
						<table>

							<tr>
								<td colspan="4"
									style="font-size: 23px; background-color: #26a69a; color: #fff"
									align="center">Golden Gym</td>
							</tr>
							<tr>

								<td rowspan="7"><img alt="photo"
									src="upload/photo/${memberBean.photo}" height="150" width="120" /></td>
								<td style="font-weight: 900;">Name :</td>
								<td style="text-transform: capitalize;"><%=memberBean.getFirstName() + " "
					+ memberBean.getLastName()%></td>
								<td rowspan="7"><img alt="photo"
									src="upload/QRCode/${memberBean.memberId}<%= memberBean.getFirstName() %>.gif"
									height="100%" width="100%" /></td>

							</tr>

							<tr>
							<tr>

								<td style="font-weight: 900;">Issue Date :</td>
								<td>19-03-2016</td>
							</tr>


							<tr>
								<td style="font-weight: 900;">Valid Upto :</td>
								<td>19-09-2016</td>
							</tr>

							<tr>
								<td style="font-weight: 900;">Member Type :</td>
								<td>Personal</td>
							</tr>
							<tr>
								<td style="font-weight: 900;">Activity :</td>
								<td>Yoga</td>
							</tr>

							<tr>
								<td style="font-weight: 900;">City :</td>
								<td>Ahmedabad</td>
							</tr>


							<tr>
								<td colspan="2" style="letter-spacing: 10px; font-weight: 900;">Address
									:</td>
								<td width="260" colspan="2"><%=memberBean.getAddress()%></td>
							</tr>

						</table>
					</td>
				</tr>
			</table>
			<div class="w3-quarter"></div>
		</div>
	</div>
	<script type="text/javascript">
		function printDiv(divName) {
			var printContents = document.getElementById(divName).innerHTML;
			var originalContents = document.body.innerHTML;

			document.body.innerHTML = printContents;

			window.print();

			document.body.innerHTML = originalContents;
		}
	</script>
	<br />
	<br />
	<br />
	<br />
	<%@ include file="GFooter.jsp"%>
</body>
</html>