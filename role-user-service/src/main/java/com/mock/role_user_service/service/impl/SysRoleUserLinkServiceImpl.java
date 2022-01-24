package com.mock.role_user_service.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mock.api.entity.SysRoleUserLink;
import com.mock.api.entity.SysRoleUserLink;
import com.mock.api.request.roleUser.CreateSysRoleUserRequest;
import com.mock.api.request.roleUser.UpdateSysRoleUserRequest;
import com.mock.role_user_service.mapper.SysRoleUserLinkMapper;
import com.mock.role_user_service.service.SysRoleUserLinkService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WengChengjian
 * @since 2022-01-21
 */
@Service
public class SysRoleUserLinkServiceImpl extends ServiceImpl<SysRoleUserLinkMapper, SysRoleUserLink> implements SysRoleUserLinkService {

    @Override
    public void insert(CreateSysRoleUserRequest request) {
        SysRoleUserLink roleUser = new SysRoleUserLink();

        BeanUtils.copyProperties(request, roleUser);

        save(roleUser);
    }

    @Override
    public void updateById(UpdateSysRoleUserRequest request) {
        SysRoleUserLink roleUser = new SysRoleUserLink();

        BeanUtils.copyProperties(request, roleUser);

        baseMapper.updateById(roleUser);
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
