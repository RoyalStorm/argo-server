package com.arrayteam.argo.server.repository;


import com.arrayteam.argo.server.dao.model.VirtualContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VirtualContentRepository extends JpaRepository<VirtualContent, Long> {
}
