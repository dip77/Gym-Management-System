package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.digimation.goldengym.bean.AdminBean;
import com.digimation.goldengym.util.MysqlConnection;
import com.digimation.goldengym.util.ValidateUtils;


public class AdminDAO {
	private  Connection conn; 
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<AdminBean> listOfAdminBeans;
	public  boolean resetPassword(String pwd,String email)
	{
	conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("update  admin set password=? where email=?");
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

	public  boolean resetPassword(AdminBean adminBean)
	{
	conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("update  admin set password=? where admin_id=?");
			pstmt.setString(1, ValidateUtils.base64encode(adminBean.getPassword()));
			pstmt.setInt(2, adminBean.getAdminId());
			 i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
			return false;
	else 
		return true;
	}

	public  boolean isAdminEmail(String email)
	{
		listOfAdminBeans=new ArrayList<AdminBean>();
	conn=MysqlConnection.getConnection();
			try {
				pstmt=conn.prepareStatement("select * from admin "+
						"where email=?");
				pstmt.setString(1, email);
				rs=pstmt.executeQuery();
				 if (rs.next()) {
						return true;
						 
					}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

		return false;
	}


	
	public  AdminBean isAdmin(String email,String password)
	{
		listOfAdminBeans=new ArrayList<AdminBean>();
	conn=MysqlConnection.getConnection();
		AdminBean adminBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from admin "+
					"where email=?");
			pstmt.setString(1, email);
			rs=pstmt.executeQuery();

			 if (rs.next()) {
					String pwd=rs.getString("password");
					if(ValidateUtils.base64decode(pwd).equals(password))
					{
						adminBeanObj=new AdminBean();
					adminBeanObj.setAdminId(rs.getInt("admin_id"));
					adminBeanObj.setFirstName(rs.getString("first_name"));
					adminBeanObj.setLastName(rs.getString("last_name"));
				    adminBeanObj.setEmail(rs.getString("email"));
				    adminBeanObj.setGender(rs.getString("gender"));
				    adminBeanObj.setCityId(rs.getInt("city_id"));
				    adminBeanObj.setIsActive(rs.getString("is_active"));
					}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return adminBeanObj;
	}

	
	public  boolean addAdmin(AdminBean adminBeanObj) {
		conn=MysqlConnection.getConnection();
		int i=0;
		try {
			pstmt=conn.prepareStatement("insert into admin(first_name,last_name," +
					"password,email,gender,city_id) values(?,?,?,?,?,?)");
			pstmt.setString(1, adminBeanObj.getFirstName());
			pstmt.setString(2, adminBeanObj.getLastName());
			pstmt.setString(3, adminBeanObj.getPassword());
			pstmt.setString(4, adminBeanObj.getEmail());
			pstmt.setString(5, adminBeanObj.getGender());
			pstmt.setInt(6, adminBeanObj.getCityId());
			i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(i==0)
				return false;
		else 
			return true;
	

		
	}

public  ArrayList<AdminBean> getAdminList()
	{
		listOfAdminBeans=new ArrayList<AdminBean>();
	conn=MysqlConnection.getConnection();
		AdminBean adminBeanObj=null;
		try {
			pstmt=conn.prepareStatement("select * from admin,city "+
					"where admin.city_id=city.city_id and is_active='y'");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				 adminBeanObj=new AdminBean();
					adminBeanObj.setAdminId(rs.getInt("admin_id"));
					adminBeanObj.setFirstName(rs.getString("first_name"));
					adminBeanObj.setLastName(rs.getString("last_name"));
				    adminBeanObj.setEmail(rs.getString("email"));
				    adminBeanObj.setGender(rs.getString("gender"));
				    adminBeanObj.setCity(rs.getString("city_name"));
				    adminBeanObj.setCityId(rs.getInt("city_id"));
				    adminBeanObj.setIsActive(rs.getString("is_active"));
				    listOfAdminBeans.add(adminBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfAdminBeans;
	}

public  boolean removeAdmin(int adminId)
{
conn=MysqlConnection.getConnection();
	int i=0;
	try {
		pstmt=conn.prepareStatement("update  admin set is_active='n' where admin_id=?");
		pstmt.setInt(1, adminId);
		 i=pstmt.executeUpdate();
	} catch (SQLException e) {

		e.printStackTrace();
	}
	if(i==0)
		return false;
else 
	return true;
}

public  boolean updateAdmin(AdminBean adminBeanObj)
	{
	 	int i=0;
		conn=MysqlConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("update admin set first_name=?,last_name=?," +
					"city_id=?,email=?,gender=?"
					+" where admin_id=?");

			pstmt.setString(1, adminBeanObj.getFirstName());
			pstmt.setString(2, adminBeanObj.getLastName());
			pstmt.setString(4, adminBeanObj.getEmail());
			pstmt.setString(5, adminBeanObj.getGender());
			pstmt.setInt(3, adminBeanObj.getCityId());
			pstmt.setInt(6, adminBeanObj.getAdminId());
				i=pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
if(i==0)
		return false;
else
	return true;
	}


public  AdminBean getAdminListByPK(int adminId)
{
    conn=MysqlConnection.getConnection();
	AdminBean adminBeanObj=null;
	try {
		pstmt=conn.prepareStatement("select * from admin,city where  admin.city_id=city.city_id and admin_id=?");
		pstmt.setInt(1, adminId);
		rs=pstmt.executeQuery();
		
		 if (rs.next()) {
			adminBeanObj=new AdminBean();
			adminBeanObj.setAdminId(adminId);
			adminBeanObj.setFirstName(rs.getString("first_name"));
			adminBeanObj.setLastName(rs.getString("last_name"));
		    adminBeanObj.setEmail(rs.getString("email"));
		    adminBeanObj.setGender(rs.getString("gender"));
		    adminBeanObj.setCity(rs.getString("city_name"));
		    adminBeanObj.setCityId(rs.getInt("city_id"));
		    adminBeanObj.setPassword(rs.getString("password"));
		    adminBeanObj.setIsActive(rs.getString("is_active"));
		 }
	} catch (SQLException e) {

		e.printStackTrace();
	}

	return adminBeanObj;
}

public static void main(String[] args) {
	SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
	String sr=s.format(new Date());
	System.out.println(sr+"s");

}
}
