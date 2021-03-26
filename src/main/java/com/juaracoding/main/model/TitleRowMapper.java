package com.juaracoding.main.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TitleRowMapper implements RowMapper <UjianKetigaTitle>{

	@Override
	public UjianKetigaTitle mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new UjianKetigaTitle(rs.getInt("worker_ref_id"), rs.getString("worker_title"),rs.getString("effective_from"));
	}

	
}
