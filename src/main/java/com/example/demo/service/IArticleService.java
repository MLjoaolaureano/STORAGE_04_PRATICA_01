package com.example.demo.service;

import com.example.demo.model.Article;

import java.util.List;
import java.util.Optional;

public interface IArticleService {
    Article save(Article article);

    List<Article> findAll();

    Optional<Article> findById(String id);

    void delete(String id);

    Article update(Article article);
}
