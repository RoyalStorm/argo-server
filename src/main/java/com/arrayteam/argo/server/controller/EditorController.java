package com.arrayteam.argo.server.controller;


import com.arrayteam.argo.server.dao.model.Target;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/editor")
public class EditorController {

    @PostMapping
    public void store(@RequestBody Target target) {
    }

    @GetMapping
    public void showAll() {
    }

    @GetMapping("/{id}")
    public void showOne(@PathVariable("id") Target target) {
    }

    @PatchMapping("/{id}")
    public void edit(@PathVariable("id") Target targetFromDB, @RequestBody Target newTarget) {
    }

    @DeleteMapping("/{id}")
    public void destroy(@PathVariable("id") Target target) {
    }

}
