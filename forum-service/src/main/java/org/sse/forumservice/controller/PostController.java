package org.sse.forumservice.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sse.forumservice.dto.SearchDTO;
import org.sse.forumservice.model.Post;
import org.sse.forumservice.service.PostService;

/**
 * @author HPY
 */
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/get-list-by-time")
    public PageInfo<Post> getPageOfPostOrderByTime(@RequestParam("page-num") int pageNum,
                                                   @RequestParam("page-size") int pageSize){
        return postService.getPageOfPost(pageNum, pageSize);
    }

    @PostMapping("/search-list-by-time")
    public PageInfo<Post> getPageOfPostOrderByTime(@RequestParam("page-num") int pageNum,
                                                   @RequestParam("page-size") int pageSize,
                                                   @RequestBody SearchDTO searchDTO){
        return postService.searchPageOfPost(pageNum,pageSize,searchDTO.getKeyword());
    }

    @GetMapping("/get-post/{id}")
    public Post getPageOfPostOrderByTime(@PathVariable long id){
        return postService.getPostById(id);
    }
}
