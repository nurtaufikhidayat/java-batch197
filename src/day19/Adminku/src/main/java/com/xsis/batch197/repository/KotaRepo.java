package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.KotaModel;

@Repository
public interface KotaRepo extends JpaRepository<KotaModel, Long> {
	@Query(value="select max(kdKota) from KotaModel")
	public String getMaxKode();
	
	public List<KotaModel> findByKdKota(String kode);
	
	public List<KotaModel> findByNmKota(String nama);
	
	public List<KotaModel> findByProvinsiId(Long id);
	
	@Query(value="SELECT k FROM KotaModel k WHERE LOWER(nmKota) LIKE CONCAT('%',LOWER(:nama),'%')")
	public List<KotaModel> search(@Param("nama") String nama);
}
