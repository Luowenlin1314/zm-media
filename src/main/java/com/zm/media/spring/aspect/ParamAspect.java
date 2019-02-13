package com.zm.media.spring.aspect;

import com.zm.media.common.util.HttpHelper;
import com.zm.media.common.util.JacksonUtils;
import com.zm.media.core.annotation.Parameter;
import com.zm.media.core.base.aspect.BaseAspect;
import com.zm.media.core.exception.ParameterNullException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一处理参数为空的请求
 * Author: wangkaijin
 * Date: 2017/9/19
 */
@Slf4j
@Component
@Aspect
public class ParamAspect extends BaseAspect {
    @Pointcut("@annotation(com.zm.media.core.annotation.Parameter)")
    public void parameter() {
    }

    @Before(value = "parameter()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 获取自定义注解
        Parameter param = getAnnotation(joinPoint, Parameter.class);
        String[] requiredFields = param.value();
        //获取HttpServletRequest
        HttpServletRequest request = getHttpServletRequest();

        Map<String,Object> paramMap = null;

        if (request.getMethod().equals(HttpMethod.POST.name()) || request.getMethod().equals(HttpMethod.PUT.name())) {
            String body = HttpHelper.getBodyString(request);
            paramMap = JacksonUtils.json2Map(body);

        } else if (request.getMethod().equals(HttpMethod.DELETE.name()) || request.getMethod().equals(HttpMethod.GET.name())) {
            paramMap = new HashMap<>();
            Enumeration<String> enumeration = request.getParameterNames();
            while (enumeration.hasMoreElements()){
                String parameter = enumeration.nextElement();
                paramMap.put(parameter,request.getParameter(parameter));
            }
        }
        checkParam(requiredFields, paramMap);
    }

    /**
     * 检查参数是否为空
     * @param requiredFields
     * @param paramMap
     * @throws ParameterNullException
     */
    private void checkParam(String[] requiredFields, Map<String,Object> paramMap) throws ParameterNullException {
        if (requiredFields != null && requiredFields.length > 0) {
            if (paramMap == null || paramMap.size() <= 0) {
                throw new ParameterNullException();
            } else {
                for (String requiredField : requiredFields) {
                    if (!paramMap.containsKey(requiredField) || (paramMap.containsKey(requiredField) && StringUtils.isEmpty(paramMap.get(requiredField).toString()))) {
                        throw new ParameterNullException();
                    }
                }
            }
        }
    }

}
