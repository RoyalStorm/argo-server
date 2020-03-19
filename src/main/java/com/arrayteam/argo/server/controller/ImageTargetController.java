package com.arrayteam.argo.server.controller;


import com.arrayteam.argo.server.dao.model.Target;
import com.arrayteam.argo.server.dao.response.ImageTargetResponse;
import com.arrayteam.argo.server.service.ImageTargetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/target/image")
@Api(tags = "ImageTargetController")
public class ImageTargetController {

    private final ImageTargetService imageTargetService;

    @Autowired
    public ImageTargetController(ImageTargetService imageTargetService) {
        this.imageTargetService = imageTargetService;
    }

    @PostMapping
    public ImageTargetResponse store(@RequestParam("targetId")
                                     @ApiParam(value = "Target's id")
                                             Target target,
                                     @RequestBody
                                     @ApiParam(value = "Target's data")
                                             MultipartFile targetData) throws IOException {
        return imageTargetService.store(target, targetData);
    }

}
