package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XKeluargaModel;

@Repository
public interface XKeluargaRepo extends JpaRepository<XKeluargaModel, Long> {
	public List<XKeluargaModel> findByBiodataId(Long biodataId);
}
