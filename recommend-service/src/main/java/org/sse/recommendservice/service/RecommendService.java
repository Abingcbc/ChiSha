package org.sse.recommendservice.service;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sse.recommendservice.dto.BrowsingPlus;
import org.sse.recommendservice.dto.QueryResult;
import org.sse.recommendservice.dto.RecommendRecipe;
import org.sse.recommendservice.dto.UserTrainField;
import org.sse.recommendservice.mapper.RecipeRelatedMapper;
import org.sse.recommendservice.mapper.UserRelatedMapper;
import org.sse.recommendservice.model.User;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;
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

    private List<String> convertLongList2StringList(List<Long> longList) {
        List<String> stringList = new ArrayList<>();
        Collections.reverse(longList);
        for (long l: longList) {
            stringList.add(String.valueOf(l));
        }
        return stringList;
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
        Map<Long, QueryResult> recipeStyleMap = recipeRelatedMapper.getRecipeStyleBatch(recipeIdSet);
        Map<Long, QueryResult> recipeTasteMap = recipeRelatedMapper.getRecipeTasteBatch(recipeIdSet);
        Map<Long, QueryResult> recipeIngredientMap = recipeRelatedMapper.getRecipeIngredientBatch(recipeIdSet);
        Map<Long, QueryResult> recipeSeasoningMap = recipeRelatedMapper.getRecipeSeasoningBatch(recipeIdSet);

        final String outputFilePath = "train.csv";
        ICsvListWriter writer = null;
        try {
            File file = new File(outputFilePath);
            if (file.exists()) {
                file.delete();
            }
            writer = new CsvListWriter(new FileWriter(outputFilePath),
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
                        String.join("|", convertLongList2StringList(userRelatedMapper.getUserBrowsingBefore(browsing.getUserId(), browsing.getBrowseTime()))),
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
        return outputFilePath;

    }

    public UserTrainField getUserTrainField(Long userId) {
        User user = userRelatedMapper.getUserById(userId);
        Map<Long, QueryResult> style = userRelatedMapper.getUserPreferStyleBatch(Sets.newHashSet(userId));
        Map<Long, QueryResult> taste = userRelatedMapper.getUserPreferTasteBatch(Sets.newHashSet(userId));

        return new UserTrainField(user.getGender(), user.getAge(), user.getBornPlace(),
                style.getOrDefault(userId, new QueryResult()).getValue(),
                taste.getOrDefault(userId, new QueryResult()).getValue(),
                String.join("|",
                        convertLongList2StringList(userRelatedMapper.getUserBrowsingBefore(userId, new Timestamp(System.currentTimeMillis())))));
    }

    public RecommendRecipe getRecommendRecipe(List<Long> idList) {
        RecommendRecipe recommendRecipe = new RecommendRecipe();
        recommendRecipe.setRecipeList(recipeRelatedMapper.getRecipeByIdBatch(idList));
        return recommendRecipe;
    }

    public String getAllRecipeTrainField() {
        List<Long> idList = recipeRelatedMapper.getAllRecipeId();
        Map<Long, QueryResult> recipeStyleMap = recipeRelatedMapper.getRecipeStyleBatch(new HashSet<>(idList));
        Map<Long, QueryResult> recipeTasteMap = recipeRelatedMapper.getRecipeTasteBatch(new HashSet<>(idList));
        Map<Long, QueryResult> recipeIngredientMap = recipeRelatedMapper.getRecipeIngredientBatch(new HashSet<>(idList));
        Map<Long, QueryResult> recipeSeasoningMap = recipeRelatedMapper.getRecipeSeasoningBatch(new HashSet<>(idList));

        final String outputFilePath = "all_recipe.csv";
        ICsvListWriter writer = null;
        try {
            File file = new File(outputFilePath);
            if (file.exists()) {
                file.delete();
            }
            writer = new CsvListWriter(new FileWriter(outputFilePath),
                    CsvPreference.STANDARD_PREFERENCE);
            String[] header = new String[]{
                    "recipe_id", "recipe_style",
                    "recipe_taste", "ingredient", "seasoning"
            };
            writer.writeHeader(header);
            for (Long id: idList) {
                List<Object> record = Arrays.asList(
                        id, recipeStyleMap.getOrDefault(id, new QueryResult()).getValue(),
                        recipeTasteMap.getOrDefault(id, new QueryResult()).getValue(),
                        recipeIngredientMap.getOrDefault(id, new QueryResult()).getValue(),
                        recipeSeasoningMap.getOrDefault(id, new QueryResult()).getValue()
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
        return outputFilePath;
    }
}
