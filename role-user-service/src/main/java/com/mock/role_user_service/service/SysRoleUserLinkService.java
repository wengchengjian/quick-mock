package com.mock.role_user_service.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mock.api.entity.SysRoleUserLink;
import com.mock.api.request.roleUser.CreateSysRoleUserRequest;
import com.mock.api.request.roleUser.UpdateSysRoleUserRequest;
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
public interface SysRoleUserLinkService extends IService<SysRoleUserLink> {
    @Transactional(rollbackFor = Exception.class)
    void insert(CreateSysRoleUserRequest request);

    @Transactional(rollbackFor = Exception.class)
    void updateById(UpdateSysRoleUserRequest request);

    @Transactional(rollbackFor = Exception.class)
    void deleteById(Integer id);

    @Transactional(rollbackFor = Exception.class)
    void deleteBatchByIds(List<Integer> ids);
}
