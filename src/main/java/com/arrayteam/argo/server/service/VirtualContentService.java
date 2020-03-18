package com.arrayteam.argo.server.service;


import com.arrayteam.argo.server.dao.model.ARC;
import com.arrayteam.argo.server.dao.model.Target;
import com.arrayteam.argo.server.dao.model.VirtualContent;
import com.arrayteam.argo.server.dao.response.VirtualContentResponse;
import com.arrayteam.argo.server.repository.ARCRepository;
import com.arrayteam.argo.server.repository.TargetRepository;
import com.arrayteam.argo.server.repository.VirtualContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Random;


@Service
public class VirtualContentService {

    private final VirtualContentRepository virtualContentRepository;
    private final TargetRepository targetRepository;
    private final ARCRepository arcRepository;

    @Autowired
    public VirtualContentService(VirtualContentRepository virtualContentRepository, TargetRepository targetRepository, ARCRepository arcRepository) {
        this.virtualContentRepository = virtualContentRepository;
        this.targetRepository = targetRepository;
        this.arcRepository = arcRepository;
    }

    public VirtualContentResponse store(Long userId, MultipartFile content) throws IOException {
        VirtualContent virtualContent = new VirtualContent();
        Target target = new Target();
        ARC arc = new ARC();

        String extension = getExtension(StringUtils.cleanPath(content.getOriginalFilename()));

        if (extension.equals("png") || extension.equals("jpg")) {
            virtualContent.setData(content.getBytes());
            virtualContent.setName(String.valueOf(new Random().nextLong()));
        }

        return new VirtualContentResponse().success(virtualContentRepository.save(virtualContent));
    }

    public VirtualContentResponse showAll() {
        return new VirtualContentResponse().success(virtualContentRepository.findAll());
    }

    private String getExtension(String fileName) {
        final int EXTENSION_INDEX = 1;

        return fileName.split("\\.")[EXTENSION_INDEX].toLowerCase();
    }

}
