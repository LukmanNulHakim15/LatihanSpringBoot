package com.juaracoding.main.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.main.model.BonusRowMapper;

import com.juaracoding.main.model.TitleRowMapper;
import com.juaracoding.main.model.UjianKetigaBonus;
import com.juaracoding.main.model.UjianKetigaTitle;
import com.juaracoding.main.model.UjianKetigaWorker;
import com.juaracoding.main.model.WorkerRowMapper;

@RestController
@RequestMapping ("/ujian")
public class UjianKetigaController {
	
	@Autowired
	JdbcTemplate jdbc;
	//===================================================================
	public List<UjianKetigaWorker> getUjianKetigaWorker() {

		String sql = "Select * from karyawan";

		List<UjianKetigaWorker> worker = jdbc.query(sql, new WorkerRowMapper());

		return worker;

	} 
	
	 @GetMapping("/{karyawan}")
	    public List<UjianKetigaWorker> list() {
	        return getUjianKetigaWorker();
	    } 
	 
	 public List<UjianKetigaWorker> getSalaryDuplikasi(int salary) {

			String sql =( "  SELECT salary  FROM karyawan GROUP BY 'salary' HAVING count(*) > 1 = " + salary + ";");

			List<UjianKetigaWorker> worker = jdbc.query(sql, new WorkerRowMapper());

			return worker;

		} 
	 
	 
	 @GetMapping("/{karyawan}/{duplikasi}")
	    public List<UjianKetigaWorker> listDuplikasi() {
	        return getUjianKetigaWorker();
	    }
	 
	 public List<UjianKetigaWorker> departement(String departement) {

			String sql =( "  select count(departement) from karyawan; = '" + departement + "';");

			List<UjianKetigaWorker> worker = jdbc.query(sql, new WorkerRowMapper());

			return worker;

		} 
	 
	 
	 @GetMapping("/{karyawan}/{departement}")
	    public List<UjianKetigaWorker> listdepartement() {
	        return getUjianKetigaWorker();
	    } 


	
	 public int insertWorker(UjianKetigaWorker worker) {
			
			return jdbc.update("insert into karyawan(worker_id,first_name,last_name,salary,joining_date,departement) values ("+ worker.getWorker_id()+ ",'" + worker.getFirst_name() +"','" 
								+ worker.getLast_name() + "'," + worker.getSalary() +",'" + worker.getJoining_date() +"','" + worker.getDepartement() +"')");
			
		}
	
	 @PostMapping("/{karyawan}/{insert}")
	    public String add(@RequestBody UjianKetigaWorker worker) {
		 

			if (this.insertWorker(worker) == 1) {
				return "Insert data berhasil";
			} else {
				return "Insert data gagal";
			} 
	    } 
	
		
		public int updateWorker(int worker_id, UjianKetigaWorker worker) {
		
			return jdbc.update("UPDATE karyawan SET `worker_id`= "+ worker.getWorker_id() + ",`first_name`='" + worker.getFirst_name()+ "',"
					+ "`last_name`='" + worker.getLast_name() + ",'salary'="+worker.getSalary()+",'joining_date'='"+worker.getJoining_date()+"','departement'='"+worker.getDepartement()+"'");
		}
 
		
		 @PutMapping("/{karyawan}/{update}")
		    public ResponseEntity<?> update(@RequestBody UjianKetigaWorker worker, @PathVariable int worker_id) {
			 try {
		            updateWorker(worker_id, worker);
		            return new ResponseEntity<>(HttpStatus.OK);
		        } catch (NoSuchElementException e) {
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		        }
			 
		 }
		 
		 
		 public int deleteTitle(int worker_id) {
	
			 	return jdbc.update("DELETE FROM `karyawan` WHERE `worker_id` = '" + worker_id + "';");

 }

