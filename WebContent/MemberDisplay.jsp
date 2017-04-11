<%@page import="com.digimation.goldengym.dao.ProgressDAO"%>
<%@page import="com.digimation.goldengym.bean.MemberScheduleBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" href="photo's/goldenGym1.ico"  ></head>
<body>
<%@ include file="TrainerHeader.jsp"%>
	<div align="center">

<div class="container">
	<h2 style="text-transform: capitalize;">${trainerBean.firstName} Details</h2>
  <div class="panel panel-default ">
    <div class="panel-heading w3-theme"><table >
    <tr>
    			<th>Name</th>
				<th>Activity</th>
				<th>Start Time</th>
				<th>End Time</th>
				<th>Action</th>
	
    </tr>
    </table></div>
    <div class="panel-body "><table>
    		<% ArrayList<MemberScheduleBean> memberScheduleBeans=(ArrayList)request.getAttribute("memberScheduleBeans");
			for(int i=0;i<memberScheduleBeans.size();i++)
			{
				MemberScheduleBean memberScheduleBean=memberScheduleBeans.get(i);
			%>
			<tr>
			
				<td><%=memberScheduleBean.getFirstName()+" "+memberScheduleBean.getLastName() %></td>
				<td><%=memberScheduleBean.getActivity() %></td>
				<td><%=memberScheduleBean.getStartTime() %></td>
				<td><%=memberScheduleBean.getEndTime() %></td>
				<td><a href="TrainerProgressDisplayServlet?id=<%=memberScheduleBean.getMemberId()%>">Progress Card</a></td>
			</tr>
			 <% 	
			}
			%>
			 
		</table>
	
    
     </div>
  </div>
</div>

<%-- 
		<table class="display table table-hover w3-card-16">
			<tr class="w3-theme-d3" style="font-size: 24px;">
				<th>Name</th>
				<th>Activity</th>
				<th>Start Time</th>
				<th>End Time</th>
				<th>Action</th>
				
			</tr>
			<%  memberScheduleBeans=(ArrayList)request.getAttribute("memberScheduleBeans");
			for(int i=0;i<memberScheduleBeans.size();i++)
			{
				MemberScheduleBean memberScheduleBean=memberScheduleBeans.get(i);
			%>
			
			<tr >
				<td><%=memberScheduleBean.getFirstName()+" "+memberScheduleBean.getLastName() %></td>
				<td><%=memberScheduleBean.getActivity() %></td>
				<td><%=memberScheduleBean.getStartTime() %></td>
				<td><%=memberScheduleBean.getEndTime() %></td>
				<td><a href="TrainerProgressDisplayServlet?id=<%=new ProgressDAO().
				getProgressID(memberScheduleBean.getMemberId())%>">Progress Card</a></td>
			</tr>
			<% 	
			}
			
			
			%>
		</table>
 --%>	</div>
</body>
</html>