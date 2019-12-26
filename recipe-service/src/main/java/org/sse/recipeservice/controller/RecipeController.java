package org.sse.recipeservice.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sse.recipeservice.model.Recipe;
import org.sse.recipeservice.service.RecipeService;


/**
 * @author HPY
 */
@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    RecipeService recipeService;

    @GetMapping("/get-list")
    public PageInfo<Recipe> getPageOfRecipe(@RequestParam("page-num") int pageNum,
                                            @RequestParam("page-size") int pageSize){
        return recipeService.getPageOfRecipeByDefault(pageNum, pageSize);
    }

//    @GetMapping("/hello")
//    public String getPageOfRecipe(){
//        return "hellooo";
//    }
}
