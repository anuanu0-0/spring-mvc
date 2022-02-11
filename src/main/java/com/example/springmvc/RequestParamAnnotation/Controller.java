package com.example.springmvc.RequestParamAnnotation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {
    static int ID = 1;
    // Using hashmaps instead of repository for simplicity
    public static Map<Integer, String> articleTopics = new HashMap();
    static {
        articleTopics.put(0, "GFG");
    }

    // Simple mapping
    @GetMapping("/api/v1/article")
    public ResponseEntity<String> getArticleTopic(@RequestParam Integer articleId) {
        // Search in map if not found return null;
        if(articleTopics.containsKey(articleId)) {
            return ResponseEntity.ok(articleId + " " + articleTopics.get(articleId));
        }

        return ResponseEntity.badRequest().body("Article doesnot exists");
    }

    // Specifying the request parameter name
    @PostMapping("api/v2/article")
    public ResponseEntity<String> postArticleTopic(@RequestParam("name") String articleName) {
        if(articleTopics.containsValue(articleName)){
            return ResponseEntity.badRequest().body("Article already exists");
        }

        int currentArticleID = ID++;
        articleTopics.put(currentArticleID, articleName);
        return ResponseEntity.ok("Saved : [" + currentArticleID + "," + articleTopics.get(currentArticleID) + "]");
    }

    // Default value for Request Parameters
    @GetMapping("/api/v3/article")
    public ResponseEntity<String> getArticleTopicOrDefault(@RequestParam(defaultValue = "0")Integer articleId) {
        if(!articleTopics.containsKey(articleId)) {
            // If the provided articleId is not present in Database, then also return default
            articleId = 0;
        }
        // If no value is provided for id then return default
        return ResponseEntity.ok(articleId + " " + articleTopics.get(articleId));
    }

    // Mapping a multivalue Container
    @PostMapping("/api/v4/article")
    public ResponseEntity<String> getMultipleArticleTopics(@RequestParam List<String> names) {
        for(String topic : names) {
            articleTopics.put(ID++, topic);
        }
        return ResponseEntity.accepted().body("Saved : " + names);
    }

}
