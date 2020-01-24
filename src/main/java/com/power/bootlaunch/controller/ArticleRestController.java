package com.power.bootlaunch.controller;

import com.power.bootlaunch.model.Article;
import com.power.bootlaunch.service.ArticleRestJDBCService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {
/*
 * @RestController相当于 @Controller和@ResponseBody结合。
 * 它有两层含义：
 * 一是作为Controller的作用，将控制器类注入到Spring上下文环境，该类RequestMapping标注方法为HTTP服务端点。
 * 二是作为ResponseBody的作用，请求响应默认使用的序列化方式是JSON，而不是跳转到jsp或模板页面。
 */

//    @RequestMapping注解是所有常用注解中，最有看点的一个注解，用于标注HTTP服务端点。
//    value： 应用请求端点，最核心的属性，用于标志请求处理方法的唯一性；
//    method： HTTP协议的method类型， 如：GET、POST、PUT、DELETE等；
//    consumes： HTTP协议请求内容的数据类型（Content-Type），例如application/json, text/html;
//    produces: HTTP协议响应内容的数据类型。默认是使用JSON的格式
//    params： HTTP请求中必须包含某些参数值的时候，才允许被注解标注的方法处理请求。
//    headers： HTTP请求中必须包含某些指定的header值，才允许被注解标注的方法处理请求。

    @Resource
    ArticleRestJDBCService articleRestJDBCService;

    @PostMapping(value = "/articles")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        articleRestJDBCService.saveArticle(article);
        return AjaxResponse.success(article);
    }

    @DeleteMapping(value = "/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        articleRestJDBCService.deleteArticle(id);
        return AjaxResponse.success(id);
    }

    @PutMapping(value = "/articles/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article) {
        articleRestJDBCService.updateArticle(article,id);
        return AjaxResponse.success(article);
    }

    @GetMapping(value = "/articles/{id}")
    public AjaxResponse getArticle(@PathVariable Long id) {
        return AjaxResponse.success(articleRestJDBCService.getArticle(id));
    }

    @GetMapping(value = "/articles")
    public AjaxResponse getArticles(){
        return AjaxResponse.success(articleRestJDBCService.getAll());
    }
}