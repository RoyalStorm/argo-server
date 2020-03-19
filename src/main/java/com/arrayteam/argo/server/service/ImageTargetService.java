package com.arrayteam.argo.server.service;


import com.arrayteam.argo.server.dao.model.ImageTarget;
import com.arrayteam.argo.server.dao.model.Target;
import com.arrayteam.argo.server.dao.response.ImageTargetResponse;
import com.arrayteam.argo.server.repository.ImageTargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class ImageTargetService {

    private final ImageTargetRepository imageTargetRepository;

    @Autowired
    public ImageTargetService(ImageTargetRepository imageTargetRepository) {
        this.imageTargetRepository = imageTargetRepository;
    }

    public ImageTargetResponse store(Target target, MultipartFile targetData) throws IOException {
        if (target == null)
            return new ImageTargetResponse().error(HttpStatus.NOT_FOUND, "Target not found");

        ImageTarget imageTarget = new ImageTarget();
        imageTarget.setData(targetData.getBytes());
        imageTarget.setTarget(target);

        return new ImageTargetResponse().success(imageTargetRepository.save(imageTarget));
    }

}
