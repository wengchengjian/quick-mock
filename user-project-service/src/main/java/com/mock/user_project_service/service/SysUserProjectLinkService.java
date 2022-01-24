package com.mock.user_project_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mock.api.entity.SysUserProjectLink;
import com.mock.api.request.usersProject.CreateSysUserProjectRequest;
import com.mock.api.request.usersProject.UpdateSysUserProjectRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WengChengjian
 * @since 2022-01-21
 */
public interface SysUserProjectLinkService extends IService<SysUserProjectLink> {
    @Transactional(rollbackFor = Exception.class)
    void insert(CreateSysUserProjectRequest request);

    @Transactional(rollbackFor = Exception.class)
    void updateById(UpdateSysUserProjectRequest request);

    @Transactional(rollbackFor = Exception.class)
    void deleteById(Integer id);

    @Transactional(rollbackFor = Exception.class)
    void deleteBatchByIds(List<Integer> ids);
}
