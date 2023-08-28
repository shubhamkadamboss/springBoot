package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Company;

@Repository
public interface CompanyInt extends CrudRepository<Company, Integer> {
}
