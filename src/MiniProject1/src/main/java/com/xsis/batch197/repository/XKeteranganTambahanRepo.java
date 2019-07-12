package com.xsis.batch197.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XKeteranganTambahanModel;

@Repository
public interface XKeteranganTambahanRepo extends JpaRepository<XKeteranganTambahanModel, Long>{

}
