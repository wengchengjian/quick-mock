package com.mock.interfaces_service.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mock.api.entity.Interfaces;
import com.mock.api.entity.InterfacesVO;
import com.mock.api.request.Interface.CreateInterfaceRequest;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WengChengjian
 * @since 2022-01-21
 */
public interface InterfacesService extends IService<Interfaces> {

    void create(CreateInterfaceRequest request);

    InterfacesVO findById(Long interfaceId);

    List<InterfacesVO> listVO();
}
