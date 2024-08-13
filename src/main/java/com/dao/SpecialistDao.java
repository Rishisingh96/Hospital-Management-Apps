package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Specalist;

public class SpecialistDao {
	private Connection connection;
	
	public SpecialistDao(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean addSpecialist(String spec) {
		
		boolean f = false;
		try {
			String sql = "insert into specialist(spec_name) value(?)";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, spec);
			
			int i = pStatement.executeUpdate();
			if(i == 1) {
				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return f;
	}
	
	public List<Specalist> getAllSpecalists(){
		List<Specalist> list = new ArrayList<Specalist>();
		Specalist specalist =null;
		try {
			String sql = "select * from specialist";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				specalist = new Specalist();
				specalist.setId(rs.getInt(1));
				specalist.setSpecialistName(rs.getString(2));
				list.add(specalist);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	
}
