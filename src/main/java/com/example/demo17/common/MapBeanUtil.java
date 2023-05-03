package com.example.demo17.common;

import com.alibaba.fastjson.JSON;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * (枚举单例常用工具类)Map与Java对象互转(包含处理和不处理驼峰)
 */
public class MapBeanUtil {
    public static <T> List<T> mapToBean(List resultList, Class<T> clazz) {
        String jsonString = JSON.toJSONString(resultList);
        List<T> beanList = JSON.parseArray(jsonString, clazz);
        return beanList;
    }
}