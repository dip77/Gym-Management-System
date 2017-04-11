package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.goldengym.bean.ProgressBean;
import com.digimation.goldengym.util.MysqlConnection;

public class ProgressDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<ProgressBean> listOfProgressBeans;

	
	public ArrayList<ProgressBean> getProgressList(int id) {
		listOfProgressBeans = new ArrayList<ProgressBean>();
		conn = MysqlConnection.getConnection();
		ProgressBean progressBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from progress p,member m where m.member_id=p.member_id" +
					" and p.member_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				progressBeanObj = new ProgressBean();
				progressBeanObj.setProgressId(rs.getInt("progress_id"));
				progressBeanObj.setMemberId(rs.getInt("member_id"));
				progressBeanObj.setFirstName(rs.getString("first_name"));
				progressBeanObj.setLastName(rs.getString("last_name"));
				progressBeanObj.setEmail(rs.getString("email"));
				progressBeanObj.setStartDate(rs.getString("start_date"));
				progressBeanObj.setEndDate(rs.getString("end_date"));

				
				listOfProgressBeans.add(progressBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfProgressBeans;
	}

	public int getProgressID(int id)
	{
		try {
			conn=com.digimation.goldengym.util.MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select progress_id from progress where member_id=?");
				pstmt.setInt(1, id);
				 rs=pstmt.executeQuery();
				 if(rs.next())
				 return rs.getInt("progress_id"); 
					 
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return -1;

	}


		
	public boolean addProgress(ProgressBean progressBeanObj) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("insert into progress(member_id,start_date,end_date) values(?,?," +
							"date_add('"+progressBeanObj.getStartDate()+"',interval 1 month))");
			System.out.println(progressBeanObj.getStartDate());
			pstmt.setInt(1, progressBeanObj.getMemberId());
			pstmt.setString(2, progressBeanObj.getStartDate());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public ArrayList<ProgressBean> getProgressList() {
		listOfProgressBeans = new ArrayList<ProgressBean>();
		conn = MysqlConnection.getConnection();
		ProgressBean progressBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from progress p,member m where m.member_id=p.member_id");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				progressBeanObj = new ProgressBean();
				progressBeanObj.setProgressId(rs.getInt("progress_id"));
				progressBeanObj.setMemberId(rs.getInt("member_id"));
				progressBeanObj.setFirstName(rs.getString("first_name"));
				progressBeanObj.setLastName(rs.getString("last_name"));
				progressBeanObj.setEmail(rs.getString("email"));
				progressBeanObj.setStartDate(rs.getString("start_date"));
				progressBeanObj.setEndDate(rs.getString("end_date"));

				
				listOfProgressBeans.add(progressBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfProgressBeans;
	}

	public ProgressBean getProgressListByPK(int id) {
		conn = MysqlConnection.getConnection();
		ProgressBean progressBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from progress p,member m where progress_id=? and " +
					"m.member_id=p.member_id");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				progressBeanObj = new ProgressBean();
				progressBeanObj.setProgressId(id);
				progressBeanObj.setMemberId(rs.getInt("member_id"));
				progressBeanObj.setFirstName(rs.getString("first_name"));
				progressBeanObj.setLastName(rs.getString("last_name"));
				progressBeanObj.setEmail(rs.getString("email"));
				progressBeanObj.setStartDate(rs.getString("start_date"));
				progressBeanObj.setEndDate(rs.getString("end_date"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return progressBeanObj;
	}

	public boolean updateProgress(ProgressBean progressBeanObj) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("update progress set member_id=? where progress_id=?");
			pstmt.setInt(1, progressBeanObj.getMemberId());
			pstmt.setInt(2, progressBeanObj.getProgressId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean removeProgress(int id) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn.prepareStatement("delete  from progress where progress_id=?");
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
