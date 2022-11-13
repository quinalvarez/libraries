package com.jalv.libs.frame.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<PK, ENT> extends JpaRepository<ENT, PK>, JpaSpecificationExecutor<ENT> {
}
