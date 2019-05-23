package com.xsis.batch197.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xsis.batch197.model.DosenModel;

@Repository
public interface DosenRepo extends JpaRepository<DosenModel, Integer> {

}
