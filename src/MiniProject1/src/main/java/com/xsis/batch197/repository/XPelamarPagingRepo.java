package com.xsis.batch197.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.xsis.batch197.model.XBiodataModel;

public interface XPelamarPagingRepo extends PagingAndSortingRepository<XBiodataModel, Long> {
	
	public Page<XBiodataModel> findByfullname(String fullname, Pageable pageable);
	
	@Query(value = "SELECT p FROM XBiodataModel p WHERE LOWER(p.fullname) LIKE CONCAT('%',LOWER(:nama),'%') ORDER BY (p.fullname)")
	public Page<XBiodataModel> search(@Param("nama") String nama, Pageable pageable);
	
}
