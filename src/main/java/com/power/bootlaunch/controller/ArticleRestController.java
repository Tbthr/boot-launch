package com.power.bootlaunch.controller;

import com.power.bootlaunch.model.ArticleVO;
import com.power.bootlaunch.service.ArticleJPARestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    @Resource
    ArticleJPARestService articleJPARestService;

    @PostMapping(value = "/articles")
    public AjaxResponse saveArticle(@RequestBody ArticleVO article) {
       articleJPARestService.saveArticle(article);
        return AjaxResponse.success(article);
    }

    @DeleteMapping(value = "/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        articleJPARestService.deleteArticle(id);
        return AjaxResponse.success(id);
    }

    @PutMapping(value = "/articles/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody ArticleVO article) {
        articleJPARestService.updateArticle(article);
        return AjaxResponse.success(article);
    }

    @GetMapping(value = "/articles/{id}")
    public AjaxResponse getArticle(@PathVariable Long id) {
        return AjaxResponse.success(articleJPARestService.getArticle(id));
    }

    @GetMapping(value = "/articles")
    public AjaxResponse getArticle() {
        return AjaxResponse.success(articleJPARestService.getAll());
    }
}