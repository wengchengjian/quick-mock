package com.mock.user_project_service.controller;


import com.mock.api.entity.SysUser;
import com.mock.api.entity.SysUserProjectLink;
import com.mock.api.request.user.CreateSysUserRequest;
import com.mock.api.request.user.UpdateSysUserRequest;
import com.mock.api.request.usersProject.CreateSysUserProjectRequest;
import com.mock.api.request.usersProject.UpdateSysUserProjectRequest;
import com.mock.api.result.BaseResponse;
import com.mock.user_project_service.service.SysUserProjectLinkService;
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
@RequestMapping("/sys-user-project-link")
public class SysUserProjectLinkController {
    @Autowired
    private SysUserProjectLinkService sysUserProjectLinkService;

    @GetMapping("/{id}")
    SysUserProjectLink findById(@PathVariable("id") Long userId){
        return sysUserProjectLinkService.getById(userId);
    }

    @PostMapping("/create")
    public BaseResponse create(@Validated @RequestBody CreateSysUserProjectRequest request){
        sysUserProjectLinkService.insert(request);

        return BaseResponse.Success();
    }

    @PutMapping("/update")
    public BaseResponse updateById(UpdateSysUserProjectRequest request){

        sysUserProjectLinkService.updateById(request);

        return BaseResponse.Success();
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteById(@PathVariable("id") Integer id){

        sysUserProjectLinkService.deleteById(id);

        return BaseResponse.Success();
    }

    @DeleteMapping("/delete")
    public BaseResponse deleteBatchByIds(List<Integer> ids){

        sysUserProjectLinkService.deleteBatchByIds(ids);

        return BaseResponse.Success();
    }
}

