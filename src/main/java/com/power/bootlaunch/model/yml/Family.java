package com.power.bootlaunch.model.yml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Data
@Component
@Validated //配合@ConfigurationProperties进行属性校验
@ConfigurationProperties(prefix = "family") //批量注入
public class Family {

    //    @Value("${family.family-name}") //单个注入

    @NotEmpty
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;


//                                @ConfigurationProperties        @Value
//    功能	                    批量注入属性到java类	            一个个属性指定注入
//    松散语法绑定	            支持	                        不支持
//    SpEL	                    不支持	                        支持
//    复杂数据类型(对象、数组)	支持	                        不支持
//    JSR303数据校验	            支持	                        不支持

}