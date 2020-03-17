package com.arrayteam.argo.server.service;


import com.arrayteam.argo.server.dao.model.ARC;
import com.arrayteam.argo.server.dao.response.ARCResponse;
import com.arrayteam.argo.server.repository.ARCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ARCService {

    private final ARCRepository arcRepository;

    @Autowired
    public ARCService(ARCRepository arcRepository) {
        this.arcRepository = arcRepository;
    }

    public ARCResponse createMarker() {
        return new ARCResponse().success(arcRepository.save(new ARC()));
    }

}
