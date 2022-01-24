package com.mock.user_service.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mock.api.entity.SysUser;
import com.mock.api.entity.SysUser;
import com.mock.api.request.user.CreateSysUserRequest;
import com.mock.api.request.user.UpdateSysUserRequest;
import com.mock.user_service.mapper.SysUserMapper;
import com.mock.user_service.service.SysUserService;
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
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public void insert(CreateSysUserRequest request) {
        SysUser user = new SysUser();

        BeanUtils.copyProperties(request,user);

        save(user);
    }

    @Override
    public void updateById(UpdateSysUserRequest request) {
        SysUser user = new SysUser();

        BeanUtils.copyProperties(request,user);

        baseMapper.updateById(user);
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
