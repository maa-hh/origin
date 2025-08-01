package com.example.demo.Config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.function.Predicate;
/*支持通过注解传参动态指定要导入的类；

支持按条件判断是否导入某个类；

支持从配置文件中读取导入逻辑（可选）；*/
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata metadata) {
        Map<String, Object> attrs = metadata
                .getAnnotationAttributes("com.example.demo.config.EnableMyService");

        if (attrs != null) {
            String[] classNames = (String[]) attrs.get("value");
            return classNames;
        }

        // 默认导入的类
        return new String[]{
                "com.example.demo.Sever.sever"
        };
    }
}

