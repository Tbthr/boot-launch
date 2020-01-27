package com.power.bootlaunch.service;

import com.power.bootlaunch.dao.Article;
import com.power.bootlaunch.model.ArticleVO;
import com.power.bootlaunch.repository.ArticleRepository;
import com.power.bootlaunch.utils.DozerUtils;
import org.dozer.Mapper;
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

    public List<ArticleVO> getAll() {
        List<Article> articleLis = articleRepository.findAll();  //查询article表的所有数据
        return DozerUtils.mapList(articleLis,ArticleVO.class);
    }
}