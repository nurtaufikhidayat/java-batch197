package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XKeteranganTambahanModel;
import com.xsis.batch197.model.XPeReferensiModel;

@Repository
public interface XPeReferensiRepo extends JpaRepository<XPeReferensiModel, Long> {

	public List<XPeReferensiModel> findByBiodataId(Long biodataId);

	// yang aktif
	@Query(value = "SELECT x FROM XPeReferensiModel x WHERE x.isDelete=0 and x.biodataId=:biodataId")
	public List<XPeReferensiModel> findActiveByBiodataId(@Param("biodataId") Long biodataId);

	// untuk mencari yang tidak aktif, atau sudah terhapus
	@Query(value = "SELECT x FROM XPeReferensiModel x WHERE x.isDelete=1 and x.biodataId=:biodataId")
	public List<XPeReferensiModel> findNonActiveByBiodataId(@Param("biodataId") Long biodataId);

}
