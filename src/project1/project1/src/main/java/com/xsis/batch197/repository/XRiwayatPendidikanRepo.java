package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XRiwayatPendidikanModel;

@Repository
public interface XRiwayatPendidikanRepo extends JpaRepository<XRiwayatPendidikanModel, Long>{
	
	@Query("select rp from XRiwayatPendidikanModel rp where LOWER(rp.major) LIKE CONCAT('%',LOWER(:major),'%')")
	public List<XRiwayatPendidikanModel> search(@Param("major") String major);
}
