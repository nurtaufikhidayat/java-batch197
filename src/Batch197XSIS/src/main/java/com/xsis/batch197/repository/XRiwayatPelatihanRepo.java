package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XRiwayatPelatihanModel;

@Repository
public interface XRiwayatPelatihanRepo extends JpaRepository<XRiwayatPelatihanModel, Long>{
	// yang aktif
	@Query(value="SELECT x FROM XRiwayatPelatihanModel x WHERE x.isDelete=0 and x.biodataId=:biodataId")
	public List<XRiwayatPelatihanModel> findActiveByBiodataId(@Param("biodataId") Long biodataId);
	
	@Query(value="SELECT x FROM XRiwayatPelatihanModel x WHERE x.isDelete=1 and x.biodataId=:biodataId")
	public List<XRiwayatPelatihanModel> findNonActiveByBiodataId(@Param("biodataId") Long biodataId);
}