package com.arrayteam.argo.server.repository;


import com.arrayteam.argo.server.dao.model.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TargetRepository extends JpaRepository<Target, Long> {
}
