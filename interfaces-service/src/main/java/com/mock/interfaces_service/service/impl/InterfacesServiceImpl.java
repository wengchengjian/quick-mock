package com.mock.interfaces_service.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mock.api.entity.Interfaces;
import com.mock.interfaces_service.mapper.InterfacesMapper;
import com.mock.interfaces_service.service.InterfacesService;
import org.springframework.stereotype.Service;

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

}
