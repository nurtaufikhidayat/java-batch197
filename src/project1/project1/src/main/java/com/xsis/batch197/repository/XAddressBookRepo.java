package com.xsis.batch197.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XAddressBookModel;
@Repository
public interface XAddressBookRepo extends JpaRepository<XAddressBookModel, Long>{
		
}
