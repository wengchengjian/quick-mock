package com.mock.group_service.controller;


import com.mock.api.entity.Group;
import com.mock.api.request.group.CreateGroupRequest;
import com.mock.api.request.group.UpdateGroupRequest;
import com.mock.api.result.BaseResponse;
import com.mock.group_service.service.GroupService;
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
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;



    @GetMapping("/{id}")
    Group findById(@PathVariable("id") Long groupId){
        return groupService.getById(groupId);
    }

    @PostMapping("/create")
    public BaseResponse create(@Validated @RequestBody CreateGroupRequest request){
        groupService.insert(request);

        return BaseResponse.Success();
    }

    @PutMapping("/update")
    public BaseResponse updateById(UpdateGroupRequest request){

        groupService.updateById(request);

        return BaseResponse.Success();
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteById(@PathVariable("id") Integer id){

        groupService.deleteById(id);

        return BaseResponse.Success();
    }

    @DeleteMapping("/delete")
    public BaseResponse deleteBatchByIds(List<Integer> ids){

        groupService.deleteBatchByIds(ids);

        return BaseResponse.Success();
    }

}

