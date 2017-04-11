package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.goldengym.bean.FeedbackBean;
import com.digimation.goldengym.bean.UserInquiryBean;
import com.digimation.goldengym.bean.UserInquiryBean;
import com.digimation.goldengym.util.MysqlConnection;

public class UserInquiryDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<UserInquiryBean> listOfUserInquiryBeans;

	public ArrayList<UserInquiryBean> getRegularFeedbackList() {
		listOfUserInquiryBeans = new ArrayList<UserInquiryBean>();
		conn = MysqlConnection.getConnection();
		UserInquiryBean inquiryBeanObj = null;
		try {
			pstmt = conn
					.prepareStatement("select * from inquiry where date=curdate()");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				inquiryBeanObj = new UserInquiryBean();
				inquiryBeanObj.setUserInquiry(rs.getInt("inquiry_id"));
				inquiryBeanObj.setFirstName(rs.getString("first_name"));
				inquiryBeanObj.setLastName(rs.getString("last_name"));
				inquiryBeanObj.setMobile(rs.getString("mobile"));
				inquiryBeanObj.setDate(rs.getString("date"));
				inquiryBeanObj.setEmail(rs.getString("email"));
				inquiryBeanObj.setMessage(rs.getString("message"));
				inquiryBeanObj.setIsRead(rs.getString("is_read"));

				listOfUserInquiryBeans.add(inquiryBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfUserInquiryBeans;
	}

	public boolean addUsertInquiry(UserInquiryBean userInquiryBean) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("INSERT INTO INQUIRY(FIRST_NAME ,LAST_NAME, EMAIL, MOBILE, MESSAGE ,DATE ,IS_READ ) VALUES(?,?,?,?,?,curdate(),?)");
			pstmt.setString(1, userInquiryBean.getFirstName());
			pstmt.setString(2, userInquiryBean.getLastName());
			pstmt.setString(3, userInquiryBean.getEmail());
			pstmt.setString(4, userInquiryBean.getMobile());
			pstmt.setString(5, userInquiryBean.getMessage());
			pstmt.setString(6, userInquiryBean.getIsRead());

			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public ArrayList<UserInquiryBean> getUserInquiryList() {
		listOfUserInquiryBeans = new ArrayList<UserInquiryBean>();
		conn = MysqlConnection.getConnection();
		UserInquiryBean userInquiryBean = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM INQUIRY");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userInquiryBean = new UserInquiryBean();

				userInquiryBean.setUserInquiry(rs.getInt("inquiry_id"));
				userInquiryBean.setDate(rs.getString("date"));
				userInquiryBean.setFirstName(rs.getString("first_name"));
				userInquiryBean.setLastName(rs.getString("last_name"));
				userInquiryBean.setEmail(rs.getString("email"));
				userInquiryBean.setMobile(rs.getString("mobile"));
				userInquiryBean.setMessage(rs.getString("message"));
				userInquiryBean.setIsRead(rs.getString("is_read"));

				listOfUserInquiryBeans.add(userInquiryBean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfUserInquiryBeans;
	}

	public UserInquiryBean getUserInquiryByPK(int id) {
		conn = MysqlConnection.getConnection();
		UserInquiryBean userInquiryBean = null;
		try {
			pstmt = conn
					.prepareStatement("SELECT * FROM INQUIRY WHERE INQUIRY_ID=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userInquiryBean = new UserInquiryBean();
				userInquiryBean.setUserInquiry(id);
				userInquiryBean.setFirstName(rs.getString("first_name"));
				userInquiryBean.setLastName(rs.getString("last_name"));
				userInquiryBean.setEmail(rs.getString("email"));
				userInquiryBean.setMessage(rs.getString("message"));
				userInquiryBean.setMobile(rs.getString("mobile"));
				userInquiryBean.setDate(rs.getString("date"));
				userInquiryBean.setIsRead(rs.getString("is_read"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInquiryBean;
	}

	public boolean updateUserInquiry(UserInquiryBean userInquiryBean) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("UPDATE INQUIRY SET first_name=? , last_name=? ,email=?,mobile=?,message=?, DATE=curdate(),is_read=?  WHERE INQUIRY_ID=?");
			pstmt.setString(1, userInquiryBean.getFirstName());
			pstmt.setString(2, userInquiryBean.getLastName());
			pstmt.setString(3, userInquiryBean.getEmail());
			pstmt.setString(4, userInquiryBean.getMobile());
			pstmt.setString(5, userInquiryBean.getMessage());
			pstmt.setString(6, userInquiryBean.getIsRead());
			pstmt.setInt(7, userInquiryBean.getUserInquiry());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean removeUserInquiry(int id) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("DELETE  FROM INQUIRY WHERE INQUIRY_ID=?");
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

	public static void main(String[] args) {

	}

}
