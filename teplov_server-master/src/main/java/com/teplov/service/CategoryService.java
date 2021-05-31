package com.teplov.service;

import com.teplov.entity.Category;
import com.teplov.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для класса {@link Category}
 */
@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Получние всех записей из категорий
     * @return все категории
     */
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    /**
     * Получение записи по ее id
     * @param id идентификатор категории
     * @return запись по id
     */
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    /**
     * Создание категории
     * @param category категория
     * @return созданная категория
     */
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Удаление категории по ее id
     * @param id идентификатор категории
     * @return true, если категория удалилась и false, если категории с таким id нет
     */
    public boolean delete(Long id) {
        if (findById(id).isPresent()) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Обновление информации о категории по ее id
     * @param category категория
     * @param id идентификатор категории
     * @return обновленная информация
     */
    public boolean update(Category category, Long id) {
        if (findById(id).isPresent()) {
            category.setId(id);
            categoryRepository.save(category);
            return true;
        }
        return false;
    }
}
