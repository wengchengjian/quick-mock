package com.mock.role_user_service.controller;


import com.mock.api.entity.SysRoleUserLink;
import com.mock.api.request.roleUser.CreateSysRoleUserRequest;
import com.mock.api.request.roleUser.UpdateSysRoleUserRequest;
import com.mock.api.result.BaseResponse;
import com.mock.role_user_service.service.SysRoleUserLinkService;
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
@RequestMapping("/sys-role-roleUser-link")
public class SysRoleUserLinkController {
    
    @Autowired
    private SysRoleUserLinkService sysRoleUserLinkService;

    @GetMapping("/{id}")
    SysRoleUserLink findById(@PathVariable("id") Long roleUserId){
        return sysRoleUserLinkService.getById(roleUserId);
    }

    @PostMapping("/create")
    public BaseResponse create(@Validated @RequestBody CreateSysRoleUserRequest request){
        sysRoleUserLinkService.insert(request);

        return BaseResponse.Success();
    }

    @PutMapping("/update")
    public BaseResponse updateById(UpdateSysRoleUserRequest request){

        sysRoleUserLinkService.updateById(request);

        return BaseResponse.Success();
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteById(@PathVariable("id") Integer id){

        sysRoleUserLinkService.deleteById(id);

        return BaseResponse.Success();
    }

    @DeleteMapping("/delete")
    public BaseResponse deleteBatchByIds(List<Integer> ids){

        sysRoleUserLinkService.deleteBatchByIds(ids);

        return BaseResponse.Success();
    }
}

