package com.arrayteam.argo.server.service;


import com.arrayteam.argo.server.dao.model.Target;
import com.arrayteam.argo.server.repository.TargetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EditorService {

    private final TargetRepository targetRepository;

    public EditorService(TargetRepository targetRepository) {
        this.targetRepository = targetRepository;
    }

    public Target store(Target target) {
        return targetRepository.save(target);
    }

    public List<Target> showAll() {
        return targetRepository.findAll();
    }

    public Target showOne(Target target) {
        return target;
    }

    public void edit(Target targetFromDB, Target newTarget) {
        BeanUtils.copyProperties(newTarget, targetFromDB, "id");
    }

    public Target destroy(Target target) {
        targetRepository.delete(target);

        return target;
    }

}
