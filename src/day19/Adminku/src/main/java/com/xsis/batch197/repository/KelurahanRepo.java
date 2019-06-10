package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.KelurahanModel;

@Repository
public interface KelurahanRepo extends JpaRepository<KelurahanModel, Long> {
	@Query(value = "select max(kdKelurahan) from KelurahanModel")
	public String getMaxKode();

	public List<KelurahanModel> findByKdKelurahan(String kode);

	public List<KelurahanModel> findByNmKelurahan(String nama);

	@Query(value = "SELECT k FROM KelurahanModel k WHERE LOWER(nmKelurahan) LIKE CONCAT('%',LOWER(:nama),'%')")
	public List<KelurahanModel> search(@Param("nama")String nama);
}
