package com.nefu.anno;

import com.nefu.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {StateValidation.class}
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface State {
    String message() default "state值只能为已发布或草稿";

    //指定分组
    Class<?>[] groups() default {};

    //负载 获取State注解附加信息
    Class<? extends Payload>[] payload() default {};
}
