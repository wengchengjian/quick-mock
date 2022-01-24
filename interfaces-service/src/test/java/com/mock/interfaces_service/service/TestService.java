package com.mock.interfaces_service.service;

import com.mock.interfaces_service.controller.InterfaceMappingController;
import com.mock.interfaces_service.controller.RegisterController;
import com.mock.interfaces_service.interceptor.InterfaceProxyImpl;
import javassist.*;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.core.OverridingClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author 翁丞健
 * @Date 2022/1/23 12:47
 * @Version 1.0.0
 */
public class TestService {
    @Test
    public void test() throws Exception {
        ClassPool pool = ClassPool.getDefault();

        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        OverridingClassLoader overridingClassLoader = new OverridingClassLoader(loader);


        CtClass cc = getCtClass(pool,"test1");

        Class aClass = cc.toClass(overridingClassLoader);



        CtClass ccc = getCtClass(pool,"test2");

        Class bClass = ccc.toClass(overridingClassLoader);


        Object o = bClass.newInstance();

        Method[] declaredMethods = bClass.getDeclaredMethods();

        for (Method method : declaredMethods) {
            System.out.println(method.invoke(o));
        }

//        Class<?> aClass = ccc.toClass();
//
//
//
//        Object o = aClass.newInstance();
//
//        Method test1 = aClass.getMethod("test1");
//        Method test2 = aClass.getMethod("test2");
//
//        System.out.println(test1.invoke(o));
//        System.out.println(test2.invoke(o));

    }

    private CtClass getCtClass(ClassPool pool,String methodName) throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CtClass cc = pool.get(RegisterController.class.getName());

        cc.setName(methodName);

        String responseText = methodName;

        CtMethod ctMethod = new CtMethod(pool.get("java.lang.String"), methodName, new CtClass[]{}, cc);

        ctMethod.setModifiers(Modifier.PUBLIC);

        ctMethod.setBody("{return \""+responseText+"\";}");

        cc.addMethod(ctMethod);

        return cc;
    }

    @Test
    public void test2(){
        System.out.println(RegisterController.class.getSimpleName());
    }

    @Test
    public void test3() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.mock.interfaces_service.service.PersonService");

        CtMethod personFly = cc.getDeclaredMethod("personFly");

        personFly.insertBefore("System.out.println(\"起飞之前准备降落伞\");");
        personFly.insertAfter("System.out.println(\"成功落地。。。。\");");


        //新增一个方法
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "joinFriend", new CtClass[]{}, cc);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody("{System.out.println(\"i want to be your friend\");}");
        cc.addMethod(ctMethod);

        Object person = cc.toClass().newInstance();
        // 调用 personFly 方法
        Method personFlyMethod = person.getClass().getMethod("personFly");
        personFlyMethod.invoke(person);
        //调用 joinFriend 方法
        Method execute = person.getClass().getMethod("joinFriend");
        execute.invoke(person);
    }

    @Test
    public void test4(){
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(InterfaceMappingController.class);

        enhancer.setCallback(new InterfaceProxyImpl());


        InterfaceMappingController trait =  (InterfaceMappingController) enhancer.create();

        System.out.println(trait.toString());
    }
}

class PersonService {

    public void getPerson(){
        System.out.println("get Person");
    }

    public void personFly(){
        System.out.println("oh my god,I can fly");
    }
}
