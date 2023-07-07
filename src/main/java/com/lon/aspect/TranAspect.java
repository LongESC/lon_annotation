package com.lon.aspect;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lon.annotation.TranField;
import com.lon.annotation.TransTarget;
import com.lon.annotation.TransType;
import com.lon.annotation.Translate;
import com.lon.comomon.Result;
import com.lon.mapper.BaseMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;


/**
 * @projectName: lon_annotation
 * @package: com.lon.aspect
 * @className: TranAspect
 * @author: LONZT
 * @description: TODO
 * @date: 2023/6/26 10:05
 * @version: 1.0
 */
@Aspect
@Component
public class TranAspect {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*切点，所有web下的controller类的方法*/

    public final BaseMapper baseMapper;

    public TranAspect(BaseMapper baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Pointcut( "@annotation(com.lon.annotation.Translate)")
    public void tran(){}

    @Before("tran()")
    public Object doBefore(JoinPoint joinPoint) throws ClassNotFoundException {
        logger.info("--------Trans Params-----------");
        Translate translate = getInter(joinPoint);
        if (translate.target().equals(TransTarget.PARAMS)) {

            Object[] args = joinPoint.getArgs();
            System.out.println(args[0].toString());

            return null;
        }
        return null;
    }

    @After("tran()")
    public void doAfter(){

    }


    // 返回值
    @AfterReturning(returning = "result",pointcut = "tran()")
    public Result doAfterReturn(JoinPoint joinPoint,Object result) throws NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        logger.info("--------Trans Result-----------");
        Translate translate = getInter(joinPoint);

        if (translate.target().equals(TransTarget.RESULT)){

            Result res = (Result)result;
            Page<Object> page=(Page<Object>)res.getData();
            List<Object> users= (List<Object>) toTransList(page.getRecords());

            return Result.success(page.setRecords(users));


        }


        return null;
    }
    /**
     * @param joinPoint:
      * @return Translate
     * @author lonzt
     * @description 获取注解信息
     * @date 2023/6/30 9:40
     */
    public Translate getInter(JoinPoint joinPoint) throws ClassNotFoundException {

        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    Translate translate = method.getAnnotation(Translate.class);
                    return translate;
                }
            }
        }
        return null;
    }
    /**
     * @param list:
      * @return Object
     * @author lonzt
     * @description 字典翻译
     * @date 2023/6/30 9:43
     */

    public  Object toTransList(List<Object> list){
        if (list == null || list.isEmpty()) {
            return null;
        }
        //获取属性列表
        Field[] fields = list.get(0).getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field.getAnnotations() != null) {
                    //确定注解类型
                    if (field.isAnnotationPresent(TranField.class)) {
                        //允许修改反射属性
                        field.setAccessible(true);
                        TranField tranField = field.getAnnotation(TranField.class);
                        String type = tranField.type();

                        if (type.equals(TransType.SIMPLE)){
                            String tableFieldValue = tranField.tableField();
                            String tableMapField = tranField.tableMapField();
                            String tableName = tranField.tableName();
                            for (Object o : list) {
                                String value = (String) field.get(o);
                                String tarnValue = baseMapper.findField(tableName, tableFieldValue, tableMapField + "=" + value);
                                field.set(o,tarnValue);
                            }
                        }

                        if (type.equals(TransType.DICTIONARY)){

                            for (Object o : list) {
                                String value = (String) field.get(o).toString();

                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }





}
