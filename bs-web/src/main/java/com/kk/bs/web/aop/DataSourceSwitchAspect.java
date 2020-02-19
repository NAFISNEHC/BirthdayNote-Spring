package com.kk.bs.web.aop;

import com.kk.bs.plugins.mybatis.DBTypeEnum;
import com.kk.bs.plugins.mybatis.DataSourceSwitch;
import com.kk.bs.plugins.mybatis.DbContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author allahbin
 * @create 2019/8/2
 * @since 1.0.0
 */
@Aspect
@Component
public class DataSourceSwitchAspect {

    private final static Logger logger = LoggerFactory.getLogger(DataSourceSwitchAspect.class);

    @Pointcut("execution(* com.kk.bs.mapper.master.*.*(..))")
    private void db1Aspect() {
    }

    @Pointcut("execution(* com.kk.bs.mapper.master..*.*(..))")
    private void db2Aspect() {
    }

    @Before( "db1Aspect()" )
    public void db1(JoinPoint joinPoint) {
        logger.info("切换到master 数据源...");
        setDataSource(joinPoint, DBTypeEnum.db1);
    }

    @Before("db2Aspect()" )
    public void db2 (JoinPoint joinPoint) {
        logger.info("切换到minor 数据源...");
        setDataSource(joinPoint,DBTypeEnum.db2);
    }

    /**
     * 添加注解方式,如果有注解优先注解,没有则按传过来的数据源配置
     * @param joinPoint
     * @param dbTypeEnum
     */
    private void setDataSource(JoinPoint joinPoint, DBTypeEnum dbTypeEnum) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        DataSourceSwitch dataSourceSwitch = methodSignature.getMethod().getAnnotation(DataSourceSwitch.class);
        if (Objects.isNull(dataSourceSwitch)) {
            DbContextHolder.setDbType(dbTypeEnum);
        }else{
            dataSourceSwitch.value();
            logger.info("根据注解来切换数据源,注解值为:"+dataSourceSwitch.value());
            switch (dataSourceSwitch.value().getValue()) {
                case "master":
                    DbContextHolder.setDbType(DBTypeEnum.db1);
                    break;
                case "minor":
                    DbContextHolder.setDbType(DBTypeEnum.db2);
                    break;
                default:
                    DbContextHolder.setDbType(dbTypeEnum);
            }
        }
    }
}
