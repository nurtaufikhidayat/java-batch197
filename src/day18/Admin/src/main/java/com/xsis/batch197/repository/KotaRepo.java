package com.xsis.batch197.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.KotaModel;

@Repository
public interface KotaRepo extends JpaRepository<KotaModel, Long> {
	@Query(value="select max(kdKota) from KotaModel")
	public String getMaxKode();
}
