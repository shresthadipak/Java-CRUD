package com.arnav.StudentInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arnav.StudentInfo.domain.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>{

}
