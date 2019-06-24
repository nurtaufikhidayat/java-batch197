package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XMenuModel;

@Repository
public interface XMenuRepo extends JpaRepository<XMenuModel, Long> {
	public XMenuModel findByTitle(String title);
	public List<XMenuModel> findByMenuType(String type);
}
