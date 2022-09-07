package case_management.data.service;

import case_management.data.entities.CategoryEntity;
import case_management.data.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryEntity> getCategories () {return  categoryRepository.findAll();}

    public CategoryEntity getCategory (int id) {return  categoryRepository.findById(id);}


    public void saveOrUpdateCategory(CategoryEntity category) {

        categoryRepository.save(category);
    }

    public void deleteCategory(int categoryId) {
        boolean exists = categoryRepository.existsById(categoryId);
        if (!exists) {
            throw new IllegalStateException("category with id " + categoryId + " does not exist");
        }
        CategoryEntity category = categoryRepository.findById(categoryId);
        category.setDeleted(true);
        categoryRepository.save(category);
    }


    public List<CategoryEntity> filterCategories(String search) {
        List<CategoryEntity> categories;
        if(search != null)
        {
            categories=categoryRepository.findByTitle(search);
        }
        else
            categories = categoryRepository.findAll();
        return categories;
    }
}
