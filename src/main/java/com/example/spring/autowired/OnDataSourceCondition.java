package com.example.spring.autowired;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author 56465
 * @Create 2024/6/11 15:46
 */
public class OnDataSourceCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 这里只是一个示例，实际应用中你可以根据配置文件、环境变量等来决定条件是否满足
        // 假设我们检查一个名为"db.type"的配置项
        String dbType = context.getEnvironment().getProperty("db.type");
        System.out.println("=========== dbType =========== " + dbType);
        return "mysql".equals(dbType); // 如果配置db.type=mysql，则条件满足
    }
}
