package com.power.bootlaunch.service;

import com.power.bootlaunch.dao.Article;
import com.power.bootlaunch.model.ArticleVO;
import com.power.bootlaunch.repository.ArticleRepository;
import org.dozer.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleJPARestService {

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private Mapper dozerMapper;

    public void saveArticle(ArticleVO article) {

        Article articlePO = dozerMapper.map(article,Article.class);
        articleRepository.save(articlePO);    //保存一个对象到数据库，insert

    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);   //根据id删除1条数据库记录
    }

    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleRepository.save(articlePO);   //更新一个对象到数据库，仍然使用save方法
    }

    public ArticleVO getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);  //根据id查找一条数据
        return dozerMapper.map(article,ArticleVO.class);
    }

    public List<Article> getAll() {
        Pageable pageable = PageRequest.of(0, 10,Sort.by("author").ascending()
                .and(Sort.by("createTime").descending()));
        // 按照author的升序排序，再按照createTime的降序进行排序

        Page<Article> articlePage = articleRepository.findAll(pageable);
        return articlePage.getContent();
    }
}