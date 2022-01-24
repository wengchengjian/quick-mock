package com.mock.interfaces_service.utils;

import javassist.*;
import org.springframework.util.Assert;

import java.lang.reflect.Method;

/**
 * @Author 翁丞健
 * @Date 2022/1/23 13:04
 * @Version 1.0.0
 */
public class MethodRegister {
    public static final void  register(String methodName,String responseText) throws Exception{


        Assert.notNull(methodName,"方法名称不能为空!");

        ClassPool pool = ClassPool.getDefault();

        CtClass cc = pool.get("com.mock.interfaces_service.controller.RegisterController");

        CtMethod ctMethod = new CtMethod(pool.get("java.lang.String"), methodName, new CtClass[]{}, cc);

        ctMethod.setModifiers(Modifier.PUBLIC);

        ctMethod.setBody("{return \""+responseText+"\";}");

        cc.addMethod(ctMethod);
    }
}
