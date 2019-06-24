package com.xsis.batch197.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XBiodataModel;

@Repository
public interface XBiodataRepo extends JpaRepository<XBiodataModel, Long>, JpaSpecificationExecutor<XBiodataModel> {

}
