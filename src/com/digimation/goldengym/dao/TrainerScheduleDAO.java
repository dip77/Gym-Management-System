package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.goldengym.bean.TrainerScheduleBean;
import com.digimation.goldengym.util.MysqlConnection;

public class TrainerScheduleDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<TrainerScheduleBean> listOfTrainerScheduleBeans;

	
	public ArrayList<TrainerScheduleBean> getTrainerScheduleList(int id) {
		listOfTrainerScheduleBeans = new ArrayList<TrainerScheduleBean>();
		conn = MysqlConnection.getConnection();
		TrainerScheduleBean trainerScheduleBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from trainer_schedule ms,schedule s,schedule_time st," +
					"activity a,trainer m where a.activity_id=s.activity_id and st.schedule_time_id=s.schedule_time_id" +
					" and s.schedule_id=ms.schedule_id and m.trainer_id=ms.trainer_id and ms.trainer_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				trainerScheduleBeanObj = new TrainerScheduleBean();
				trainerScheduleBeanObj.setScheduleId(rs.getInt("schedule_id"));
				trainerScheduleBeanObj.setTrainerScheduleId(rs.getInt("trainer_schedule_id"));
				trainerScheduleBeanObj.setTrainerId(rs.getInt("trainer_id"));
				trainerScheduleBeanObj.setActivity(rs.getString("activity"));
				trainerScheduleBeanObj.setActivityId(rs.getInt("activity_id"));
				trainerScheduleBeanObj.setScheduleTimeId(rs.getInt("schedule_time_id"));	
				trainerScheduleBeanObj.setStartTime(rs.getString("start_time"));
				trainerScheduleBeanObj.setEndTime(rs.getString("end_time"));
				trainerScheduleBeanObj.setScheduleId(rs.getInt("schedule_id"));
				trainerScheduleBeanObj.setFirstName(rs.getString("first_name"));
				trainerScheduleBeanObj.setLastName(rs.getString("last_name"));
				trainerScheduleBeanObj.setEmail(rs.getString("email"));
				trainerScheduleBeanObj.setDay(rs.getInt("day"));
				listOfTrainerScheduleBeans.add(trainerScheduleBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfTrainerScheduleBeans;
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


	public int getTrainerScheduleID(String trainerSchedule)
	{
		try {
			conn=com.digimation.goldengym.util.MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select trainer_schedule_id from trainer_schedule where trainer_schedule=?");
				pstmt.setString(1, trainerSchedule);
				 rs=pstmt.executeQuery();
				 if(rs.next())
				 return rs.getInt("trainerSchedule_id"); 
					 
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return -1;

	}


		
	public boolean addTrainerSchedule(TrainerScheduleBean trainerScheduleBeanObj) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("insert into trainer_schedule(schedule_id,trainer_id) values(?,?)");
			pstmt.setInt(1, trainerScheduleBeanObj.getScheduleId());
			pstmt.setInt(2, trainerScheduleBeanObj.getTrainerId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public ArrayList<TrainerScheduleBean> getTrainerScheduleList() {
		listOfTrainerScheduleBeans = new ArrayList<TrainerScheduleBean>();
		conn = MysqlConnection.getConnection();
		TrainerScheduleBean trainerScheduleBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from trainer_schedule ms,schedule s,schedule_time st," +
					"activity a,trainer m where a.activity_id=s.activity_id and st.schedule_time_id=s.schedule_time_id" +
					" and s.schedule_id=ms.schedule_id and m.trainer_id=ms.trainer_id");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				trainerScheduleBeanObj = new TrainerScheduleBean();
				trainerScheduleBeanObj.setScheduleId(rs.getInt("schedule_id"));
				trainerScheduleBeanObj.setTrainerScheduleId(rs.getInt("trainer_schedule_id"));
				trainerScheduleBeanObj.setTrainerId(rs.getInt("trainer_id"));
				trainerScheduleBeanObj.setActivity(rs.getString("activity"));
				trainerScheduleBeanObj.setActivityId(rs.getInt("activity_id"));
				trainerScheduleBeanObj.setScheduleTimeId(rs.getInt("schedule_time_id"));	
				trainerScheduleBeanObj.setStartTime(rs.getString("start_time"));
				trainerScheduleBeanObj.setEndTime(rs.getString("end_time"));
				trainerScheduleBeanObj.setScheduleId(rs.getInt("schedule_id"));
				trainerScheduleBeanObj.setFirstName(rs.getString("first_name"));
				trainerScheduleBeanObj.setLastName(rs.getString("last_name"));
				trainerScheduleBeanObj.setEmail(rs.getString("email"));
				listOfTrainerScheduleBeans.add(trainerScheduleBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfTrainerScheduleBeans;
	}

	public TrainerScheduleBean getTrainerScheduleListByPK(int id) {
		conn = MysqlConnection.getConnection();
		TrainerScheduleBean trainerScheduleBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from trainer_schedule ms,schedule s,schedule_time st," +
					"activity a where a.activity_id=s.activity_id and st.schedule_time_id=s.schedule_time_id" +
					" and s.schedule_id=ms.schedule_id and trainer_schedule_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				trainerScheduleBeanObj = new TrainerScheduleBean();
				trainerScheduleBeanObj.setTrainerScheduleId(id);
				trainerScheduleBeanObj.setTrainerId(rs.getInt("trainer_id"));
				trainerScheduleBeanObj.setActivity(rs.getString("activity"));
				trainerScheduleBeanObj.setActivityId(rs.getInt("activity_id"));
				trainerScheduleBeanObj.setScheduleTimeId(rs.getInt("schedule_time_id"));
				trainerScheduleBeanObj.setStartTime(rs.getString("start_time"));
				trainerScheduleBeanObj.setEndTime(rs.getString("end_time"));
				trainerScheduleBeanObj.setScheduleId(rs.getInt("schedule_id"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainerScheduleBeanObj;
	}

	public boolean updateTrainerSchedule(TrainerScheduleBean trainerScheduleBeanObj) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("update trainer_schedule set schedule_id=?,trainer_id=? where" +
							" trainer_schedule_id=?");
			pstmt.setInt(1, trainerScheduleBeanObj.getScheduleId());
			pstmt.setInt(2, trainerScheduleBeanObj.getTrainerId());
			pstmt.setInt(3, trainerScheduleBeanObj.getTrainerScheduleId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean removeTrainerSchedule(int id) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn.prepareStatement("delete  from trainer_schedule where trainer_schedule_id=?");
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
