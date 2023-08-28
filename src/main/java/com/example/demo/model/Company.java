package com.example.demo.model;

import java.io.PrintStream;

import com.example.demo.dao.CompanyInt;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Company {
	
	@Id
	private int cid;
	
	private String name;
	private String email;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
