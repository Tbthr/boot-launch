package com.power.bootlaunch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data //成员变量的get和set方法、equals方法、canEqual方法、hashCode方法、toString方法
@AllArgsConstructor //全参构造函数
@NoArgsConstructor //无参构造函数
@Builder //对象属性赋值
//@JsonPropertyOrder(value={"content","title"}) //改变子属性在JSON序列化中的默认定义的顺序
public class ArticleVO {

//    @JsonIgnore //排除某个属性不做序列化与反序列化
    private Long id;

//    @JsonProperty("auther") //为某个属性换一个名称，体现在JSON数据里面
    private String author;
    private String title;
    private String content;

//    @JsonInclude(JsonInclude.Include.NON_NULL) //排除为空的元素不做序列化反序列化
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") //指定日期类型的属性格式
    private Date createTime;
    private List<Reader> reader;

}
