package com.xsis.batch197.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.KelurahanModel;

@Repository
public interface KelurahanRepo extends JpaRepository<KelurahanModel, Long> {
	@Query(value="select max(kdKelurahan) from KelurahanModel")
	public String getMaxKode();
}
