package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @PostMapping
    public ResponseEntity<Article> insert(@RequestBody Article article) {
        Article newArticle = service.save(article);
        return new ResponseEntity<>(newArticle, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Article>> getAll() {
        List<Article> articles = service.findAll();

        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> findById(@PathVariable String id) {
        Optional<Article> article = service.findById(id);

        if (article.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(article.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>("Artigo removido", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Article> update(@RequestBody Article article) {
        Article articleUpdated = service.update(article);

        return new ResponseEntity<>(articleUpdated, HttpStatus.OK);
    }
}