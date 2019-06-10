package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.LookupModel;

@Repository
public interface LookupRepo extends JpaRepository<LookupModel, Long> {
	public List<LookupModel> findByKdLookup(String kode);

	public List<LookupModel> findByNmLookup(String nama);

	public List<LookupModel> findByType(String type);

	@Query(value = "SELECT l FROM LookupModel l WHERE LOWER(nmLookup) LIKE CONCAT('%',LOWER(:nama),'%')")
	public List<LookupModel> search(@Param("nama") String nama);
}
