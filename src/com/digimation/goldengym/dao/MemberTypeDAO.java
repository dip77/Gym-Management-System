package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.digimation.goldengym.bean.MemberTypeBean;
import com.digimation.goldengym.util.MysqlConnection;



public class MemberTypeDAO {


		private Connection conn = null;
		private PreparedStatement pstmt =null;
		private ResultSet rs = null;
		
		boolean result = false;
		public boolean insert(MemberTypeBean memberTypeBean){
			
			conn=MysqlConnection.getConnection();	
				
			 if(conn!=null){
				 String insertSQL = "INSERT INTO member_type(member_type_name) values(?)";
				 
				 try {
					pstmt = conn.prepareStatement(insertSQL);
					
					pstmt.setString(1,memberTypeBean.getMemberType());
					
					int rowsAffected = pstmt.executeUpdate();
					
					if (rowsAffected > 0) {
						result=true;

					} else {

					}
				 } catch (SQLException e) {
					e.printStackTrace();
				}finally{
				
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				 
			 }
			
			return result;
		}
		
		

		public List<MemberTypeBean> list(){
			
			List<MemberTypeBean> listOfMemberType = new ArrayList<MemberTypeBean>();
			 conn=MysqlConnection.getConnection();	
				
			 if(conn!=null){
				 String selectSQL = "Select * from member_type order by member_type_id";
				 try {
					pstmt = conn.prepareStatement(selectSQL);
				
					rs = pstmt.executeQuery();

					MemberTypeBean member_type = null;
					while(rs.next()){
						member_type = new MemberTypeBean();
					
						member_type.setMemberTypeId(rs.getInt("member_type_id"));
						member_type.setMemberType(rs.getString("member_type_name"));
										
						listOfMemberType.add(member_type);
					}
					
					
				 } catch (SQLException e) {
					e.printStackTrace();
				}
				 
				 
			 }
			System.out.println("Size : "+listOfMemberType.size());
			return listOfMemberType;
		}

		
		public boolean delete(int member_type_id) {
			 
			 conn=MysqlConnection.getConnection();	
				
			 if(conn!=null){
				 String deleteSQL = "DELETE FROM member_type WHERE member_type_id=?";
				 
				 try {
					pstmt = conn.prepareStatement(deleteSQL);
					
					pstmt.setInt(1,member_type_id);
				
					int rowsAffected = pstmt.executeUpdate();
					
					if (rowsAffected > 0) {
						result=true;

					} else {

					}
				 } catch (SQLException e) {
					e.printStackTrace();
				}
				 
			 }
			 return result;
		}
		
		public MemberTypeBean getByPK(int member_type_id) {
			
			 conn=MysqlConnection.getConnection();	
			 MemberTypeBean member_type =new MemberTypeBean();
			 
			 if(conn!=null){
				 String selectSQL = "Select * from member_type WHERE member_type_id=?";
				 try {
					pstmt = conn.prepareStatement(selectSQL);
				
					pstmt.setInt(1, member_type_id);
					
					rs = pstmt.executeQuery();

					
					while(rs.next()){
						 
						member_type.setMemberTypeId(rs.getInt("member_type_id"));
						member_type.setMemberType(rs.getString("member_type_name"));
						
						
					
					}
					
					
				 } catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return member_type;
		}
		
		public boolean update(MemberTypeBean memberTypeBean) {
			 conn=MysqlConnection.getConnection();	
				
			 if(conn!=null){
				 String updateSQL = "UPDATE member_type set member_type_name=? WHERE member_type_id=?";
				 
				 try {
					pstmt = conn.prepareStatement(updateSQL);
					
					pstmt.setString(1,memberTypeBean.getMemberType());
					pstmt.setInt(2,memberTypeBean.getMemberTypeId());
					
					
					int rowsAffected = pstmt.executeUpdate();
					
					if (rowsAffected > 0) {
						result=true;
					} else {
						System.out.println(rowsAffected + " Row(s) Inserted......");
					}
				 } catch (SQLException e) {
					e.printStackTrace();
				}
				 
			 }
			 return result;
		}

}
