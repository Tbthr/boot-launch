package com.power.bootlaunch.service;

import com.power.bootlaunch.dao.ArticleJDBCDAO;
import com.power.bootlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleRestJDBCService{

    @Resource
    private ArticleJDBCDAO articleJDBCDAO;
    @Resource
    private JdbcTemplate primaryJdbcTemplate;
    @Resource
    private JdbcTemplate secondaryJdbcTemplate;

    @Transactional //保证saveArticle方法一旦有异常，所有的数据库操作就回滚
    public void saveArticle(Article article) {
        articleJDBCDAO.save(article,primaryJdbcTemplate);
        articleJDBCDAO.save(article,secondaryJdbcTemplate);
        int a = 2/0;  //人为制造一个异常，用于测试事务
    }

    public void deleteArticle(Long id){
        articleJDBCDAO.deleteById(id,primaryJdbcTemplate);
    }

    public void updateArticle(Article article,Long id){
        articleJDBCDAO.updateById(article,id,primaryJdbcTemplate);
    }

    public Article getArticle(Long id){
        return articleJDBCDAO.findById(id,primaryJdbcTemplate);
    }

    public List<Article> getAll(){
        return articleJDBCDAO.findAll(primaryJdbcTemplate);
    }
}