package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XKeahlianModel;

@Repository
public interface XKeahlianRepo extends JpaRepository<XKeahlianModel, Long>{
	public List<XKeahlianModel> findByBiodataId(Long biodataId);
	
	//yang aktif
	@Query(value = "SELECT x FROM XKeahlianModel x WHERE x.isDelete=0")
	public List<XKeahlianModel> findAllActive();
	
	// untuk mencari yang tidak aktif, atau sudah terhapus
	@Query(value="SELECT x FROM XKeahlianModel x WHERE x.isDelete=1")
	public List<XKeahlianModel> findAllNonActive();
}
