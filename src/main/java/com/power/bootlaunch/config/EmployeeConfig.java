package com.power.bootlaunch.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ConfigurationProperties") //压制警告
@Configuration
@PropertySource (name = "employeeProperties", value = "classpath:employee.properties")
@ConfigurationProperties
@Data
public class EmployeeConfig {

    @Value("#{'${employee.names}'.split(',')}") //以逗号为分隔符转换为List类型
    private List<String> employeeNames;

    @Value ("#{'${employee.names}'.split(',')[0]}") //获取第一个名字
    private String firstEmployeeName;

    @Value ("#{${employee.age}}") //将键值对、类对象的数据结构转换为java的Map数据类型
    private Map<String, Integer> employeeAge;

    @Value ("#{${employee.age}.two}") //根据Map的Key获取Value属性
    private String employeeAgeTwo;

    @Value ("#{${employee.age}['five'] ?: 31}") //如果key存在就获取对应的value，如果不存在就获得默认值31
    private Integer ageWithDefaultValue;


//    SpEL结合 @Value注解读取系统环境变量
    @Value ("#{systemProperties['java.home']}") //获取JAVA_HOME目录
    private String javaHome;

    @Value ("#{systemProperties['user.dir']}") //获取系统用户工作目录
    private String userDir;

// SpEL还可以完成算术运算、逻辑运算、正则匹配运算、条件运算等功能。
// 官方文档：https://docs.spring.io/spring/docs/4.3.10.RELEASE/spring-framework-reference/html/expressions.html
}