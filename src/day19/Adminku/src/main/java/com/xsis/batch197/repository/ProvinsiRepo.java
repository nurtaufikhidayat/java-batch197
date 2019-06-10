package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.ProvinsiModel;

@Repository
public interface ProvinsiRepo extends JpaRepository<ProvinsiModel, Long>{
	@Query(value="select max(kdProvinsi) from ProvinsiModel")
	public String getMaxKode();
	public List<ProvinsiModel> findByNmProvinsi(String nama);
	public List<ProvinsiModel> findByKdProvinsi(String kode);
	
	@Query(value="SELECT p FROM ProvinsiModel p WHERE LOWER(p.nmProvinsi) LIKE CONCAT('%', LOWER(:nama),'%')")
	public List<ProvinsiModel> search(@Param("nama") String nama);
}
