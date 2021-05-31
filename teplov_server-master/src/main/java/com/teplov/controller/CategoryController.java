package com.teplov.controller;

import com.teplov.entity.Category;
import com.teplov.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер для класса {@link Category}
 */
@RestController
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     *Получение списка категорий
     * @return OK (весь список категорий) и NOT_FOUND, если список пуст
     */
    @GetMapping(value = "/categories")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.findAll();
        if (categories != null && !categories.isEmpty())
            return new ResponseEntity<>(categories, HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Добавление категории в список
     * @param category категория
     * @return добавленную категорию
     */
    @PostMapping(value = "/categories")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.CREATED);
    }
}
