package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xsis.batch197.model.BiodataModel;

public interface BiodataRepo extends JpaRepository<BiodataModel, Long> {
	public List<BiodataModel> findByNik(String nik);

	@Query(value = "SELECT b FROM BiodataModel b WHERE LOWER(nik) LIKE CONCAT('%',LOWER(:nama),'%')")
	public List<BiodataModel> search(@Param("nama") String nama);
}
