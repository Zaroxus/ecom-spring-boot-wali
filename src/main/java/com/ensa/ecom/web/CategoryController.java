package com.ensa.ecom.web;

import com.ensa.ecom.entities.Category;
import com.ensa.ecom.services.CategoryServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryServices categoryServices;

    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories () {
        List<Category> colorsList = categoryServices.findAllCategories();
        return new ResponseEntity<>(colorsList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Category> getCategoryById (@PathVariable("id") Long id) {
        Category category = categoryServices.findCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category newColor = categoryServices.addCategory(category);
        return new ResponseEntity<>(newColor, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Category updateColor = categoryServices.updateCategory(category);
        return new ResponseEntity<>(updateColor, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) {
        categoryServices.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
