package com.mock.role_service.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mock.api.entity.SysRole;
import com.mock.api.request.role.CreateSysRoleRequest;
import com.mock.api.request.role.UpdateSysRoleRequest;
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
public interface SysRoleService extends IService<SysRole> {
    @Transactional(rollbackFor = Exception.class)
    void insert(CreateSysRoleRequest request);

    @Transactional(rollbackFor = Exception.class)
    void updateById(UpdateSysRoleRequest request);

    @Transactional(rollbackFor = Exception.class)
    void deleteById(Integer id);

    @Transactional(rollbackFor = Exception.class)
    void deleteBatchByIds(List<Integer> ids);
}
