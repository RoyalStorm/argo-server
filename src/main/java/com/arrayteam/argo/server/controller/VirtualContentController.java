package com.arrayteam.argo.server.controller;


import com.arrayteam.argo.server.dao.response.VirtualContentResponse;
import com.arrayteam.argo.server.service.VirtualContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @ApiOperation(value = "Create virtual content", response = VirtualContentResponse.class)
    public VirtualContentResponse store(@RequestParam("userId") Long userId,
                                        @RequestParam("content") MultipartFile content) throws IOException {
        return virtualContentService.store(userId, content);
    }

    @GetMapping
    @ApiOperation(value = "Get a list of virtual contents", response = VirtualContentResponse.class)
    public VirtualContentResponse showAll() {
        return virtualContentService.showAll();
    }

}
