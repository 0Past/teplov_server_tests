package com.teplov.service;

import com.teplov.entity.Category;
import com.teplov.repository.CategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService service;

    @MockBean
    private CategoryRepository repository;

    @Test
    public void findAll() {
        ArrayList<Category> expected = new ArrayList<>();
        Category category = new Category();
        expected.add(category);
        Mockito.when(service.findAll()).thenReturn(expected);
        Assert.assertEquals(service.findAll(), expected);
    }
    @Test
    public void findById() {
        Optional<Category> expected = Optional.of(new Category());

        Mockito.doReturn(expected)
                .when(repository)
                .findById(1L);
        Assert.assertEquals(expected, service.findById(1L));
    }

    @Test
    public void create() {
        Category category = new Category();
        Category expected = new Category();

        Mockito.doReturn(expected)
                .when(repository)
                .save(category);
        Assert.assertEquals(expected, service.create(category));
    }

    @Test
    public void delete() {
        Mockito.doReturn(Optional.of(new Category()))
                .when(repository)
                .findById(1L);
        Assert.assertTrue(service.delete(1L));
    }

    @Test
    public void update() {
        Mockito.doReturn(Optional.of(new Category()))
                .when(repository)
                .findById(1L);
        Assert.assertTrue(service.update(new Category(), 1L));
    }
}
