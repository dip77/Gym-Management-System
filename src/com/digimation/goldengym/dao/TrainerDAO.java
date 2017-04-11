package com.digimation.goldengym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.digimation.goldengym.bean.MemberBean;
import com.digimation.goldengym.bean.TrainerBean;
import com.digimation.goldengym.util.MysqlConnection;
import com.digimation.goldengym.util.ValidateUtils;

public class TrainerDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<TrainerBean> listOfTrainerBeans;

	public boolean resetPassword(String pwd, String email) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("update  trainer set password=? where email=?");
			pstmt.setString(1, ValidateUtils.base64encode(pwd));
			pstmt.setString(2, email);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean resetPassword(TrainerBean trainerBean) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("update  trainer set password=? where trainer_id=?");
			pstmt.setString(1,
					ValidateUtils.base64encode(trainerBean.getPassword()));
			pstmt.setInt(2, trainerBean.getTrainerId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean isTrainerEmail(String email) {
		listOfTrainerBeans = new ArrayList<TrainerBean>();
		conn = MysqlConnection.getConnection();
		try {
			pstmt = conn.prepareStatement("select * from trainer "
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

	public TrainerBean isTrainer(String email, String password) {
		listOfTrainerBeans = new ArrayList<TrainerBean>();
		conn = MysqlConnection.getConnection();
		TrainerBean trainerBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from trainer "
					+ "where email=?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String pwd = rs.getString("password");
				if (ValidateUtils.base64decode(pwd).equals(password)) {
					trainerBeanObj = new TrainerBean();
					trainerBeanObj.setTrainerId(rs.getInt("trainer_id"));
					trainerBeanObj.setFirstName(rs.getString("first_name"));
					trainerBeanObj.setLastName(rs.getString("last_name"));
					trainerBeanObj.setEmail(rs.getString("email"));
					trainerBeanObj.setGender(rs.getString("gender"));
					trainerBeanObj.setCityId(rs.getInt("city_id"));
					trainerBeanObj.setIsActive(rs.getString("is_active"));
					trainerBeanObj.setExperiance(rs.getInt("experiance"));
					trainerBeanObj.setPhoto(rs.getString("photo"));

				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return trainerBeanObj;
	}

	public boolean addTrainer(TrainerBean trainerBeanObj) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("insert into trainer(first_name,last_name,"
							+ "password,email,gender,city_id,address,mobile,dob,experiance,on_active,photo) values(?,?,?,?,?,?,?,?,?,?,curdate(),?)");
			pstmt.setString(1, trainerBeanObj.getFirstName());
			pstmt.setString(2, trainerBeanObj.getLastName());
			pstmt.setString(3,
					ValidateUtils.base64encode(trainerBeanObj.getPassword()));
			pstmt.setString(4, trainerBeanObj.getEmail());
			pstmt.setString(5, trainerBeanObj.getGender());
			pstmt.setInt(6, trainerBeanObj.getCityId());
			pstmt.setString(7, trainerBeanObj.getAddress());
			pstmt.setString(8, trainerBeanObj.getMobile());
			pstmt.setString(9, trainerBeanObj.getDob());
			pstmt.setInt(10, trainerBeanObj.getExperiance());

			pstmt.setString(11, trainerBeanObj.getPhoto());

			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public ArrayList<TrainerBean> getTrainerList() {
		listOfTrainerBeans = new ArrayList<TrainerBean>();
		conn = MysqlConnection.getConnection();
		TrainerBean trainerBeanObj = null;
		try {
			pstmt = conn.prepareStatement("select * from trainer,city "
					+ "where trainer.city_id=city.city_id and is_active='y'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				trainerBeanObj = new TrainerBean();
				trainerBeanObj.setTrainerId(rs.getInt("trainer_id"));
				trainerBeanObj.setPassword(rs.getString("password"));
				trainerBeanObj.setFirstName(rs.getString("first_name"));
				trainerBeanObj.setLastName(rs.getString("last_name"));
				trainerBeanObj.setEmail(rs.getString("email"));
				trainerBeanObj.setGender(rs.getString("gender"));
				trainerBeanObj.setCity(rs.getString("city_name"));
				trainerBeanObj.setCityId(rs.getInt("city_id"));
				trainerBeanObj.setIsActive(rs.getString("is_active"));
				trainerBeanObj.setAddress(rs.getString("address"));
				trainerBeanObj.setDob(rs.getString("dob"));
				trainerBeanObj.setMobile(rs.getString("mobile"));
				trainerBeanObj.setExperiance(rs.getInt("experiance"));
				trainerBeanObj.setPhoto(rs.getString("photo"));
				listOfTrainerBeans.add(trainerBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfTrainerBeans;
	}

	public boolean removeTrainer(int trainerId) {
		conn = MysqlConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("update  trainer set is_active='n' where trainer_id=?");
			pstmt.setInt(1, trainerId);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public boolean updateTrainer(TrainerBean trainerBeanObj) {
		int i = 0;
		conn = MysqlConnection.getConnection();
		String sql = "update trainer set first_name=?,last_name=?,"
				+ "city_id=?,gender=?,address=?,mobile=?,dob=?,experiance=?"
				+ " where trainer_id=?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, trainerBeanObj.getFirstName());
			pstmt.setString(2, trainerBeanObj.getLastName());
			pstmt.setString(4, trainerBeanObj.getGender());
			pstmt.setInt(3, trainerBeanObj.getCityId());
			pstmt.setString(5, trainerBeanObj.getAddress());
			pstmt.setString(6, trainerBeanObj.getMobile());
			pstmt.setString(7, trainerBeanObj.getDob());
			pstmt.setInt(9, trainerBeanObj.getTrainerId());
			pstmt.setInt(8, trainerBeanObj.getExperiance());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println("firstName" + trainerBeanObj.getFirstName());
		System.out.println("lastName" + trainerBeanObj.getLastName());
		System.out.println("cityId" + trainerBeanObj.getCityId());
		System.out.println("city" + trainerBeanObj.getCity());
		System.out.println("mobile" + trainerBeanObj.getMobile());
		System.out.println("add" + trainerBeanObj.getAddress());
		System.out.println("gen" + trainerBeanObj.getGender());
		System.out.println("exp" + trainerBeanObj.getExperiance());
		System.out.println("trn id" + trainerBeanObj.getTrainerId());
		System.out.println("dob" + trainerBeanObj.getDob() + "\nupdate" + i);

		if (i == 0)
			return false;
		return true;
	}

	public TrainerBean getTrainerListByPK(int trainerId) {
		conn = MysqlConnection.getConnection();
		TrainerBean trainerBeanObj = null;
		try {
			pstmt = conn
					.prepareStatement("select * from trainer,city where trainer_id=? and trainer.city_id=city.city_id");
			pstmt.setInt(1, trainerId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				trainerBeanObj = new TrainerBean();
				trainerBeanObj.setTrainerId(rs.getInt("trainer_id"));
				trainerBeanObj.setFirstName(rs.getString("first_name"));
				trainerBeanObj.setLastName(rs.getString("last_name"));
				trainerBeanObj.setPassword(rs.getString("password"));
				trainerBeanObj.setEmail(rs.getString("email"));
				trainerBeanObj.setGender(rs.getString("gender"));
				trainerBeanObj.setCity(rs.getString("city_name"));
				trainerBeanObj.setCityId(rs.getInt("city_id"));
				trainerBeanObj.setIsActive(rs.getString("is_active"));
				trainerBeanObj.setAddress(rs.getString("address"));
				trainerBeanObj.setDob(rs.getString("dob"));
				trainerBeanObj.setMobile(rs.getString("mobile"));
				trainerBeanObj.setExperiance(rs.getInt("experiance"));
				trainerBeanObj.setPhoto(rs.getString("photo"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return trainerBeanObj;
	}

}
