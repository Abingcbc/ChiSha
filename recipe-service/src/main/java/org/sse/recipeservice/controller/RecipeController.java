package org.sse.recipeservice.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sse.recipeservice.dto.SearchDTO;
import org.sse.recipeservice.model.Recipe;
import org.sse.recipeservice.service.RecipeService;

import javax.websocket.server.PathParam;


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

    @PostMapping("/search")
    public PageInfo<Recipe> searchRecipeByKeyword(@RequestBody SearchDTO searchDTO,
                                                  @RequestParam("page-num") int pageNum,
                                                  @RequestParam("page-size") int pageSize){
        return recipeService.getPageOfRecipeByKeyword(searchDTO.getKeyword(), pageNum, pageSize);

    }

    @GetMapping("/get-list-by-style/{styleId}")
    public PageInfo<Recipe> getPageOfRecipeByStyle(@PathVariable("styleId") int styleId,
                                                   @RequestParam("page-num") int pageNum,
                                                   @RequestParam("page-size") int pageSize){
        return recipeService.getPageOfRecipeByStyle(styleId, pageNum, pageSize);

    }

}
