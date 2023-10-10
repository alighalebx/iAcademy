package com.example.iacdemy.aspect;

import org.apache.tomcat.util.buf.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Aspect
@Component
public class LogTimeAspect {

    Logger log = LoggerFactory.getLogger(LogTimeAspect.class);

    @Around(value = "execution(* com.example.iacdemy.services..*(..))")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("KPI:");
        sb.append("[").append(joinPoint.getKind()).append("]\tfor: ").append(joinPoint.getSignature())
                .append("\twithArgs: ").append("(").append(joinPointArgsToString(joinPoint.getArgs())).append(")");

        sb.append("\ttook: ");
        Object returnValue = joinPoint.proceed();
        log.info(sb.append(System.currentTimeMillis() - startTime).append(" ms. ").toString());

        return returnValue; // Don't forget to call the original method
    }

    private String joinPointArgsToString(Object[] args) {
        Collection<String> argStrings = Arrays.asList(Arrays.stream(args)
                .map(Object::toString)
                .toArray(String[]::new));
        return StringUtils.join(argStrings, ',');
    }
}
