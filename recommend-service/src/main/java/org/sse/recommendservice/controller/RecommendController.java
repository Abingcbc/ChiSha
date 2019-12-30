package org.sse.recommendservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.sse.recommendservice.dto.RecommendRecipe;
import org.sse.recommendservice.service.RecommendService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * @author cbc
 */
@RestController
public class RecommendController {

    @Autowired
    RecommendService recommendService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/trainData/{limitNum}")
    public ResponseEntity<FileSystemResource> getTrainData(@PathVariable int limitNum) {
        String path = recommendService.getTrainData(limitNum);
        if (path == null) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok()
                .header("Content-Disposition", "train.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(new FileSystemResource(new File(path)));
    }

    @GetMapping("/recommend/{userId}")
    public RecommendRecipe getRecommendRecipe(@PathVariable long userId,
                                              HttpServletResponse response) {
        String path = recommendService.getUserTrainField(userId);
        if (path == null) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
        FileSystemResource resource = new FileSystemResource(new File(path));
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("file", resource);
        List<Long> recommendId = this.restTemplate.postForEntity("http://localhost:5000", param, List.class).getBody();
        return recommendService.getRecommendRecipe(recommendId);
    }

    @GetMapping("/allRecipe")
    public ResponseEntity<FileSystemResource> getAllRecipeTrainField() {
        String path = recommendService.getAllRecipeTrainField();
        if (path == null) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok()
                .header("Content-Disposition", "train.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(new FileSystemResource(new File(path)));
    }
}
