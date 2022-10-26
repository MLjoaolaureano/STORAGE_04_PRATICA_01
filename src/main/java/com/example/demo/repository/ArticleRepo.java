package com.example.demo.repository;

import com.example.demo.model.Article;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleRepo extends ElasticsearchRepository<Article, String> {
    @Query("{\"match_all\": {}}")
    List<Article> findAll();
}