package com.backend.ecommerce.Controller;


import com.backend.ecommerce.Entity.Category;
import com.backend.ecommerce.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/category")
public class CategoryController {

    private CategoryService categoryService;

    // build create User REST API
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody  Category category){
        Category categoryObject = categoryService.createCategory(category);
        return new ResponseEntity<>(categoryObject, HttpStatus.CREATED);
    }


    // http://localhost:8080/api/category/1
    @GetMapping("{Id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("Id") Long categoryId){
        Category category = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

   @GetMapping("/showAllCategories")
    public ResponseEntity<List<Category>> getCategoryList(){
    List<Category> categoryObject = categoryService.getAllCategories();
    return  new ResponseEntity<>(categoryObject,HttpStatus.OK);
   }

   @PutMapping("updated/{Id}")
    public ResponseEntity<Category> getUpdateById(@PathVariable("Id") Long categoryId,
                                                  @RequestBody Category category){

        category.setId(categoryId);
        categoryService.updateCategory(category);
        return  new ResponseEntity<>(category,HttpStatus.OK);
   }

   @DeleteMapping("delete/{Id}")
    public ResponseEntity<String> deleteById(@PathVariable("Id") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return  new ResponseEntity<>("Category Succesfully deletec",HttpStatus.OK);
   }






}
