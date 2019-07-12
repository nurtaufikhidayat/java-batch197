package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XKeluargaModel;

@Repository
public interface XKeluargaRepo extends JpaRepository<XKeluargaModel, Long> {

	public List<XKeluargaModel> findByBiodataId(Long biodataId);

	// yang aktif
	@Query(value = "SELECT x FROM XKeluargaModel x WHERE x.isDelete=0 and x.biodataId=:biodataId")
	public List<XKeluargaModel> findActiveByBiodataId(@Param("biodataId") Long biodataId);

	// untuk mencari yang tidak aktif, atau sudah terhapus
	@Query(value = "SELECT x FROM XKeluargaModel x WHERE x.isDelete=1 and x.biodataId=:biodataId")
	public List<XKeluargaModel> findNonActiveByBiodataId(@Param("biodataId") Long biodataId);
}
