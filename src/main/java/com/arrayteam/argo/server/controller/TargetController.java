package com.arrayteam.argo.server.controller;


import com.arrayteam.argo.server.dao.model.Target;
import com.arrayteam.argo.server.dao.response.TargetResponse;
import com.arrayteam.argo.server.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/editor")
public class TargetController {

    private final TargetService targetService;

    @Autowired
    public TargetController(TargetService targetService) {
        this.targetService = targetService;
    }

    @PostMapping
    public TargetResponse store(@RequestBody Target target, @RequestParam("image") MultipartFile image) throws IOException {
        return targetService.store(target, image);
    }

    @GetMapping
    public TargetResponse showAll() {
        return targetService.showAll();
    }

    @GetMapping("/{id}")
    public TargetResponse showOne(@PathVariable("id") Target target) {
        return targetService.showOne(target);
    }

    @PatchMapping("/{id}")
    public Target edit(@PathVariable("id") Target targetFromDB, @RequestBody Target newTarget) {
        return targetService.edit(targetFromDB, newTarget);
    }

    @DeleteMapping("/{id}")
    public TargetResponse destroy(@PathVariable("id") Target target) {
        return targetService.destroy(target);
    }

}
