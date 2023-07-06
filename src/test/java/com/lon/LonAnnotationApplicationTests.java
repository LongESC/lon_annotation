package com.lon;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SqlRunner;
import com.lon.annotation.TranField;
import com.lon.entity.User;
import com.lon.mapper.BaseMapper;
import com.lon.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@SpringBootTest
class LonAnnotationApplicationTests {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public BaseMapper baseMapper;



    public Field[] toJson(Object src) {

        //获得成员变量
        Field[] fields = src.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field.getAnnotations() != null) {
                    //确定注解类型
                    if (field.isAnnotationPresent(TranField.class)) {
                        //允许修改反射属性
                        field.setAccessible(true);
                        TranField tranField = field.getAnnotation(TranField.class);
//                        String name = tranField.value();
//                        String value = (String) field.get(src);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fields;
    }

    @Test
    void contextLoads() throws IllegalAccessException {
        QueryWrapper queryWrapper=new QueryWrapper<>().eq("name","赵腾龙");

        User user= userMapper.selectOne(queryWrapper);

        //获得成员变量
        Field[] fields = user.getClass().getDeclaredFields();
        System.out.println(fields);
        for (Field field : fields) {

            try {
                field.setAccessible(true);
                System.out.println(field.getAnnotatedType());
                if (field.getAnnotations() != null) {
                    Annotation[] annotations = field.getAnnotations();
                        //确定注解类型
                        if(field.isAnnotationPresent(TranField.class)) {
                            //允许修改反射属性
                            TranField tranField = field.getAnnotation(TranField.class);
                            field.set(user,"信息化中心");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(user);
    }


    @Test
    void sss() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        QueryWrapper queryWrapper=new QueryWrapper<>().eq("name","赵腾龙");

        List<Map<String , Object>> mapList = userMapper.selectMaps(queryWrapper);
        mapList.forEach(System.out::println);
        User user= userMapper.selectOne(queryWrapper);
        Class c = Class.forName("com.lon.entity.User");
        Object o= c.newInstance();
        o=userMapper.selectOne(queryWrapper);
        System.out.println(o);

        // getFields():获取当前运行时类及其父类中声明为public的属性
//        Field[] fields = c.getFields();
//        for (Field field : fields) {
//            System.out.println(field.get(o));
//
//        }

       // getDeclaredFields()：获取当前运行时类的所有属性（不包括父类的属性）
        Field[] declaredFields = c.getDeclaredFields();

        for (Field field : declaredFields) {
            System.out.println(field);

        }

        Method[] methods = c.getMethods();

//        for (Method method : methods) {
//            System.out.println(method);
//        }
        Method[] declaredMethods = c.getDeclaredMethods();
//        for (Method method : declaredMethods) {
//            System.out.println(method);
//        }
        System.out.println(o);
    }

    @Test
    void sssss() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//        QueryWrapper<Object> queryWrapper=new QueryWrapper<>().eq("name","赵腾龙");

        QueryWrapper queryWrapper=new QueryWrapper<>().like("name","赵");

        List<Map<String , Object>> mapList = userMapper.selectMaps(queryWrapper);
        mapList.forEach(System.out::println);
    }



    @Test
    void test() {
//        String nodeTableName = "md_user";
//
//        System.out.println(SqlRunner.db().selectOne("select * from " + nodeTableName));

        List<Map<String, Object>> maps = SqlRunner.db().selectList("select id,name from dic_dept where id>999 and id <10000");

        for (Map map : maps) {

            System.out.println(map.get("name"));

        }
        System.out.println(maps);
    }




    @Test
    void ssssssssssssss(){
        String sql = "select id,pid,name from dic_dept where id>999 and id <10000";
        List<Map<String,Object>> o = baseMapper.nativeSql(sql);

        System.out.println(o);
    }

    @Test
    void sssssssssssssss(){
        String sql = "select id,pid,name from dic_dept where id>999 and id <10000";
        List<Map<String,Object>> o = baseMapper.findFields("dic_dept","id,name","id>999 and id <10000");

        System.out.println(o);
    }



}
