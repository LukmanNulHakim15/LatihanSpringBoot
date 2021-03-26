package com.juaracoding.main.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class WorkerRowMapper implements RowMapper <UjianKetigaWorker>{

	@Override
	public UjianKetigaWorker mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new UjianKetigaWorker(rs.getInt("worker_id"), rs.getString("first_name"),rs.getString("last_name"),
									rs.getInt("salary"), rs.getString("joining_date"),rs.getString("departement"));
	}

	
	
	
}
