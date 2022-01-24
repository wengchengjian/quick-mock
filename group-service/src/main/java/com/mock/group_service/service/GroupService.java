package com.mock.group_service.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mock.api.entity.Group;
import com.mock.api.request.group.CreateGroupRequest;
import com.mock.api.request.group.UpdateGroupRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WengChengjian
 * @since 2022-01-21
 */
public interface GroupService extends IService<Group> {

    @Transactional(rollbackFor = Exception.class)
    void insert(CreateGroupRequest request);

    @Transactional(rollbackFor = Exception.class)
    void updateById(UpdateGroupRequest request);

    @Transactional(rollbackFor = Exception.class)
    void deleteById(Integer id);

    @Transactional(rollbackFor = Exception.class)
    void deleteBatchByIds(List<Integer> ids);
}
