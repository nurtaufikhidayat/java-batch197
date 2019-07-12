package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XRiwayatPekerjaanModel;

@Repository
public interface XRiwayatPekerjaanRepo extends JpaRepository<XRiwayatPekerjaanModel, Long>{
	public List<XRiwayatPekerjaanModel> findByBiodataId(Long biodataId);
}
