package com.mock.interfaces_service.listener;

import com.mock.api.entity.InterfacesVO;
import com.mock.interfaces_service.controller.RegisterController;
import com.mock.interfaces_service.service.impl.InterfacesServiceImpl;
//import com.mock.interfaces_service.service.impl.MappingService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 接口服务启动时，接口的自动注册监听器
 * @Author 翁丞健
 * @Date 2022/1/22 21:11
 * @Version 1.0.0
 */
public class ApplicationStartedCompletedListener implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        ConfigurableApplicationContext applicationContext = event.getApplicationContext();

        RegisterController registerController = applicationContext.getBean(RegisterController.class);

        Assert.notNull(registerController,"注册控制器不能为null");

//        MappingService mappingService = applicationContext.getBean(MappingService.class);

        Assert.notNull(registerController,"注册器不能为null");

        InterfacesServiceImpl interfacesService = applicationContext.getBean(InterfacesServiceImpl.class);

        Assert.notNull(registerController,"接口服务实例不能为null");

        List<InterfacesVO> interfaces =interfacesService.listVO();

        // 对每个接口逐一进行注册
        for(InterfacesVO vo : interfaces){
//            mappingService.addMapping(vo);
        }

    }
}
