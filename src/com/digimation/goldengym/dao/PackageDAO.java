package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.goldengym.bean.PackageBean;
import com.digimation.goldengym.util.MysqlConnection;

public class PackageDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<PackageBean> listOfPackageBeans;

	public boolean isPackageExists(String packageName)
	{
		try {
			conn=com.digimation.goldengym.util.MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select package_id from package where package_name=?");
				pstmt.setString(1, packageName);
				 rs=pstmt.executeQuery();
				 if(rs.next())
				 return true; 
					 
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return false;

	}



	public int getPackageID(String packageName)
	{
		try {
			conn=com.digimation.goldengym.util.MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select package_id from package where package_name=?");
				pstmt.setString(1, packageName);
				 rs=pstmt.executeQuery();
				 if(rs.next())
				 return rs.getInt("package_id"); 
					 
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return -1;

	}


		
	public boolean addPackage(PackageBean packageBeanObj) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("insert into package(package_name,duration) values(?,?)");
			pstmt.setString(1, packageBeanObj.getPackageName());
			pstmt.setInt(2, packageBeanObj.getDuration());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public ArrayList<PackageBean> getPackageList() {
		listOfPackageBeans = new ArrayList<PackageBean>();
		conn = MysqlConnection.getConnection();
		PackageBean packageBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from package");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				packageBeanObj = new PackageBean();
				packageBeanObj.setPackageId(rs.getInt("package_id"));
				packageBeanObj.setPackageName(rs.getString("package_name"));
				packageBeanObj.setDuration(rs.getInt("duration"));
				listOfPackageBeans.add(packageBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfPackageBeans;
	}

	public PackageBean getPackageListByPK(int id) {
		conn = MysqlConnection.getConnection();
		PackageBean packageBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from package where package_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				packageBeanObj = new PackageBean();
				packageBeanObj.setPackageId(id);
				packageBeanObj.setPackageName(rs.getString("package_name"));
				packageBeanObj.setDuration(rs.getInt("duration"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return packageBeanObj;
	}

	public boolean updatePackage(PackageBean packageBeanObj) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("update package set package_name=?,duration=? where package_id=?");
			pstmt.setString(1, packageBeanObj.getPackageName());
			pstmt.setInt(2, packageBeanObj.getDuration());
			pstmt.setInt(3, packageBeanObj.getPackageId());
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
			pstmt = conn.prepareStatement("delete  from package where package_id=?");
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
