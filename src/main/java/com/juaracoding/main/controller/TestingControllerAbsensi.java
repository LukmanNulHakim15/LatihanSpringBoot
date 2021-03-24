package com.juaracoding.main.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.main.model.Absensi;
import com.juaracoding.main.model.AbsensiRowMapper;
import com.juaracoding.main.model.Biodata;

@RestController 
@RequestMapping("/absensi")
public class TestingControllerAbsensi {
	
	@Autowired
	JdbcTemplate jdbc;
	
	public  List<Absensi> getAbsensi() {
		
		String sql = "Select * from Absensi";
		
		List<Absensi> absensi = jdbc.query(sql, new AbsensiRowMapper());
		
		return absensi;
		
		
	}
	
		
		public List<Absensi> getStart_date(String Start_date) {
			
			String sql = "select * from absensi where Start_date ='"+Start_date+"' ";
			
			List<Absensi> absensi = jdbc.query(sql, new AbsensiRowMapper());
			return absensi;
		} 
		
		
		public List<Absensi> getEnd_date( String End_date) {
			
			String sql = "select * from absensi where End_date ='"+End_date+"' ";
			
			List<Absensi> absensi = jdbc.query(sql, new AbsensiRowMapper());
			return absensi;
		}
	
	
	 public int insertAbsensi(Absensi absensi) {
		
		return jdbc.update("insert into absensi(id,nik,Start_date,Start_date) values ("+ absensi.getId() + ",'" + absensi.getNik() +"','" + absensi.getStart_date() + "','" + absensi.getStart_date() +"')");
		
	}
	
	
	public int updateAbsensi(String id, Absensi absensi) {
	
			return jdbc.update("UPDATE absensi SET `nik`=" + absensi.getNik() + ",`Start_date`='" + absensi.getStart_date()
					+ "',`Start_date`=" + absensi.getStart_date() + " WHERE id = '" + absensi.getId() + "'");

		
	}
	
	public int deleteAbsensi(String nik) {
		return jdbc.update("DELETE FROM `absensi` WHERE `nik` = '" + nik + "';");
		
		
	}
	
	 @PostMapping("/")
	    public String add(@RequestBody Absensi absensi) {
		 

			if (this.insertAbsensi(absensi) == 1) {
				return "Insert data berhasil";
			} else {
				return "Insert data gagal";
			} 
	    }
	 
	 
	 
	 @DeleteMapping("/{nik}")
	    public String delete(@PathVariable String nik) {
		 if (this.deleteAbsensi(nik) == 1) {
				return "Hapus Berhasil";
			} else {
				return "Hapus data gagal";
			} 
		 	
	 
	 }
	 
	 @GetMapping("/")
	    public List<Absensi> list() {
	        return getAbsensi();
	    }
	 
	 
	/* @GetMapping("/{nik}")
	 	public List<Absensi> cariNik (@PathVariable String nik ){
			return getNik(nik);	
			
	 } */
	 
	 
	 
	 @GetMapping("/{Start_date}")
	 	public List<Absensi> cariStart_date (@PathVariable String Start_date ){
			return getStart_date(Start_date);	
			
	 } 
	 
	 @GetMapping("/{End_date}")
	 	public List<Absensi> cariEnd_date (@PathVariable String End_date ){
			return getEnd_date(End_date);	
			
	 }
	 
	 
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<?> update(@RequestBody Absensi absensi, @PathVariable String id) {
		 try {
	            updateAbsensi(id, absensi);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
		 
	 }
	

	

}
