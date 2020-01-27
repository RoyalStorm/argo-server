package com.arrayteam.argo.server.controller;


import com.arrayteam.argo.server.dao.model.Target;
import com.arrayteam.argo.server.service.EditorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/editor")
public class EditorController {

    private final EditorService editorService;

    public EditorController(EditorService editorService) {
        this.editorService = editorService;
    }

    @PostMapping
    public Target store(@RequestBody Target target) {
        return editorService.store(target);
    }

    @GetMapping
    public List<Target> showAll() {
        return editorService.showAll();
    }

    @GetMapping("/{id}")
    public Target showOne(@PathVariable("id") Target target) {
        return editorService.showOne(target);
    }

    @PatchMapping("/{id}")
    public void edit(@PathVariable("id") Target targetFromDB, @RequestBody Target newTarget) {
        editorService.edit(targetFromDB, newTarget);
    }

    @DeleteMapping("/{id}")
    public Target destroy(@PathVariable("id") Target target) {
        return editorService.destroy(target);
    }

}
