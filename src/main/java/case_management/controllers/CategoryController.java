package case_management.controllers;

import case_management.data.entities.CategoryEntity;
import case_management.data.repositories.CategoryRepository;
import case_management.data.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/category")
@Tag(name = "Category service", description = "Работа с категориями и содержимым онных")
public class CategoryController {

    @Autowired
    public final CategoryRepository categoryRepository;

    public final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository, CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public CategoryEntity getCategory(@PathVariable int id) {
        return categoryService.getCategory(id);
    }


    @GetMapping
    public List<CategoryEntity> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping()
    public void addNewCategory(@RequestBody CategoryEntity category) {

        categoryService.saveOrUpdateCategory(category);
    }


    @GetMapping("/filter")
    public List<CategoryEntity> getCategories(@RequestParam(required = false) String search) {
        return categoryService.filterCategories(search);
    }


    @PutMapping()
    public void saveCategory(@RequestBody CategoryEntity categoryEntity) {

        categoryService.saveOrUpdateCategory(categoryEntity);
    }

    @GetMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") int id) {

        categoryService.deleteCategory(id);
    }

}
