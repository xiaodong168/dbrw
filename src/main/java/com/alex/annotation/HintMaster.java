package com.alex.annotation;

import java.lang.annotation.*;

/**
 * Created by xiaodong.liu on 2018/6/17.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HintMaster {
}
