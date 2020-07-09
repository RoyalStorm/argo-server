package com.arrayteam.argo.server.controller;


import com.arrayteam.argo.server.dao.model.ImageTarget;
import com.arrayteam.argo.server.dao.model.Target;
import com.arrayteam.argo.server.dao.response.ImageTargetResponse;
import com.arrayteam.argo.server.service.ImageTargetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Create image", response = ImageTargetResponse.class)
    public ImageTargetResponse store(@RequestParam("targetId")
                                     @ApiParam(value = "Target's id")
                                             Target target,
                                     @RequestBody
                                     @ApiParam(value = "Target's data")
                                             MultipartFile targetData) throws IOException {
        return imageTargetService.store(target, targetData);
    }

    @GetMapping
    @ApiOperation(value = "Get a list of images", response = ImageTargetResponse.class)
    public ImageTargetResponse findAll() {
        return imageTargetService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get image by id", response = ImageTargetResponse.class)
    public ImageTargetResponse findOne(@PathVariable("id") ImageTarget imageTarget) {
        return imageTargetService.findOne(imageTarget);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete image", response = ImageTargetResponse.class)
    public ImageTargetResponse destroy(@PathVariable("id") ImageTarget imageTarget) {
        return imageTargetService.destroy(imageTarget);
    }

}
