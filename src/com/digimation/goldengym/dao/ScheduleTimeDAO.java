package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.goldengym.bean.ScheduleTimeBean;
import com.digimation.goldengym.util.MysqlConnection;

public class ScheduleTimeDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<ScheduleTimeBean> listOfScheduleTimeBeans;

	

	public int getScheduleTimeID(String start_time,String end_time)
	{
		try {
			System.out.println(start_time+end_time);
			conn=MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select schedule_time_id from schedule_time where start_time=?" +
					" and end_time=?");
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

	
	public boolean addScheduleTime(ScheduleTimeBean schedule_timeBeanObj) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("insert into schedule_time(start_time,end_time) values(?,?)");
			pstmt.setString(1, schedule_timeBeanObj.getStartTime());
			pstmt.setString(2, schedule_timeBeanObj.getEndTime());
			i = pstmt.executeUpdate();	
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			
			return false;
		else
			return true;

	}

	public ArrayList<ScheduleTimeBean> getScheduleTimeList() {
		listOfScheduleTimeBeans = new ArrayList<ScheduleTimeBean>();
		conn = MysqlConnection.getConnection();
		ScheduleTimeBean schedule_timeBeanObj = null; 	
		try {
			pstmt = conn.prepareStatement("select * from schedule_time");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				schedule_timeBeanObj = new ScheduleTimeBean();
				schedule_timeBeanObj.setStartTime(rs.getString("start_time"));
				schedule_timeBeanObj.setEndTime(rs.getString("end_time"));
				schedule_timeBeanObj.setScheduleTimeId(rs.getInt("schedule_time_id"));
				listOfScheduleTimeBeans.add(schedule_timeBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfScheduleTimeBeans;
	}

	public ScheduleTimeBean getScheduleTimeListByPK(int id) {
		conn = MysqlConnection.getConnection();
		ScheduleTimeBean schedule_timeBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from schedule_time where schedule_time_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				schedule_timeBeanObj = new ScheduleTimeBean();
				schedule_timeBeanObj.setStartTime(rs.getString("start_time"));
				schedule_timeBeanObj.setEndTime(rs.getString("end_time"));
				schedule_timeBeanObj.setScheduleTimeId(id);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return schedule_timeBeanObj;
	}

	public boolean updateScheduleTime(ScheduleTimeBean schedule_timeBeanObj) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("update schedule_time set start_time=?,end_time=? where schedule_time_id=?");
			pstmt.setString(1, schedule_timeBeanObj.getStartTime());
			pstmt.setString(2, schedule_timeBeanObj.getEndTime());
			pstmt.setInt(3, schedule_timeBeanObj.getScheduleTimeId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean removeScheduleTime(int id) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn.prepareStatement("delete  from schedule_time where schedule_time_id=?");
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
