package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XBiodataAttachmentModel;


@Repository
public interface XBiodataAttachmentRepo extends JpaRepository<XBiodataAttachmentModel, Long> {
	
	List<XBiodataAttachmentModel> findByBiodataId(Long biodataId);
}
