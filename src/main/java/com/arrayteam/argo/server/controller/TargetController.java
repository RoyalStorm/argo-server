package com.arrayteam.argo.server.controller;


import com.arrayteam.argo.server.dao.model.Target;
import com.arrayteam.argo.server.dao.response.TargetResponse;
import com.arrayteam.argo.server.service.TargetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/target")
@Api(tags = "TargetController")
public class TargetController {

    private final TargetService targetService;

    @Autowired
    public TargetController(TargetService targetService) {
        this.targetService = targetService;
    }

    @PostMapping
    @ApiOperation(value = "Create target", response = TargetResponse.class)
    public TargetResponse store(@RequestBody Target target) {
        return targetService.store(target);
    }

    @GetMapping
    @ApiOperation(value = "Get a list of targets", response = TargetResponse.class)
    public TargetResponse showAll() {
        return targetService.showAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get target by id", response = TargetResponse.class)
    public TargetResponse showOne(@PathVariable("id") Target target) {
        return targetService.showOne(target);
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "Update target", response = TargetResponse.class)
    public Target edit(@PathVariable("id") Target targetFromDB, @RequestBody Target newTarget) {
        return targetService.edit(targetFromDB, newTarget);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete target", response = TargetResponse.class)
    public TargetResponse destroy(@PathVariable("id") Target target) {
        return targetService.destroy(target);
    }

}
