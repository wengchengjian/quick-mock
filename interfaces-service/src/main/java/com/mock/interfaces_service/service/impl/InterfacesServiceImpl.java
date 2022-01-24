package com.mock.interfaces_service.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mock.api.client.GroupClient;
import com.mock.api.client.ProjectClient;
import com.mock.api.entity.Group;
import com.mock.api.entity.Interfaces;
import com.mock.api.entity.InterfacesVO;
import com.mock.api.entity.Project;
import com.mock.api.exception.RequestParamsNotFoundException;
import com.mock.api.request.Interface.CreateInterfaceRequest;
import com.mock.interfaces_service.mapper.InterfacesMapper;
import com.mock.interfaces_service.service.InterfacesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class InterfacesServiceImpl extends ServiceImpl<InterfacesMapper, Interfaces> implements InterfacesService {

    @Autowired
    private MappingService mappingService;

    @Autowired
    private ProjectClient projectClient;

    @Autowired
    private GroupClient groupClient;

    /**
     * TODO 等待接入分布式事务 默认使用Seata TCC模式
     * @param request
     */
    @Override
    public void create(CreateInterfaceRequest request) {

        Interfaces inteface = new Interfaces();

        if(request!=null){
            BeanUtils.copyProperties(request,inteface);
        }else{
            throw new RequestParamsNotFoundException("请求参数为空");
        }

        // 插入接口实体类
        baseMapper.insert(inteface);

        // 注册接口
        mappingService.addMapping(findById(inteface.getId()));

        //
    }

    @Override
    public InterfacesVO findById(Long interfaceId) {

        Interfaces interfaces = baseMapper.selectById(interfaceId);

        return injectVO(interfaces);
    }

    @Override
    public List<InterfacesVO> listVO() {
        List<Interfaces> interfaces = baseMapper.selectList(new QueryWrapper<>());

        List<InterfacesVO> res = new ArrayList<>(interfaces.size());

        for (Interfaces inter : interfaces) {
             InterfacesVO vo = injectVO(inter);

             res.add(vo);
        }

        return res;
    }

    private InterfacesVO injectVO(Interfaces interfaces) {
        InterfacesVO res = new InterfacesVO();
        if(interfaces!=null){
            BeanUtils.copyProperties(interfaces,res);

            Long projectId  = interfaces.getProjectId();
            Long groupId = interfaces.getGroupId();

            Project project = projectClient.findById(projectId);
            Group group = groupClient.findById(groupId);

            res.setProject(project);
            res.setGroup(group);

        }
        return res;
    }
}
