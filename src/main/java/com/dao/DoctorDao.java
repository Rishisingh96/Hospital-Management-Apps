package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Doctor;

public class DoctorDao {
	private Connection connection;

	public DoctorDao(Connection connection) {
		super();
		this.connection = connection;
	}

// For Add Doctor
	public boolean registerDoctor(Doctor d) {
		boolean f = false;
		try {
			String sql = "INSERT INTO doctor(fullName, dob, qualification, specialist, email, mobNo, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, d.getFullName());
			pStatement.setString(2, d.getDob());
			pStatement.setString(3, d.getQualification());
			pStatement.setString(4, d.getSpecialist());
			pStatement.setString(5, d.getEmail());
			pStatement.setString(6, d.getMobNo());
			pStatement.setString(7, d.getPassword());

			int i = pStatement.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}

	public List<Doctor> getAllDoctors() {
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d = null;
		try {
			String sql = " select * from doctor order by id desc";
			PreparedStatement pStatement = connection.prepareStatement(sql);

			ResultSet resultset = pStatement.executeQuery();
			while (resultset.next()) {
				d = new Doctor();
				d.setId(resultset.getInt(1));
				d.setFullName(resultset.getString(2));
				d.setDob(resultset.getString(3));
				d.setQualification(resultset.getString(4));
				d.setSpecialist(resultset.getString(5));
				d.setEmail(resultset.getString(6));
				d.setMobNo(resultset.getString(7));
				d.setPassword(resultset.getString(8));

				list.add(d);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

//For Update Doctor
	public boolean updateDoctor(Doctor d) {
		boolean f = false;
		try {
			String sql = "update doctor set fullName=?, dob=?, qualification=?, specialist=?, email=?, mobNo=?, password=? where id=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);

		
			pStatement.setString(1, d.getFullName());
			pStatement.setString(2, d.getDob());
			pStatement.setString(3, d.getQualification());
			pStatement.setString(4, d.getSpecialist());
			pStatement.setString(5, d.getEmail());
			pStatement.setString(6, d.getMobNo());
			pStatement.setString(7, d.getPassword());
			pStatement.setInt(8, d.getId());

			
			int i = pStatement.executeUpdate();

			if (i == 1) {
				f = true;
				System.out.println("Data Acess");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}

	public Doctor getDoctorsbyId(int id) {

		Doctor d = null;
		try {
			String sql = " select * from doctor where id=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			ResultSet resultset = pStatement.executeQuery();
			while (resultset.next()) {
				d = new Doctor();
				d.setId(resultset.getInt(1));
				d.setFullName(resultset.getString(2));
				d.setDob(resultset.getString(3));
				d.setQualification(resultset.getString(4));
				d.setSpecialist(resultset.getString(5));
				d.setEmail(resultset.getString(6));
				d.setMobNo(resultset.getString(7));
				d.setPassword(resultset.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return d;
	}
	
	//for Doctor Details Delete 
	public boolean deleteDoctor(int id) {
		boolean f = false;
		
		try {
			String sql = "delete from doctor where id=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			
			int i = pStatement.executeUpdate();
			if(i==1) {
				f = true;
				System.out.println("Data exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;	
	}
	
	//Doctor Login
	public Doctor doctorLogin(String email, String password ) {
		
		Doctor d = null;
		try {
			String sql= "select * from doctor where email=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				d = new Doctor();
				d.setId(resultset.getInt(1));
				d.setFullName(resultset.getString(2));
				d.setDob(resultset.getString(3));
				d.setQualification(resultset.getString(4));
				d.setSpecialist(resultset.getString(5));
				d.setEmail(resultset.getString(6));
				d.setMobNo(resultset.getString(7));
				d.setPassword(resultset.getString(8));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
		
	}
	public int countDoctor() {
		int i = 0;
		try {
			String sql = "select * from doctor";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countAppointment() {
		int i = 0;
		try {
			String sql = "select * from appointment";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countAppointmentByDocotrId(int did) {
		int i = 0;
		try {
			String sql = "select * from appointment where doctorId=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countUser() {
		int i = 0;
		try {
			String sql = "select * from user_dtls";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countSpecialist() {
		int i = 0;
		try {
			String sql = "select * from specialist";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public boolean checkOldPassword(int userid, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from doctor where id=? and password=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, oldPassword);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean changePassword(int userid, String newPassword) {
		boolean f = false;

		try {
			String sql = "update doctor set password=? where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean editDoctorProfile(Doctor d) {
		boolean f = false;

		try {
			String sql = "update doctor set fullName=?,dob=?,qualification=?,specialist=?,email=?,mobNo=? where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setInt(7, d.getId());
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

}
