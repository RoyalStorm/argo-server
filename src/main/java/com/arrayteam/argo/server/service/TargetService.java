package com.arrayteam.argo.server.service;


import com.arrayteam.argo.server.dao.model.ARC;
import com.arrayteam.argo.server.dao.model.Target;
import com.arrayteam.argo.server.dao.model.VirtualContent;
import com.arrayteam.argo.server.dao.response.TargetResponse;
import com.arrayteam.argo.server.repository.TargetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class TargetService {

    private final TargetRepository targetRepository;
    private final VirtualContentService virtualContentService;
    private final ARCService arcService;
    private final ContentService contentService;

    @Autowired
    public TargetService(TargetRepository targetRepository, VirtualContentService virtualContentService, ARCService arcService, ContentService contentService) {
        this.targetRepository = targetRepository;
        this.virtualContentService = virtualContentService;
        this.arcService = arcService;
        this.contentService = contentService;
    }

    public TargetResponse store(Long userId, MultipartFile content) throws IOException {
        Target target = new Target();
        VirtualContent virtualContent = new VirtualContent();
        ARC arc = new ARC();

        return new TargetResponse().success(targetRepository.save(target));
    }

    public TargetResponse showAll() {
        return new TargetResponse().success(targetRepository.findAll());
    }

    public TargetResponse showOne(Target target) {
        if (target == null)
            return new TargetResponse().error(HttpStatus.NOT_FOUND, "Resource not found");

        return new TargetResponse().success(target);
    }

    public Target edit(Target targetFromDB, Target newTarget) {
        BeanUtils.copyProperties(newTarget, targetFromDB, "id");

        return targetRepository.save(targetFromDB);
    }

    public TargetResponse destroy(Target target) {
        if (target == null)
            return new TargetResponse().error(HttpStatus.BAD_REQUEST, "Resource with selected id not found");

        targetRepository.delete(target);

        return new TargetResponse().success();
    }

}
