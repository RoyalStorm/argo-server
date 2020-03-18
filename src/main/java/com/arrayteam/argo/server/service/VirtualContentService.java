package com.arrayteam.argo.server.service;


import com.arrayteam.argo.server.dao.model.VirtualContent;
import com.arrayteam.argo.server.dao.response.VirtualContentResponse;
import com.arrayteam.argo.server.repository.VirtualContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VirtualContentService {

    private final VirtualContentRepository virtualContentRepository;

    @Autowired
    public VirtualContentService(VirtualContentRepository virtualContentRepository) {
        this.virtualContentRepository = virtualContentRepository;
    }

    public VirtualContentResponse store(VirtualContent virtualContent) {
        return new VirtualContentResponse().success(virtualContentRepository.save(virtualContent));
    }

    public VirtualContentResponse showAll() {
        return new VirtualContentResponse().success(virtualContentRepository.findAll());
    }

}
