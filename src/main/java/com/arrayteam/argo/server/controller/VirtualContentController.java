package com.arrayteam.argo.server.controller;


import com.arrayteam.argo.server.dao.model.VirtualContent;
import com.arrayteam.argo.server.dao.response.VirtualContentResponse;
import com.arrayteam.argo.server.service.VirtualContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    public VirtualContentResponse store(@RequestBody VirtualContent virtualContent) {
        return virtualContentService.store(virtualContent);
    }

    @GetMapping
    @ApiOperation(value = "Get a list of virtual contents", response = VirtualContentResponse.class)
    public VirtualContentResponse showAll() {
        return virtualContentService.showAll();
    }

}
