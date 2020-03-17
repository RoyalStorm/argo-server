package com.arrayteam.argo.server.controller;


import com.arrayteam.argo.server.dao.response.TargetResponse;
import com.arrayteam.argo.server.dao.response.VirtualContentResponse;
import com.arrayteam.argo.server.service.VirtualContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/virtual-content")
@Api(tags = "VirtualContentController")
public class VirtualContentController {

    private final VirtualContentService virtualContentService;

    @Autowired
    public VirtualContentController(VirtualContentService virtualContentService) {
        this.virtualContentService = virtualContentService;
    }

    @PostMapping
    @ApiOperation(value = "Upload virtual content", response = TargetResponse.class)
    public VirtualContentResponse store(@RequestParam("userId") Long userId, @RequestParam("image") MultipartFile image) throws IOException {
        return virtualContentService.store(userId, image);
    }

}
