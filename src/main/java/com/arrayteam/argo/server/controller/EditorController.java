package com.arrayteam.argo.server.controller;


import com.arrayteam.argo.server.dao.model.Target;
import com.arrayteam.argo.server.dao.response.TargetResponse;
import com.arrayteam.argo.server.service.EditorService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/editor")
public class EditorController {

    private final EditorService editorService;

    public EditorController(EditorService editorService) {
        this.editorService = editorService;
    }

    @PostMapping
    public TargetResponse store(@RequestBody Target target) {
        return editorService.store(target);
    }

    @GetMapping
    public TargetResponse showAll() {
        return editorService.showAll();
    }

    @GetMapping("/{id}")
    public TargetResponse showOne(@PathVariable("id") Target target) {
        return editorService.showOne(target);
    }

    @PatchMapping("/{id}")
    public Target edit(@PathVariable("id") Target targetFromDB, @RequestBody Target newTarget) {
        return editorService.edit(targetFromDB, newTarget);
    }

    @DeleteMapping("/{id}")
    public TargetResponse destroy(@PathVariable("id") Target target) {
        return editorService.destroy(target);
    }

}
