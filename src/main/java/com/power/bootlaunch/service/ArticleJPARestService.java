package com.power.bootlaunch.service;

import com.power.bootlaunch.jpa.testdb.Article;
import com.power.bootlaunch.jpa.testdb.ArticleRepository;
import com.power.bootlaunch.jpa.testdb2.Message;
import com.power.bootlaunch.jpa.testdb2.MessageRepository;
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
    private MessageRepository messageRepository;

    public void saveArticle(Article article) {
        articleRepository.save(article);

        Message message = new Message();
        message.setName("666");
        message.setContent("fine !");
        messageRepository.save(message);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    public void updateArticle(Article article) {
        articleRepository.save(article);
    }

    public Optional<Article> getArticle(Long id) {
        return articleRepository.findById(id);
    }

    public List<Article> getAll() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("author").ascending()
                .and(Sort.by("createTime").descending()));
        // 按照author的升序排序，再按照createTime的降序进行排序
        Page<Article> articlePage = articleRepository.findAll(pageable);
        return articlePage.getContent();
    }
}