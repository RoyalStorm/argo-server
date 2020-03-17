package com.arrayteam.argo.server.repository;


import com.arrayteam.argo.server.dao.model.ARC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ARCRepository extends JpaRepository<ARC, Long> {
}
