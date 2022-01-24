package com.mock.group_service.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mock.api.entity.Group;
import com.mock.api.request.group.CreateGroupRequest;
import com.mock.api.request.group.UpdateGroupRequest;
import com.mock.group_service.mapper.GroupMapper;
import com.mock.group_service.service.GroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WengChengjian
 * @since 2022-01-21
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {

    @Override
    public void insert(CreateGroupRequest request) {
        Group group = new Group();

        BeanUtils.copyProperties(request,group);

        save(group);

    }

    @Override
    public void updateById(UpdateGroupRequest request) {
        Group group = new Group();

        BeanUtils.copyProperties(request,group);

        baseMapper.updateById(group);
    }

    @Override
    public void deleteById(Integer id) {
        removeById(id);
    }

    @Override
    public void deleteBatchByIds(List<Integer> ids) {
        removeByIds(ids);
    }
}
