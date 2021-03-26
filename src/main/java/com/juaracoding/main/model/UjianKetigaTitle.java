package com.juaracoding.main.model;

public class UjianKetigaTitle {
	
	private int worker_ref_id;
	private String worker_title;
	private String effective_from;
	
	public UjianKetigaTitle () {
		
	}
	
	public UjianKetigaTitle(int worker_ref_id, String worker_title, String effective_from) {
		super();
		this.worker_ref_id = worker_ref_id;
		this.worker_title = worker_title;
		this.effective_from = effective_from;
	}
	
	
	public int getWorker_ref_id() {
		return worker_ref_id;
	}
	public void setWorker_ref_id(int worker_ref_id) {
		this.worker_ref_id = worker_ref_id;
	}
	public String getWorker_title() {
		return worker_title;
	}
	public void setWorker_title(String worker_title) {
		this.worker_title = worker_title;
	}
	public String getEffective_from() {
		return effective_from;
	}
	public void setEffective_from(String effective_from) {
		this.effective_from = effective_from;
	}
	
	

}
