package org.sse.recommendservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sse.recommendservice.dto.QueryResult;
import org.sse.recommendservice.mapper.RecipeRelatedMapper;
import org.sse.recommendservice.mapper.UserRelatedMapper;
import org.sse.recommendservice.dto.BrowsingPlus;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

/**
 * @author cbc
 */
@Service
public class RecommendService {

    @Autowired
    UserRelatedMapper userRelatedMapper;

    @Autowired
    RecipeRelatedMapper recipeRelatedMapper;

    private static long ageSplit(long age) {
        if (age < 20) {
            return 0;
        } else if (age < 30) {
            return 1;
        } else if (age < 40){
            return 2;
        } else if (age < 50) {
            return 3;
        } else {
            return 4;
        }
    }

    public String getTrainData(int limitNum) {
        List<BrowsingPlus> browsingPlusArrayList = userRelatedMapper.getRecentBrowsingHistory(limitNum);
        Set<Long> userIdSet = new HashSet<>();
        Set<Long> recipeIdSet = new HashSet<>();
        for (BrowsingPlus browsing: browsingPlusArrayList) {
            userIdSet.add(browsing.getUserId());
            recipeIdSet.add(browsing.getRecipeId());
        }
        Map<Long, QueryResult> styleMap = userRelatedMapper.getUserPreferStyleBatch(userIdSet);
        Map<Long, QueryResult> tasteMap = userRelatedMapper.getUserPreferTasteBatch(userIdSet);
        Map<Long, QueryResult> recordMap = userRelatedMapper.getUserBrowsingBatch(userIdSet);
        Map<Long, QueryResult> recipeStyleMap = recipeRelatedMapper.getRecipeStyleBatch(recipeIdSet);
        Map<Long, QueryResult> recipeTasteMap = recipeRelatedMapper.getRecipeTasteBatch(recipeIdSet);
        Map<Long, QueryResult> recipeIngredientMap = recipeRelatedMapper.getRecipeIngredientBatch(recipeIdSet);
        Map<Long, QueryResult> recipeSeasoningMap = recipeRelatedMapper.getRecipeSeasoningBatch(recipeIdSet);

        ICsvListWriter writer = null;
        try {
            File file = new File("train.csv");
            if (file.exists()) {
                file.delete();
            }
            writer = new CsvListWriter(new FileWriter("train.csv"),
                    CsvPreference.STANDARD_PREFERENCE);
            String[] header = new String[]{
                    "gender", "age", "born_place", "style", "taste",
                    "hist_recipe", "recipe_id", "recipe_style",
                    "recipe_taste", "ingredient", "seasoning"
            };
            writer.writeHeader(header);
            for (BrowsingPlus browsing: browsingPlusArrayList) {
                List<Object> record = Arrays.asList(browsing.getGender(),
                        ageSplit(browsing.getAge()),
                        browsing.getBornPlace(),
                        styleMap.getOrDefault(browsing.getUserId(), new QueryResult()).getValue(),
                        tasteMap.getOrDefault(browsing.getUserId(), new QueryResult()).getValue(),
                        recordMap.getOrDefault(browsing.getUserId(), new QueryResult()).getValue(),
                        browsing.getRecipeId(),
                        recipeStyleMap.getOrDefault(browsing.getRecipeId(), new QueryResult()).getValue(),
                        recipeTasteMap.getOrDefault(browsing.getRecipeId(), new QueryResult()).getValue(),
                        recipeIngredientMap.getOrDefault(browsing.getRecipeId(), new QueryResult()).getValue(),
                        recipeSeasoningMap.getOrDefault(browsing.getRecipeId(), new QueryResult()).getValue()
                        );
                writer.write(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "train.csv";

    }
}
