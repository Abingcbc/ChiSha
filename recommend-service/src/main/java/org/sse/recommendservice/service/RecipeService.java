package org.sse.recommendservice.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sse.recommendservice.mapper.RecipeMapper;
import org.sse.recommendservice.model.Recipe;

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
}
