package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.goldengym.bean.ProgressDetailBean;
import com.digimation.goldengym.util.MysqlConnection;

public class ProgressDetailDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<ProgressDetailBean> listOfProgressDetailBeans;

	
		
	public boolean addProgressDetail(ProgressDetailBean progressBeanObj) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn.prepareStatement("insert into progress_detail(progress_id,weight,height" +
					",wrist,forearms,biceps,thigh,chest,bodyfat,date)" +
					"values(?,?,?,?,?,?,?,?,?,curdate())"); 
			pstmt.setInt(1, progressBeanObj.getProgressId());
			pstmt.setDouble(2, progressBeanObj.getWeight());
			pstmt.setDouble(3, progressBeanObj.getHeight());
			pstmt.setDouble(4, progressBeanObj.getWrist());
			pstmt.setDouble(5, progressBeanObj.getForearms());
			pstmt.setDouble(6, progressBeanObj.getBiceps());
			pstmt.setDouble(7, progressBeanObj.getThigh());
			pstmt.setDouble(8, progressBeanObj.getChest());
			pstmt.setDouble(9, progressBeanObj.getBodyfat());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public ArrayList<ProgressDetailBean> getProgressDetailList(int id) {
		listOfProgressDetailBeans = new ArrayList<ProgressDetailBean>();
		conn = MysqlConnection.getConnection();
		ProgressDetailBean progressBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from progress_detail pd," +
					"progress p,member m where m.member_id=p.member_id" +
					" and p.progress_id=pd.progress_id and m.member_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				progressBeanObj = new ProgressDetailBean();
				progressBeanObj.setProgressDetailId(rs.getInt("progress_detail_id"));
				progressBeanObj.setMemberId(rs.getInt("member_id"));
				progressBeanObj.setFirstName(rs.getString("first_name"));
				progressBeanObj.setLastName(rs.getString("last_name"));
				progressBeanObj.setEmail(rs.getString("email"));
				progressBeanObj.setStartDate(rs.getString("start_date"));
				progressBeanObj.setEndDate(rs.getString("end_date"));
				progressBeanObj.setWeight(rs.getDouble("weight"));
				progressBeanObj.setHeight(rs.getDouble("height"));
				progressBeanObj.setBiceps(rs.getDouble("biceps"));
				progressBeanObj.setBodyfat(rs.getDouble("bodyfat"));
				progressBeanObj.setWrist(rs.getDouble("wrist"));
				progressBeanObj.setForearms(rs.getDouble("forearms"));
				progressBeanObj.setChest(rs.getDouble("chest"));
				progressBeanObj.setThigh(rs.getDouble("thigh"));
				progressBeanObj.setDate(rs.getString("date"));
				listOfProgressDetailBeans.add(progressBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfProgressDetailBeans;
	}

	public ProgressDetailBean getProgressDetailListByPK(int id) {
		conn = MysqlConnection.getConnection();
		ProgressDetailBean progressBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from progress p,member m," +
					"progress_detail pd where progress_detail_id=? and " +
					"m.member_id=p.member_id and p.progress_id=pd.progress_id");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				progressBeanObj = new ProgressDetailBean();
				progressBeanObj.setProgressDetailId(id);
				progressBeanObj.setMemberId(rs.getInt("member_id"));
				progressBeanObj.setFirstName(rs.getString("first_name"));
				progressBeanObj.setLastName(rs.getString("last_name"));
				progressBeanObj.setEmail(rs.getString("email"));
				progressBeanObj.setStartDate(rs.getString("start_date"));
				progressBeanObj.setEndDate(rs.getString("end_date"));
				progressBeanObj.setWeight(rs.getDouble("weight"));
				progressBeanObj.setHeight(rs.getDouble("height"));
				progressBeanObj.setBiceps(rs.getDouble("biceps"));
				progressBeanObj.setBodyfat(rs.getDouble("bodyfat"));
				progressBeanObj.setWrist(rs.getDouble("wrist"));
				progressBeanObj.setForearms(rs.getDouble("forearms"));
				progressBeanObj.setChest(rs.getDouble("chest"));
				progressBeanObj.setThigh(rs.getDouble("thigh"));
				progressBeanObj.setDate(rs.getString("date"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return progressBeanObj;
	}

	public boolean updateProgressDetail(ProgressDetailBean progressBeanObj) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("update progress_detail set height=?,weight=?, " +
							"chest=?,wrist=?,forearms=?,biceps=?,thigh=?,bodyfat=?"+
							" where progress_detail_id=?");
			pstmt.setDouble(1, progressBeanObj.getWeight());
			pstmt.setDouble(2, progressBeanObj.getHeight());
			pstmt.setDouble(3, progressBeanObj.getChest());
			pstmt.setDouble(4, progressBeanObj.getWrist());
			pstmt.setDouble(5, progressBeanObj.getForearms());
			pstmt.setDouble(6, progressBeanObj.getBiceps());
			pstmt.setDouble(7, progressBeanObj.getThigh());
			pstmt.setDouble(8, progressBeanObj.getBodyfat());
			pstmt.setInt(9, progressBeanObj.getProgressDetailId());
			
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean removeProgressDetail(int id) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn.prepareStatement("delete  from progress_detail where progress_detail_id=?");
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
