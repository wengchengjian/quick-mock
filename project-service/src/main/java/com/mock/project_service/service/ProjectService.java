package com.mock.project_service.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mock.api.entity.Project;
import com.mock.api.request.project.CreateProjectRequest;
import com.mock.api.request.project.UpdateProjectRequest;
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
public interface ProjectService extends IService<Project> {

    @Transactional(rollbackFor = Exception.class)
    void insert(CreateProjectRequest request);

    @Transactional(rollbackFor = Exception.class)
    void updateById(UpdateProjectRequest request);

    @Transactional(rollbackFor = Exception.class)
    void deleteById(Integer id);

    @Transactional(rollbackFor = Exception.class)
    void deleteBatchByIds(List<Integer> ids);
}
