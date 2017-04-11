package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.goldengym.bean.PackageDetailBean;
import com.digimation.goldengym.util.MysqlConnection;

public class PackageDetailDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<PackageDetailBean> listOfPackageDetailBeans;
		
	public boolean addPackage(PackageDetailBean package_detailBeanObj) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			
			pstmt = conn.prepareStatement("insert into package_detail(package_id,activity_id,amount," +
					"member_type_id) values(?,?,?,?)");
			pstmt.setInt(1, package_detailBeanObj.getPackageId());
			pstmt.setInt(2, package_detailBeanObj.getActivityId());
			pstmt.setInt(3, package_detailBeanObj.getAmount());
			pstmt.setInt(4, package_detailBeanObj.getMemberTypeId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public ArrayList<PackageDetailBean> getPackageList() {
		listOfPackageDetailBeans = new ArrayList<PackageDetailBean>();
		conn = MysqlConnection.getConnection();
		PackageDetailBean package_detailBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from package_detail pd,package p,activity a," +
					"member_type mt where mt.member_type_id=pd.member_type_id and a.activity_id=" +
					"pd.activity_id and p.package_id=pd.package_id ");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				package_detailBeanObj = new PackageDetailBean();
				package_detailBeanObj.setPackageId(rs.getInt("package_id"));
				package_detailBeanObj.setPackageDetailId(rs.getInt("package_detail_id"));
				package_detailBeanObj.setMemberType(rs.getString("member_type_name"));
				package_detailBeanObj.setMemberTypeId(rs.getInt("member_type_id"));
				package_detailBeanObj.setPackageName(rs.getString("package_name"));
				package_detailBeanObj.setActivity(rs.getString("activity"));
				package_detailBeanObj.setActivityId(rs.getInt("activity_id"));
				package_detailBeanObj.setAmount(rs.getInt("amount"));
				package_detailBeanObj.setDuration(rs.getInt("duration"));
				listOfPackageDetailBeans.add(package_detailBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfPackageDetailBeans;
	}

	public PackageDetailBean getPackageListByPK(int id) {
		conn = MysqlConnection.getConnection();
		PackageDetailBean package_detailBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from package_detail pd,package p,activity a" +
					",member_type mt where pd.package_detail_id=? and mt.member_type_id=pd.member_type_id" +
					" and pd.activity_id=a.activity_id and p.package_id=pd.package_id ");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				package_detailBeanObj = new PackageDetailBean();
				package_detailBeanObj.setPackageId(rs.getInt("package_id"));
				package_detailBeanObj.setPackageDetailId(id);
				package_detailBeanObj.setMemberType(rs.getString("member_type_name"));
				package_detailBeanObj.setMemberTypeId(rs.getInt("member_type_id"));
				package_detailBeanObj.setPackageName(rs.getString("package_name"));
				package_detailBeanObj.setActivity(rs.getString("activity"));
				package_detailBeanObj.setActivityId(rs.getInt("activity_id"));
				package_detailBeanObj.setAmount(rs.getInt("amount"));
				package_detailBeanObj.setDuration(rs.getInt("duration"));
							
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return package_detailBeanObj;
	}

	public boolean updatePackage(PackageDetailBean package_detailBeanObj) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn.prepareStatement("update package_detail set package_id=?," +
					"amount=?,activity_id=?,member_type_id=? where package_detail_id=?");
			pstmt.setInt(1, package_detailBeanObj.getPackageId());
			pstmt.setInt(2, package_detailBeanObj.getAmount());
			pstmt.setInt(3, package_detailBeanObj.getActivityId());
			pstmt.setInt(4, package_detailBeanObj.getMemberTypeId());
			pstmt.setInt(5, package_detailBeanObj.getPackageDetailId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean removePackage(int id) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn.prepareStatement("delete  from package_detail where package_detail_id=?");
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
