package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.goldengym.bean.MemberScheduleBean;
import com.digimation.goldengym.bean.TrainerBean;
import com.digimation.goldengym.util.MysqlConnection;

public class MemberScheduleDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<MemberScheduleBean> listOfMemberScheduleBeans;
	public ArrayList<MemberScheduleBean> getMemberList(int id) {
		conn = MysqlConnection.getConnection();
		MemberScheduleBean memberScheduleBeanObj = null;
		try {
			listOfMemberScheduleBeans=new ArrayList<MemberScheduleBean>();
			pstmt = conn.prepareStatement("select * from member_schedule ms,schedule s,schedule_time st," +
					"activity a,member m where a.activity_id=s.activity_id and st.schedule_time_id=s.schedule_time_id" +
					" and s.schedule_id=ms.schedule_id and ms.member_id=m.member_id and  ms.trainer_id=?");
			pstmt.setInt(1, id); 
			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberScheduleBeanObj = new MemberScheduleBean();
				memberScheduleBeanObj.setFirstName(rs.getString("first_name"));
				memberScheduleBeanObj.setLastName(rs.getString("last_name"));
				memberScheduleBeanObj.setMemberScheduleId(rs.getInt("member_schedule_id"));
				memberScheduleBeanObj.setMemberId(rs.getInt("member_Id"));
				memberScheduleBeanObj.setTrainerId(id);
				memberScheduleBeanObj.setActivity(rs.getString("activity"));
				memberScheduleBeanObj.setActivityId(rs.getInt("activity_id"));
				memberScheduleBeanObj.setScheduleTimeId(rs.getInt("schedule_time_id"));
				memberScheduleBeanObj.setStartTime(rs.getString("start_time"));
				memberScheduleBeanObj.setEndTime(rs.getString("end_time"));
				memberScheduleBeanObj.setScheduleId(rs.getInt("schedule_id"));
				memberScheduleBeanObj.setDay(rs.getInt("day"));
			TrainerBean  trainerBean=new TrainerDAO().getTrainerListByPK(memberScheduleBeanObj.getTrainerId());
			memberScheduleBeanObj.setTrainerName(trainerBean.getFirstName()+" "+trainerBean.getLastName());
			
			listOfMemberScheduleBeans.add(memberScheduleBeanObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfMemberScheduleBeans;
	}


	public ArrayList<MemberScheduleBean> getMemberSchedule(int id) {
		conn = MysqlConnection.getConnection();
		MemberScheduleBean memberScheduleBeanObj = null;
		try {
			listOfMemberScheduleBeans=new ArrayList<MemberScheduleBean>();
			pstmt = conn.prepareStatement("select * from member_schedule ms,schedule s,schedule_time st," +
					"activity a where a.activity_id=s.activity_id and st.schedule_time_id=s.schedule_time_id" +
					" and s.schedule_id=ms.schedule_id and member_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberScheduleBeanObj = new MemberScheduleBean();
				memberScheduleBeanObj.setMemberScheduleId(rs.getInt("member_schedule_id"));
				memberScheduleBeanObj.setMemberId(id);
				memberScheduleBeanObj.setActivity(rs.getString("activity"));
				memberScheduleBeanObj.setActivityId(rs.getInt("activity_id"));
				memberScheduleBeanObj.setScheduleTimeId(rs.getInt("schedule_time_id"));
				memberScheduleBeanObj.setStartTime(rs.getString("start_time"));
				memberScheduleBeanObj.setEndTime(rs.getString("end_time"));
				memberScheduleBeanObj.setScheduleId(rs.getInt("schedule_id"));
				memberScheduleBeanObj.setTrainerId(rs.getInt("trainer_id"));
				memberScheduleBeanObj.setDay(rs.getInt("day"));
			TrainerBean  trainerBean=new TrainerDAO().getTrainerListByPK(memberScheduleBeanObj.getTrainerId());
			memberScheduleBeanObj.setTrainerName(trainerBean.getFirstName()+" "+trainerBean.getLastName());
			
			listOfMemberScheduleBeans.add(memberScheduleBeanObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfMemberScheduleBeans;
	}


	public int getScheduleID(int activityId,int scheduleTimeId)
	{
		try {
			conn=com.digimation.goldengym.util.MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select schedule_id from schedule where schedule_time_id=?" +
					" and activity_id=?");
				pstmt.setInt(1, activityId);
				pstmt.setInt(2, scheduleTimeId);
				 rs=pstmt.executeQuery();
				 if(rs.next())
				 return rs.getInt("schedule_id"); 
					 
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return -1;

	}


	public int getMemberScheduleID(String memberSchedule)
	{
		try {
			conn=com.digimation.goldengym.util.MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select member_schedule_id from member_schedule where member_dchedule=?");
				pstmt.setString(1, memberSchedule);
				 rs=pstmt.executeQuery();
				 if(rs.next())
				 return rs.getInt("memberSchedule_id"); 
					 
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return -1;

	}


		
	public boolean addMemberSchedule(MemberScheduleBean memberScheduleBeanObj) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("insert into member_schedule(schedule_id,member_id,trainer_id)" +
							" values(?,?,?)");
			pstmt.setInt(1, memberScheduleBeanObj.getScheduleId());
			pstmt.setInt(2, memberScheduleBeanObj.getMemberId());
			pstmt.setInt(3, memberScheduleBeanObj.getTrainerId());
			
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public ArrayList<MemberScheduleBean> getMemberScheduleList() {
		listOfMemberScheduleBeans = new ArrayList<MemberScheduleBean>();
		conn = MysqlConnection.getConnection();
		MemberScheduleBean memberScheduleBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from member_schedule ms,schedule s,schedule_time st," +
				"activity a,member m where s.activity_id=a.activity_id and s.schedule_time_id=st.schedule_time_id" +
					" and ms.schedule_id=s.schedule_id and ms.member_id=m.member_id");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberScheduleBeanObj = new MemberScheduleBean();
				memberScheduleBeanObj.setTrainerId(rs.getInt("trainer_Id"));
				memberScheduleBeanObj.setScheduleId(rs.getInt("schedule_id"));
				memberScheduleBeanObj.setMemberScheduleId(rs.getInt("member_schedule_id"));
				memberScheduleBeanObj.setMemberId(rs.getInt("member_id"));
				memberScheduleBeanObj.setActivity(rs.getString("activity"));
				memberScheduleBeanObj.setActivityId(rs.getInt("activity_id"));
				memberScheduleBeanObj.setScheduleTimeId(rs.getInt("schedule_time_id"));
				memberScheduleBeanObj.setStartTime(rs.getString("start_time"));
				memberScheduleBeanObj.setEndTime(rs.getString("end_time"));
				memberScheduleBeanObj.setScheduleId(rs.getInt("schedule_id"));
				memberScheduleBeanObj.setFirstName(rs.getString("first_name"));
				memberScheduleBeanObj.setLastName(rs.getString("last_name"));
				memberScheduleBeanObj.setEmail(rs.getString("email"));
				memberScheduleBeanObj.setTrainerId(rs.getInt("trainer_id"));
				listOfMemberScheduleBeans.add(memberScheduleBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfMemberScheduleBeans;
	}

	public MemberScheduleBean getMemberScheduleListByPK(int id) {
		conn = MysqlConnection.getConnection();
		MemberScheduleBean memberScheduleBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from member_schedule ms,schedule s,schedule_time st," +
					"activity a where a.activity_id=s.activity_id and st.schedule_time_id=s.schedule_time_id" +
					" and s.schedule_id=ms.schedule_id and member_schedule_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberScheduleBeanObj = new MemberScheduleBean();
				memberScheduleBeanObj.setMemberScheduleId(id);
				memberScheduleBeanObj.setMemberId(rs.getInt("member_id"));
				memberScheduleBeanObj.setActivity(rs.getString("activity"));
				memberScheduleBeanObj.setActivityId(rs.getInt("activity_id"));
				memberScheduleBeanObj.setScheduleTimeId(rs.getInt("schedule_time_id"));
				memberScheduleBeanObj.setStartTime(rs.getString("start_time"));
				memberScheduleBeanObj.setEndTime(rs.getString("end_time"));
				memberScheduleBeanObj.setScheduleId(rs.getInt("schedule_id"));
				memberScheduleBeanObj.setTrainerId(rs.getInt("trainer_id"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberScheduleBeanObj;
	}

	public boolean updateMemberSchedule(MemberScheduleBean memberScheduleBeanObj) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("update member_schedule set schedule_id=?,member_id=?,trainer_id=? where" +
							" member_schedule_id=?");
			pstmt.setInt(1, memberScheduleBeanObj.getScheduleId());
			pstmt.setInt(2, memberScheduleBeanObj.getMemberId());
			pstmt.setInt(3, memberScheduleBeanObj.getTrainerId());
			pstmt.setInt(4, memberScheduleBeanObj.getMemberScheduleId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean removeMemberSchedule(int id) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn.prepareStatement("delete  from member_schedule where member_schedule_id=?");
			pstmt.setInt(1, id);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

}
