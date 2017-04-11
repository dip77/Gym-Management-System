package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.smartcardio.ATR;

import com.digimation.goldengym.bean.SubscriptionBean;
import com.digimation.goldengym.util.MysqlConnection;

public class SubscriptionDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<SubscriptionBean> listOfSubscriptionBeans;
	public ArrayList<SubscriptionBean> getmemberSubscriptionListByPK(int id) {
		conn = MysqlConnection.getConnection();
		ArrayList<SubscriptionBean> subscriptionBeans=new ArrayList<SubscriptionBean>();
		SubscriptionBean subscriptionBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from subscription s,package_detail pd,activity a" +
					",member m,package p,member_type mt where s.member_id=? and m.member_id=s.member_id" +
					" and pd.package_id=p.package_id and s.package_detail_id=pd.package_detail_id and" +
					" a.activity_id=pd.activity_id and mt.member_type_id=pd.member_type_id");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {	
				subscriptionBeanObj = new SubscriptionBean();
				subscriptionBeanObj.setPackageDetailId(rs.getInt("package_detail_id"));
				subscriptionBeanObj.setSubscriptionId(rs.getInt("subscription_id"));
				subscriptionBeanObj.setMemberId(id);
				subscriptionBeanObj.setMemberType(rs.getString("member_type_name"));
				subscriptionBeanObj.setMemberTypeId(rs.getInt("member_type_id"));
				subscriptionBeanObj.setPackageName(rs.getString("package_name"));	
				subscriptionBeanObj.setActivity(rs.getString("activity"));
				subscriptionBeanObj.setActivityId(rs.getInt("activity_id"));
				subscriptionBeanObj.setAmount(rs.getInt("amount"));
				subscriptionBeanObj.setDuration(rs.getInt("duration"));		
				subscriptionBeanObj.setFirstName(rs.getString("first_name"));
				subscriptionBeanObj.setLastName(rs.getString("last_name"));
				subscriptionBeanObj.setEmail(rs.getString("email"));
				subscriptionBeanObj.setStartDate(rs.getString("start_date"));
				subscriptionBeanObj.setEndDate(rs.getString("end_date"));
				subscriptionBeans.add(subscriptionBeanObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subscriptionBeans;
	}

	public int getDuration(int id) {
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn.prepareStatement("select  duration from package_detail pd,package p" +
					" where p.package_id=pd.package_id and pd.package_detail_id=? ");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("duration");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	
	public boolean addSubscription(SubscriptionBean subscriptionBeanObj) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			
			pstmt = conn.prepareStatement("insert into subscription(package_detail_id,member_id,start_date," +
					"end_date) values(?,?,now(),date_add(curdate(),interval "+
					subscriptionBeanObj.getDuration()+" month))");
			pstmt.setInt(1, subscriptionBeanObj.getPackageDetailId());
			pstmt.setInt(2, subscriptionBeanObj.getMemberId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public ArrayList<SubscriptionBean> getSubscriptionList() {
		listOfSubscriptionBeans = new ArrayList<SubscriptionBean>();
		conn = MysqlConnection.getConnection();
		SubscriptionBean subscriptionBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from subscription s,package_detail pd,activity a," +
					"member_type mt,member m,package p where mt.member_type_id=pd.member_type_id and m.member_id=" +
					"s.member_id and s.package_detail_id=pd.package_detail_id and" +
					" a.activity_id=pd.activity_id and p.package_id=pd.package_id");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				subscriptionBeanObj = new SubscriptionBean();
				subscriptionBeanObj.setPackageDetailId(rs.getInt("package_detail_id"));
				subscriptionBeanObj.setSubscriptionId(rs.getInt("subscription_id"));
				subscriptionBeanObj.setMemberType(rs.getString("member_type_name"));
				subscriptionBeanObj.setMemberTypeId(rs.getInt("member_type_id"));
				subscriptionBeanObj.setPackageName(rs.getString("package_name"));
				subscriptionBeanObj.setActivity(rs.getString("activity"));
				subscriptionBeanObj.setActivityId(rs.getInt("member_id"));
				subscriptionBeanObj.setAmount(rs.getInt("amount"));
				subscriptionBeanObj.setDuration(rs.getInt("duration"));
				subscriptionBeanObj.setFirstName(rs.getString("first_name"));
				subscriptionBeanObj.setLastName(rs.getString("last_name"));
				subscriptionBeanObj.setEmail(rs.getString("email"));
				subscriptionBeanObj.setStartDate(rs.getString("start_date"));
				subscriptionBeanObj.setEndDate(rs.getString("end_date"));
				listOfSubscriptionBeans.add(subscriptionBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfSubscriptionBeans;
	}

	public SubscriptionBean getSubscriptionListByPK(int id) {
		conn = MysqlConnection.getConnection();
		SubscriptionBean subscriptionBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from subscription s,package_detail pd,activity a" +
					",member m,package p where s.subscription_id=? and m.member_id=s.member_id" +
					" and pd.package_id=p.package_id and s.package_detail_id=pd.package_detail_id and" +
					" a.activity_id=pd.activity_id");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				subscriptionBeanObj = new SubscriptionBean();
				subscriptionBeanObj.setSubscriptionId(rs.getInt("package_detail_id"));
				subscriptionBeanObj.setSubscriptionId(id);
				subscriptionBeanObj.setMemberType(rs.getString("member_type_name"));
				subscriptionBeanObj.setMemberTypeId(rs.getInt("member_type_id"));
				subscriptionBeanObj.setPackageName(rs.getString("package_name"));
				subscriptionBeanObj.setActivity(rs.getString("activity"));
				subscriptionBeanObj.setActivityId(rs.getInt("activity_id"));
				subscriptionBeanObj.setMemberId(rs.getInt("member_id"));
				subscriptionBeanObj.setAmount(rs.getInt("amount"));
				subscriptionBeanObj.setDuration(rs.getInt("duration"));		
				subscriptionBeanObj.setFirstName(rs.getString("first_name"));
				subscriptionBeanObj.setLastName(rs.getString("last_name"));
				subscriptionBeanObj.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subscriptionBeanObj;
	}

	public boolean updateSubscription(SubscriptionBean subscriptionBeanObj) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn.prepareStatement("update subscription set package_detail_id=?," +
					"member_id=?,start_date=?,start_date=? where subscription_id=?");
			pstmt.setInt(1, subscriptionBeanObj.getSubscriptionId());
			pstmt.setInt(2, subscriptionBeanObj.getMemberId());
			pstmt.setString(3, subscriptionBeanObj.getStartDate());
			pstmt.setString(4, subscriptionBeanObj.getEndDate());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean removeSubscription(int id) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn.prepareStatement("delete  from subscription where subscription_id=?");
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
