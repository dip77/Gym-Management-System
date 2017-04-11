package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.goldengym.bean.ScheduleBean;
import com.digimation.goldengym.util.MysqlConnection;

public class ScheduleDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<ScheduleBean> listOfScheduleBeans;

	

	public int getScheduleID(String start_time,String end_time)
	{
		try {
			conn=com.digimation.goldengym.util.MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select schedule_time_id from schedule_time where start_date=?" +
					"and end_date=?");
				pstmt.setString(1, start_time);
				pstmt.setString(2, end_time);
				 rs=pstmt.executeQuery();
				 if(rs.next())
				 return rs.getInt("schedule_time_id"); 
					 
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return -1;

	}


	public boolean checkReference(int schedule_timeId)
	{
		try {
			conn=com.digimation.goldengym.util.MysqlConnection.getConnection();
			/*pstmt=conn.prepareStatement("select * from user where schedule_time_id=?");
			pstmt.setInt(1, schedule_timeId);
			 rs=pstmt.executeQuery();
			 if(rs.next())
				 return true;
			*/ pstmt=conn.prepareStatement("select * from admin where schedule_time_id=?");
				pstmt.setInt(1, schedule_timeId);
				 rs=pstmt.executeQuery();
				 if(rs.next())
					 return true;
				 
					 
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return false;

	}

	
	public boolean addSchedule(ScheduleBean schedule_timeBeanObj) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("insert into schedule(schedule_time_id,activity_id,day)" +
							" values(?,?,?)");
			pstmt.setInt(1, schedule_timeBeanObj.getScheduleTimeId());
			pstmt.setInt(2, schedule_timeBeanObj.getActivityId());
			pstmt.setInt(3, schedule_timeBeanObj.getDay());
			i = pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public ArrayList<ScheduleBean> getScheduleList() {
		listOfScheduleBeans = new ArrayList<ScheduleBean>();
		conn = MysqlConnection.getConnection();
		ScheduleBean schedule_timeBeanObj = null; 	
		try {
			pstmt = conn.prepareStatement("select * from schedule s,schedule_time st,activity a" +
					" where s.activity_id=a.activity_id and s.schedule_time_id=st.schedule_time_id");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				schedule_timeBeanObj = new ScheduleBean();
				schedule_timeBeanObj.setScheduleTimeId(rs.getInt("schedule_time_id"));
				schedule_timeBeanObj.setEndTime(rs.getString("end_time"));
				schedule_timeBeanObj.setStartTime(rs.getString("start_time"));
				schedule_timeBeanObj.setScheduleId(rs.getInt("schedule_id"));
				schedule_timeBeanObj.setActivity(rs.getString("activity"));
				schedule_timeBeanObj.setActivityId(rs.getInt("activity_id"));
				schedule_timeBeanObj.setDay(rs.getInt("day"));
				listOfScheduleBeans.add(schedule_timeBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfScheduleBeans;
	}

	public ScheduleBean getScheduleListByPK(int id) {
		conn = MysqlConnection.getConnection();
		ScheduleBean schedule_timeBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from schedule s,schedule_time st,activity a" +
					" where s.activity_id=a.activity_id and s.schedule_time_id=st.schedule_time_id and " +
					"s.schedule_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				schedule_timeBeanObj = new ScheduleBean();
				schedule_timeBeanObj.setScheduleTimeId(rs.getInt("schedule_time_id"));
				schedule_timeBeanObj.setEndTime(rs.getString("end_time"));
				schedule_timeBeanObj.setStartTime(rs.getString("start_time"));
				schedule_timeBeanObj.setActivity(rs.getString("activity"));
				schedule_timeBeanObj.setActivityId(rs.getInt("activity_id"));
				schedule_timeBeanObj.setDay(rs.getInt("day"));
				schedule_timeBeanObj.setScheduleId(id);
			
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return schedule_timeBeanObj;
	}

	public boolean updateSchedule(ScheduleBean schedule_timeBeanObj) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("update schedule set schedule_time_id=?,activity_id=?" +
							",day=? where schedule_id=?");
			pstmt.setInt(1, schedule_timeBeanObj.getScheduleTimeId());
			pstmt.setInt(2, schedule_timeBeanObj.getActivityId());
			pstmt.setInt(3, schedule_timeBeanObj.getDay());
			pstmt.setInt(4, schedule_timeBeanObj.getScheduleId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean removeSchedule(int id) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn.prepareStatement("delete  from schedule where schedule_id=?");
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