	//===================================================================
	
	
	/* public List<UjianKetigaTitle> getUjianKetigaTitle() {

		String sql = "Select * from title";

		List<UjianKetigaTitle> title = jdbc.query(sql, new TitleRowMapper());

		return title;

	} 
	 
		/* @GetMapping("/{title}")
	    public List<UjianKetigaTitle> listTitle() {
	        return getUjianKetigaTitle();
	    } 
	 
	 public int insertTitle(UjianKetigaTitle title) {
			
			return jdbc.update("insert into title (worker_ref_id,worker_title,effective_from) values ("+ title.getWorker_ref_id()+ ",'" + title.getWorker_title() +"','" 
								+ title.getEffective_from()+"')");
			
		}
	 
	  
	 
	 @PostMapping("/{title}/{insert}")
	    public String add(@RequestBody UjianKetigaTitle title) {
		 

			if (this.insertTitle(title) == 1) {
				return "Insert data berhasil";
			} else {
				return "Insert data gagal";
			} 
	    } 
	 
		
	public int updateTitle(int worker_ref_id, UjianKetigaTitle title) {
		
		return jdbc.update("UPDATE title SET `worker_ref_id`= "+ title.getWorker_ref_id() + ",`worker_title`='" + title.getWorker_title()+ "',`effective_from`='" + title.getEffective_from() + "'");
	}
 
		
		 @PutMapping("/{title}/{update}")
		    public ResponseEntity<?> update(@RequestBody UjianKetigaTitle title, @PathVariable int worker_ref_id) {
			 try {
		            updateTitle(worker_ref_id, title);
		            return new ResponseEntity<>(HttpStatus.OK);
		        } catch (NoSuchElementException e) {
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		        }
			 
		 }
		 
		 
		 public int deleteTitle(int worker_ref_id) {
	
			 	return jdbc.update("DELETE FROM `bonus` WHERE `worker_ref_id` = '" + worker_ref_id + "';");

 } */

 
	
	//===================================================================
	
	/*public List<UjianKetigaBonus> getUjianKetigaBonus() {

		String sql = "Select * from bonus";

		List<UjianKetigaBonus> bonus = jdbc.query(sql, new BonusRowMapper());

		return bonus;

	}
	
	
	 @GetMapping("/{bonus}")
	    public List<UjianKetigaBonus> listBonus() {
	        return getUjianKetigaBonus();
	    } 
	
	 public int insertBonus(UjianKetigaBonus bonus) {
			
			return jdbc.update("insert into bonus(worker_ref_id,bonus_date,bonus_amount) values ("+ bonus.getWorker_ref_id()+ ",'" + bonus.getBonus_date() +"'," 
								+ bonus.getBonus_amount() + ")");
			
		}
	 
	 
	 @PostMapping("/{bonus}/{insert}")
	    public String add(@RequestBody UjianKetigaBonus bonus) {
		 

			if (this.insertBonus(bonus) == 1) {
				return "Insert data berhasil";
			} else {
				return "Insert data gagal";
			} 
	    }
	 
	 public int updateBonus(int worker_ref_id, UjianKetigaBonus bonus) {
			
			return jdbc.update("UPDATE bonus SET `worker_ref_id`= "+ bonus.getWorker_ref_id() + ",`bonus_date`='" + bonus.getBonus_date()
					+ "',`bonus_amount`=" + bonus.getBonus_amount() + "");
	 }
	 
			
			 @PutMapping("/{bonus}/{update}")
			    public ResponseEntity<?> update(@RequestBody UjianKetigaBonus bonus, @PathVariable int worker_ref_id) {
				 try {
			            updateBonus(worker_ref_id, bonus);
			            return new ResponseEntity<>(HttpStatus.OK);
			        } catch (NoSuchElementException e) {
			            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			        }
				 
			 }
			 
			 
	 public int deleteBonus(int worker_ref_id) {
		
		 return jdbc.update("DELETE FROM `bonus` WHERE `worker_ref_id` = '" + worker_ref_id + "';");
	
	 } */

	 
	 
	//====================================================================
	
	
	
	
	//====================================================================
	
	
	
	
	//===================================================================
	 

	 
	 //==================================================================
	 
	 
	 
	 
	 
	//=======================================================================
	 
	
	 
	 //==================================================================
	 
	 
	
	 
	 
	//=======================================================================
	 

}
