package com.power.bootlaunch.model.yml;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

@Data
@Validated
public class Father {
    private String name;

    @Min(50)
    private Integer age;
//    校验失败则有：
//    Caused by: org.springframework.boot.context.properties.bind.validation.BindValidationException:
//    Binding validation errors on family.father
//   - Field error in object 'family.father' on field 'age': rejected value [21];
//   codes [Min.family.father.age,Min.age,Min.java.lang.Integer,Min];
//   arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [family.father.age,age];arguments []; default message [age],50];
//   default message [最小不能小于50]; origin class path resource [application.yml]:19:10

//    更多方法见：https://www.kancloud.cn/hanxt/springboot2/1177594
}
