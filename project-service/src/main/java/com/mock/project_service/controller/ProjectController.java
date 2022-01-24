package com.mock.project_service.controller;


import com.mock.api.entity.Project;
import com.mock.api.request.project.CreateProjectRequest;
import com.mock.api.request.project.UpdateProjectRequest;
import com.mock.api.result.BaseResponse;
import com.mock.project_service.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WengChengjian
 * @since 2022-01-21
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/{id}")
    public Project findById(@PathVariable("id") Long projectId){
        return projectService.getById(projectId);
    }

    @PostMapping("/create")
    public BaseResponse create( @Validated @RequestBody CreateProjectRequest request){
        projectService.insert(request);

        return BaseResponse.Success();
    }

    @PutMapping("/update")
    public BaseResponse updateById(UpdateProjectRequest request){

        projectService.updateById(request);

        return BaseResponse.Success();
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteById(@PathVariable("id") Integer id){

        projectService.deleteById(id);

        return BaseResponse.Success();
    }

    @DeleteMapping("/delete")
    public BaseResponse deleteBatchByIds(List<Integer> ids){

        projectService.deleteBatchByIds(ids);

        return BaseResponse.Success();
    }
}

