package com.xsis.batch197.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.KecamatanModel;

@Repository
public interface KecamatanRepo extends JpaRepository<KecamatanModel, Long> {
	@Query(value="select max(kdKecamatan) from KecamatanModel")
	public String getMaxKode();
	
}
