package com.mock.user_project_service.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mock.api.entity.SysUser;
import com.mock.api.entity.SysUserProjectLink;
import com.mock.api.request.usersProject.CreateSysUserProjectRequest;
import com.mock.api.request.usersProject.UpdateSysUserProjectRequest;
import com.mock.user_project_service.mapper.SysUserProjectLinkMapper;
import com.mock.user_project_service.service.SysUserProjectLinkService;
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
public class SysUserProjectLinkServiceImpl extends ServiceImpl<SysUserProjectLinkMapper, SysUserProjectLink>
        implements SysUserProjectLinkService {

    @Override
    public void insert(CreateSysUserProjectRequest request) {
        SysUserProjectLink sysUserProjectLink = new SysUserProjectLink();

        BeanUtils.copyProperties(request, sysUserProjectLink);

        save(sysUserProjectLink);
    }

    @Override
    public void updateById(UpdateSysUserProjectRequest request) {
        SysUserProjectLink sysUserProjectLink = new SysUserProjectLink();

        BeanUtils.copyProperties(request, sysUserProjectLink);

        baseMapper.updateById(sysUserProjectLink);
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
