package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.KecamatanModel;

@Repository
public interface KecamatanRepo extends JpaRepository<KecamatanModel, Long> {
	@Query(value = "select max(kdKecamatan) from KecamatanModel")
	public String getMaxKode();

	public List<KecamatanModel> findByKdKecamatan(String kode);

	public List<KecamatanModel> findByNmKecamatan(String nama);

	@Query(value = "SELECT k FROM KecamatanModel k WHERE LOWER(nmKecamatan) LIKE CONCAT('%',:nama,'%')")
	public List<KecamatanModel> search(@Param("nama") String nama);
}
