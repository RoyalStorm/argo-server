package com.arrayteam.argo.server.controller;


import com.arrayteam.argo.server.dao.response.ARCResponse;
import com.arrayteam.argo.server.service.ARCService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/arc")
@Api(tags = "ARCController")
public class ARCController {

    private final ARCService arcService;

    @Autowired
    public ARCController(ARCService arcService) {
        this.arcService = arcService;
    }

    @GetMapping
    public ARCResponse createMarker() {
        return arcService.createMarker();
    }

}
