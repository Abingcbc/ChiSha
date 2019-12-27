package org.sse.recommendservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.sse.recommendservice.service.RecommendService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

/**
 * @author cbc
 */
@RestController
public class RecommendController {

    @Autowired
    RecommendService recommendService;

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
}
