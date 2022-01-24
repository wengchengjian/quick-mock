package com.mock.role_service.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mock.api.entity.SysRole;
import com.mock.api.request.role.CreateSysRoleRequest;
import com.mock.api.request.role.UpdateSysRoleRequest;
import com.mock.role_service.mapper.SysRoleMapper;
import com.mock.role_service.service.SysRoleService;
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
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public void insert(CreateSysRoleRequest request) {
        SysRole role = new SysRole();

        BeanUtils.copyProperties(request,role);

        save(role);
    }

    @Override
    public void updateById(UpdateSysRoleRequest request) {
        SysRole role = new SysRole();

        BeanUtils.copyProperties(request,role);

        baseMapper.updateById(role);
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
