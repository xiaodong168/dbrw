package com.alex.annotation;

import io.shardingsphere.core.api.HintManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by xiaodong.liu on 2018/6/17.
 */
@Service
@Aspect
public class HintMasterAspect {
    private Logger logger = LoggerFactory.getLogger(HintMasterAspect.class);

    public HintMasterAspect() {

    }

    @Pointcut(value = "execution(@HintMaster * *.*(..))")
    public void setMaster() {
    }

    /**
     * aop实现注解
     *
     * @param joinPoint
     * @return
     */
    // @Around("setMaster()")
    @Around("@annotation(hintMaster)")
    public Object setMasterOnly(ProceedingJoinPoint joinPoint, HintMaster hintMaster) {
        Object object=null;
        HintManager hintManager = HintManager.getInstance();
        hintManager.setMasterRouteOnly();
        logger.debug("set masterRouteOnly");
        try {
            object=joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            hintManager.close();
            logger.debug("clean flag[masterRouteOnly]");
            return object;
        }

    }

}
