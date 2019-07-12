package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.xsis.batch197.model.XSumberLokerModel;

@Repository
public interface XSumberLokerRepo extends JpaRepository<XSumberLokerModel, Long> {
	public List<XSumberLokerModel> findByBiodataId(Long biodataId);
}