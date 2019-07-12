package com.xsis.batch197.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.XFamilyRelationModel;
import com.xsis.batch197.model.XFamilyTreeTypeModel;

@Repository
public interface XFamilyTreeTypeRepo extends JpaRepository<XFamilyTreeTypeModel, Long> {


}
