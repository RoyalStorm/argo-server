package com.arrayteam.argo.server.service;


import com.arrayteam.argo.server.dao.model.Target;
import com.arrayteam.argo.server.dao.response.TargetResponse;
import com.arrayteam.argo.server.repository.TargetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class EditorService {

    private final TargetRepository targetRepository;

    public EditorService(TargetRepository targetRepository) {
        this.targetRepository = targetRepository;
    }

    public TargetResponse store(Target target) {
        return new TargetResponse().success(targetRepository.save(target));
    }

    public TargetResponse showAll() {
        return new TargetResponse().success(targetRepository.findAll());
    }

    public TargetResponse showOne(Target target) {
        if (target == null)
            return new TargetResponse().error(HttpStatus.NOT_FOUND, "Resource not found");

        return new TargetResponse().success(target);
    }

    public Target edit(Target targetFromDB, Target newTarget) {
        BeanUtils.copyProperties(newTarget, targetFromDB, "id");

        return targetRepository.save(targetFromDB);
    }

    public TargetResponse destroy(Target target) {
        if (target == null)
            return new TargetResponse().error(HttpStatus.BAD_REQUEST, "Resource with selected id not found");

        targetRepository.delete(target);

        return new TargetResponse().success(target);
    }

}
