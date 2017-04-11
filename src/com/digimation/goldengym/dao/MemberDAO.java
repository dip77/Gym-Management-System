package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.goldengym.bean.AdminBean;
import com.digimation.goldengym.bean.MemberBean;
import com.digimation.goldengym.util.MysqlConnection;
import com.digimation.goldengym.util.ValidateUtils;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<MemberBean> listOfMemberBeans;

	public  boolean resetPassword(String pwd,String email)
	{
	conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("update  member set password=? where email=?");
			pstmt.setString(1, ValidateUtils.base64encode(pwd));
			pstmt.setString(2, email);
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
			return false;
	else 
		return true;
	}

	
	public boolean resetPassword(MemberBean memberBean) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("update  member set password=? where member_id=?");
			pstmt.setString(1,
					ValidateUtils.base64encode(memberBean.getPassword()));
			pstmt.setInt(2, memberBean.getMemberId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public ArrayList<MemberBean> getRegularMemberList() {
		listOfMemberBeans = new ArrayList<MemberBean>();
		conn = MysqlConnection.getConnection();
		MemberBean memberBeanObj = null;
		try {
			pstmt = conn
					.prepareStatement("select * from member"
							+ " where  is_active='y'" +
							" and on_active=curdate()");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberBeanObj = new MemberBean();
				memberBeanObj.setMemberId(rs.getInt("member_id"));
				memberBeanObj.setPassword(rs.getString("password"));
				memberBeanObj.setFirstName(rs.getString("first_name"));
				memberBeanObj.setLastName(rs.getString("last_name"));
				memberBeanObj.setEmail(rs.getString("email"));
				memberBeanObj.setGender(rs.getString("gender"));
				memberBeanObj.setIsActive(rs.getString("is_active"));
				memberBeanObj.setAddress(rs.getString("address"));
				memberBeanObj.setDob(rs.getString("dob"));
				memberBeanObj.setMobile(rs.getString("mobile"));
				memberBeanObj.setPhoto(rs.getString("photo"));
				listOfMemberBeans.add(memberBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfMemberBeans;
	}

	public boolean isMemberEmail(String email) {
		listOfMemberBeans = new ArrayList<MemberBean>();
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn.prepareStatement("select * from member "
					+ "where email=?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public MemberBean isMember(String email, String password) {
		listOfMemberBeans = new ArrayList<MemberBean>();
		conn = MysqlConnection.getConnection();
		MemberBean memberBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from member "
					+ "where email=?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String pwd = rs.getString("password");
				if (ValidateUtils.base64decode(pwd).equals(password)) {
					memberBeanObj = new MemberBean();
					memberBeanObj.setMemberId(rs.getInt(1));
					memberBeanObj.setAddress(rs.getString("address"));
					memberBeanObj.setCityId(rs.getInt("city_id"));
					memberBeanObj.setFirstName(rs.getString("first_name"));
					memberBeanObj.setLastName(rs.getString("last_name"));
					memberBeanObj.setEmail(rs.getString("email"));
					memberBeanObj.setGender(rs.getString("gender"));
					memberBeanObj.setDob(rs.getString("dob"));
					memberBeanObj.setCityId(rs.getInt("city_id"));
					memberBeanObj.setIsActive(rs.getString("is_active"));
					memberBeanObj.setPhoto(rs.getString("photo"));
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return memberBeanObj;
	}

	public boolean addMember(MemberBean memberBeanObj) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("insert into member(first_name,last_name,"
							+ "password,email,gender,city_id,address,mobile,dob,on_active,photo)" +
							" values(?,?,?,?,?,?,?,?,?,curdate(),?)");
			pstmt.setString(1, memberBeanObj.getFirstName());
			pstmt.setString(2, memberBeanObj.getLastName());
			pstmt.setString(3,
					ValidateUtils.base64encode(memberBeanObj.getPassword()));
			pstmt.setString(4, memberBeanObj.getEmail());
			pstmt.setString(5, memberBeanObj.getGender());
			pstmt.setInt(6, memberBeanObj.getCityId());
			pstmt.setString(7, memberBeanObj.getAddress());
			pstmt.setString(8, memberBeanObj.getMobile());
			pstmt.setString(9, memberBeanObj.getDob());
			pstmt.setString(10, memberBeanObj.getPhoto());
			
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public ArrayList<MemberBean> getMemberList() {
		listOfMemberBeans = new ArrayList<MemberBean>();
		conn = MysqlConnection.getConnection();
		MemberBean memberBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from member,city "
					+ "where member.city_id=city.city_id and is_active='y'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberBeanObj = new MemberBean();
				memberBeanObj.setMemberId(rs.getInt("member_id"));
				memberBeanObj.setPassword(rs.getString("password"));
				memberBeanObj.setFirstName(rs.getString("first_name"));
				memberBeanObj.setLastName(rs.getString("last_name"));
				memberBeanObj.setEmail(rs.getString("email"));
				memberBeanObj.setGender(rs.getString("gender"));
				memberBeanObj.setCity(rs.getString("city_name"));
				memberBeanObj.setCityId(rs.getInt("city_id"));
				memberBeanObj.setIsActive(rs.getString("is_active"));
				memberBeanObj.setAddress(rs.getString("address"));
				memberBeanObj.setDob(rs.getString("dob"));
				memberBeanObj.setMobile(rs.getString("mobile"));
				memberBeanObj.setPhoto(rs.getString("photo"));
				listOfMemberBeans.add(memberBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfMemberBeans;
	}

	public boolean removeMember(int memberId) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("update  member set is_active='n' where member_id=?");
			pstmt.setInt(1, memberId);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean updateMember(MemberBean memberBeanObj) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("update member set first_name=?,last_name=?,"
							+ "city_id=?,gender=?,address=?,mobile=?,dob=?"
							+ " where member_id=?");

			pstmt.setString(1, memberBeanObj.getFirstName());
			pstmt.setString(2, memberBeanObj.getLastName());
			pstmt.setString(4, memberBeanObj.getGender());
			pstmt.setInt(3, memberBeanObj.getCityId());
			pstmt.setString(5, memberBeanObj.getAddress());
			pstmt.setString(6, memberBeanObj.getMobile());
			pstmt.setString(7, memberBeanObj.getDob());
			pstmt.setInt(8, memberBeanObj.getMemberId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public MemberBean getMemberListByPK(int memberId) {
		conn = MysqlConnection.getConnection();
		MemberBean memberBeanObj = null;
		try {
			pstmt = conn
					.prepareStatement("select * from member,city where member_id=? and member.city_id=city.city_id");
			pstmt.setInt(1, memberId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberBeanObj = new MemberBean();
				memberBeanObj.setMemberId(rs.getInt("member_id"));
				memberBeanObj.setFirstName(rs.getString("first_name"));
				memberBeanObj.setLastName(rs.getString("last_name"));
				memberBeanObj.setPassword(rs.getString("password"));
				memberBeanObj.setEmail(rs.getString("email"));
				memberBeanObj.setGender(rs.getString("gender"));
				memberBeanObj.setCity(rs.getString("city_name"));
				memberBeanObj.setCityId(rs.getInt("city_id"));
				memberBeanObj.setIsActive(rs.getString("is_active"));
				memberBeanObj.setAddress(rs.getString("address"));
				memberBeanObj.setDob(rs.getString("dob"));
				memberBeanObj.setMobile(rs.getString("mobile"));
				memberBeanObj.setPhoto(rs.getString("photo"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return memberBeanObj;
	}

}
