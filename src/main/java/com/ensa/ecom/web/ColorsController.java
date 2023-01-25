package com.ensa.ecom.web;


import com.ensa.ecom.entities.Colors;
import com.ensa.ecom.services.ColorsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Colors")
public class ColorsController {


    private final ColorsServices colorsServices;

    public ColorsController(ColorsServices colorsServices) {this.colorsServices = colorsServices;}

    @GetMapping("/all")
    public ResponseEntity<List<Colors>> getAllCategories () {
        List<Colors> colorsList = colorsServices.findAllColors();
        return new ResponseEntity<>(colorsList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Colors> getCategoryById (@PathVariable("id") Long id) {
        Colors category = colorsServices.findColorById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Colors> addCategory(@RequestBody Colors colors) {
        Colors newColor = colorsServices.addColor(colors);
        return new ResponseEntity<>(newColor, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Colors> updateCategory(@RequestBody Colors category) {
        Colors updateColor = colorsServices.updateColor(category);
        return new ResponseEntity<>(updateColor, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) {
        colorsServices.deleteColor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
