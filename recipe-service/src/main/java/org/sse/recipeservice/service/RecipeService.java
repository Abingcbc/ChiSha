package org.sse.recipeservice.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sse.recipeservice.dto.RecipeDTO;
import org.sse.recipeservice.mapper.RecipeMapper;
import org.sse.recipeservice.model.Recipe;


import java.util.List;

/**
 * @author HPY
 */
@Service
public class RecipeService {
    @Autowired
    RecipeMapper recipeMapper;

    public PageInfo<Recipe> getPageOfRecipeByDefault(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Recipe> list = recipeMapper.getPageOfRecipe();
        return new PageInfo<>(list);
    }

    public PageInfo<Recipe> getPageOfRecipeByKeyword(String keyword, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Recipe> recipeList = recipeMapper.getRecipeByKeyword("%" + keyword +"%");
        return new PageInfo<>(recipeList);
    }

    public PageInfo<Recipe> getPageOfRecipeByStyle(int styleId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Recipe> recipeList = recipeMapper.getRecipeByStyle(styleId);
        return new PageInfo<>(recipeList);
    }

    public RecipeDTO getDetailOfRecipeById(long recipeId){
        RecipeDTO recipeDTO = recipeMapper.getRecipeById(recipeId);
        recipeDTO.setIngredients(recipeMapper.getIngredientsByRecipeId(recipeId));
        recipeDTO.setSeasonings(recipeMapper.getSeasoningsByRecipeId(recipeId));
        recipeDTO.setStyles(recipeMapper.getStylesByRecipeId(recipeId));
        recipeDTO.setTastes(recipeMapper.getTastesByRecipeId(recipeId));
        return recipeDTO;
    }

    public boolean userBrowseRecipe(long recipeId, long userId) {
        return recipeMapper.insertBrowse(recipeId,userId);
    }
}
