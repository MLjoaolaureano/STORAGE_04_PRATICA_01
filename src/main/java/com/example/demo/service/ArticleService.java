package com.example.demo.service;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleRepo repo;

    @Override
    public Article save(Article article) {
        return repo.save(article);
    }

    @Override
    public List<Article> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Article> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public void delete(String id) {
        repo.deleteById(id);
    }

    @Override
    public Article update(Article article) {
        return repo.save(article);
    }

}