package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XSertifikasiModel;

@Repository
public interface XSertifikasiRepo extends JpaRepository<XSertifikasiModel, Long>{
	public List<XSertifikasiModel> findByBiodataId(Long biodataId);
}
