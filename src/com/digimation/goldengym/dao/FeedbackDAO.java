package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.goldengym.bean.FeedbackBean;
import com.digimation.goldengym.bean.FeedbackBean;
import com.digimation.goldengym.bean.FeedbackBean;
import com.digimation.goldengym.util.MysqlConnection;

public class FeedbackDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<FeedbackBean> listOfFeedbackBeans;

	public ArrayList<FeedbackBean> getRegularFeedbackList() {
		listOfFeedbackBeans = new ArrayList<FeedbackBean>();
		conn = MysqlConnection.getConnection();
		FeedbackBean feedbackBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from feedback where date=curdate()");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				feedbackBeanObj = new FeedbackBean();
				feedbackBeanObj.setMember_id(rs.getInt("member_id"));
				feedbackBeanObj.setDate(rs.getString("date"));
				feedbackBeanObj.setFeedback(rs.getString("feedback"));
				feedbackBeanObj.setFeedback_id(rs.getInt("feedback_id"));
				listOfFeedbackBeans.add(feedbackBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfFeedbackBeans;
	}

	public boolean addFeedback(FeedbackBean feedbackBean) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("INSERT INTO FEEDBACK(MEMBER_ID,FEEDBACK,DATE) VALUES(?,?,CURDATE())");
			pstmt.setInt(1, feedbackBean.getMember_id());
			pstmt.setString(2, feedbackBean.getFeedback());

			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public ArrayList<FeedbackBean> getFeedbackList() {
		listOfFeedbackBeans = new ArrayList<FeedbackBean>();
		conn = MysqlConnection.getConnection();
		FeedbackBean feedbackBean = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM FEEDBACK");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				feedbackBean = new FeedbackBean();

				feedbackBean.setMember_id(rs.getInt("member_id"));
				feedbackBean.setDate(rs.getString("date"));
				feedbackBean.setFeedback_id(rs.getInt("feedback_id"));
				feedbackBean.setFeedback(rs.getString("feedback"));

				listOfFeedbackBeans.add(feedbackBean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfFeedbackBeans;
	}

	public FeedbackBean getFeedbackListByPK(int id) {
		conn = MysqlConnection.getConnection();
		FeedbackBean feedbackBean = null;
		try {
			pstmt = conn
					.prepareStatement("SELECT * FROM FEEDBACK WHERE FEEDBACK_ID=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				feedbackBean = new FeedbackBean();
				feedbackBean.setFeedback_id(id);
				feedbackBean.setMember_id(rs.getInt("member_id"));
				feedbackBean.setFeedback(rs.getString("feedback"));
				feedbackBean.setDate(rs.getString("date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return feedbackBean;
	}

	public boolean updateFeedback(FeedbackBean feedbackBean) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("UPDATE FEEDBACK SET MEMBER_ID=? , FEEDBACK=? , DATE=curdate() WHERE FEEDBACK_ID=?");
			pstmt.setInt(1, feedbackBean.getMember_id());
			pstmt.setString(2, feedbackBean.getFeedback());
			pstmt.setInt(3, feedbackBean.getFeedback_id());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean removeFeedback(int id) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("DELETE  FROM FEEDBACK WHERE FEEDBACK_ID=?");
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
		ArrayList<FeedbackBean> list = new FeedbackDAO().getRegularFeedbackList();
		System.out.println(list.size());
	}
}
