package com.treehouse.giflib.data;

import com.treehouse.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private static final List<Category>  ALL_CATEGORY = Arrays.asList(
            new Category(1, "Weird"),
            new Category(2, "Cute"),
            new Category(3, "Scary"),
            new Category(4, "Other")
        );

    public List<Category> getAllCategory(){
        return ALL_CATEGORY;
    }

    public Category findById(int id){
        for( Category category : ALL_CATEGORY){
            if(category.getId() == id) {
                return category;
            }
        }
        return null;

    }
}
