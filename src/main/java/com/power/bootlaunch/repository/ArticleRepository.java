package com.power.bootlaunch.repository;

import com.power.bootlaunch.dao.Article;
import org.springframework.data.jpa.repository.JpaRepository;

// 提供了各种针对单表的数据操作方法：增删改查
public interface ArticleRepository extends JpaRepository<Article,Long> {

    //注意这个方法的名称，jPA会根据方法名自动生成SQL执行
    Article findByAuthor(String author);

}