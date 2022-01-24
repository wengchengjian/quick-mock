package com.mock.user_service.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mock.api.entity.SysUser;
import com.mock.api.request.user.CreateSysUserRequest;
import com.mock.api.request.user.UpdateSysUserRequest;
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
public interface SysUserService extends IService<SysUser> {
    @Transactional(rollbackFor = Exception.class)
    void insert(CreateSysUserRequest request);

    @Transactional(rollbackFor = Exception.class)
    void updateById(UpdateSysUserRequest request);

    @Transactional(rollbackFor = Exception.class)
    void deleteById(Integer id);

    @Transactional(rollbackFor = Exception.class)
    void deleteBatchByIds(List<Integer> ids);
}
