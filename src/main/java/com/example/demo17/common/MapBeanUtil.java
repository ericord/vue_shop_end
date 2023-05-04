package com.example.demo17.common;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
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

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}