package com.mock.user_service.controller;


import com.mock.api.entity.SysUser;
import com.mock.api.request.user.CreateSysUserRequest;
import com.mock.api.request.user.UpdateSysUserRequest;
import com.mock.api.result.BaseResponse;
import com.mock.user_service.service.SysUserService;
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
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @GetMapping("/{id}")
    SysUser findById(@PathVariable("id") Long userId){
        return userService.getById(userId);
    }

    @PostMapping("/create")
    public BaseResponse create(@Validated @RequestBody CreateSysUserRequest request){
        userService.insert(request);

        return BaseResponse.Success();
    }

    @PutMapping("/update")
    public BaseResponse updateById(UpdateSysUserRequest request){

        userService.updateById(request);

        return BaseResponse.Success();
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteById(@PathVariable("id") Integer id){

        userService.deleteById(id);

        return BaseResponse.Success();
    }

    @DeleteMapping("/delete")
    public BaseResponse deleteBatchByIds(List<Integer> ids){

        userService.deleteBatchByIds(ids);

        return BaseResponse.Success();
    }
}

