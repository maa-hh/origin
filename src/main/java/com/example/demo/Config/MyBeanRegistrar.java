package com.example.demo.Config;

import com.example.demo.Sever.sever;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyBeanRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 定义 BeanDefinition
        RootBeanDefinition beanDefinition = new RootBeanDefinition(sever.class);

        // 注册 Bean，指定 Bean 名称
        registry.registerBeanDefinition("sever2", beanDefinition);
    }
}

