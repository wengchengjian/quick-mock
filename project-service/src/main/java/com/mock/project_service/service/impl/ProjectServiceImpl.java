package com.mock.project_service.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mock.api.entity.Project;
import com.mock.api.request.project.CreateProjectRequest;
import com.mock.api.request.project.UpdateProjectRequest;
import com.mock.project_service.mapper.ProjectMapper;
import com.mock.project_service.service.ProjectService;
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
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

    @Override
    public void insert(CreateProjectRequest request) {
        Project project = new Project();

        BeanUtils.copyProperties(request,project);

        save(project);
    }

    @Override
    public void updateById(UpdateProjectRequest request) {
        Project project = new Project();

        BeanUtils.copyProperties(request,project);

        baseMapper.updateById(project);
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
