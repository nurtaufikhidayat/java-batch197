package com.xsis.batch197.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XAddressBookModel;

@Repository
public interface XAddressBookRepo extends JpaRepository<XAddressBookModel, Long>{
	public XAddressBookModel findByEmail(String email);
	public XAddressBookModel findByAbuid(String abuid);
	
	@Query(value="SELECT u FROM XAddressBookModel u WHERE u.abuid=:nama or u.email=:nama")
	public XAddressBookModel findByAbuidAndEmail(@Param("nama") String nama);
}
