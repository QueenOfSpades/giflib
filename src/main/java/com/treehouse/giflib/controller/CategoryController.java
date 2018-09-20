package com.treehouse.giflib.controller;

import com.treehouse.giflib.data.CategoryRepository;
import com.treehouse.giflib.data.GifRepository;
import com.treehouse.giflib.model.Category;
import com.treehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String listCategory(ModelMap modelMap){
        List<Category> categories = categoryRepository.getAllCategory();
        modelMap.put("categories", categories);
        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String getCategory(@PathVariable int id, ModelMap modelMap){
        Category aCategory = categoryRepository.findById(id);
        modelMap.put("category", aCategory);

        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs", gifs);

        return "category";
    }

}
