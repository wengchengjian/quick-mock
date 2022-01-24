package com.mock.role_service.controller;


import com.mock.api.entity.SysRole;
import com.mock.api.request.role.CreateSysRoleRequest;
import com.mock.api.request.role.UpdateSysRoleRequest;
import com.mock.api.result.BaseResponse;
import com.mock.role_service.service.SysRoleService;
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
@RequestMapping("/sys-role")
public class SysRoleController {
    @Autowired
    private SysRoleService roleService;


    @GetMapping("/{id}")
    SysRole findById(@PathVariable("id") Long roleId){
        return roleService.getById(roleId);
    }

    @PostMapping("/create")
    public BaseResponse create(@Validated @RequestBody CreateSysRoleRequest request){
        roleService.insert(request);

        return BaseResponse.Success();
    }

    @PutMapping("/update")
    public BaseResponse updateById(UpdateSysRoleRequest request){

        roleService.updateById(request);

        return BaseResponse.Success();
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteById(@PathVariable("id") Integer id){

        roleService.deleteById(id);

        return BaseResponse.Success();
    }

    @DeleteMapping("/delete")
    public BaseResponse deleteBatchByIds(List<Integer> ids){

        roleService.deleteBatchByIds(ids);

        return BaseResponse.Success();
    }
}

