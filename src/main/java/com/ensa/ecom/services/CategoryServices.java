package com.ensa.ecom.services;

import com.ensa.ecom.dao.CategoryRepository;
import com.ensa.ecom.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServices {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServices(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category findCategoryById(Long id)
    {
        Optional<Category> optional = categoryRepository.findById(id);
        Category category = optional.get();
        return category;
    }

    public boolean find(Long id)
    {
        return categoryRepository.existsById(id);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteCategoryById(id);
    }
}
