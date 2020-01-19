package com.power.bootlaunch.controller;

import com.power.bootlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //在编译期自动引入Logger日志常量，直接使用log.info或log.debug打印日志
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public Article hello (){
        Article article=Article.builder().age("18").name("lyq").build();

        log.info("日志测试"+article);

        return article;
    }

}