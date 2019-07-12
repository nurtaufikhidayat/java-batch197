package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XSertifikasiModel;

@Repository
public interface XSertifikasiRepo extends JpaRepository<XSertifikasiModel, Long>{
	public List<XSertifikasiModel> findByBiodataId(Long biodataId);
	// yang aktif
	@Query(value="SELECT x FROM XSertifikasiModel x WHERE x.isDelete=0 and x.biodataId=:bid")
	public List<XSertifikasiModel> findAllActive(@Param("bid") Long bid);
	
	// untuk mencari yang tidak aktif, atau sudah terhapus
	@Query(value="SELECT x FROM XSertifikasiModel x WHERE x.isDelete=1 and x.biodataId=:bid")
	public List<XSertifikasiModel> findAllNonActive(@Param("bid") Long bid);
}
