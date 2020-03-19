package com.arrayteam.argo.server.repository;


import com.arrayteam.argo.server.dao.model.ImageTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageTargetRepository extends JpaRepository<ImageTarget, Long> {
}
