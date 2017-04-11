package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.goldengym.bean.ActivityBean;
import com.digimation.goldengym.util.MysqlConnection;

public class ActivityDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<ActivityBean> listOfActivityBeans;

	

	public int getActivityID(String activity)
	{
		try {
			conn=com.digimation.goldengym.util.MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select activity_id from activity where activity=?");
				pstmt.setString(1, activity);
				 rs=pstmt.executeQuery();
				 if(rs.next())
				 return rs.getInt("activity_id"); 
					 
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return -1;

	}


		
	public boolean addActivity(ActivityBean activityBeanObj) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("insert into activity(activity) values(?)");
			pstmt.setString(1, activityBeanObj.getActivity());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public ArrayList<ActivityBean> getActivityList() {
		listOfActivityBeans = new ArrayList<ActivityBean>();
		conn = MysqlConnection.getConnection();
		ActivityBean activityBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from activity");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				activityBeanObj = new ActivityBean();
				activityBeanObj.setActivityId(rs.getInt("activity_id"));
				activityBeanObj.setActivity(rs.getString("activity"));
				listOfActivityBeans.add(activityBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfActivityBeans;
	}

	public ActivityBean getActivityListByPK(int id) {
		conn = MysqlConnection.getConnection();
		ActivityBean activityBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from activity where activity_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				activityBeanObj = new ActivityBean();
				activityBeanObj.setActivityId(id);
				activityBeanObj.setActivity(rs.getString("activity"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return activityBeanObj;
	}

	public boolean updateActivity(ActivityBean activityBeanObj) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("update activity set activity=? where activity_id=?");
			pstmt.setString(1, activityBeanObj.getActivity());
			pstmt.setInt(2, activityBeanObj.getActivityId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean removeActivity(int id) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn.prepareStatement("delete  from activity where activity_id=?");
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
