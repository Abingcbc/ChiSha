package org.sse.forumservice.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sse.forumservice.service.LikeService;
import org.w3c.dom.ls.LSException;

/**
 * @author HPY
 */
@RestController
@RequestMapping("/like")
public class LikeController {
    @Autowired
    LikeService likeService;

    @GetMapping("/check")
    boolean checkIsLike(@RequestParam("user-id") long userId, @RequestParam("post-id") long postId){
        return likeService.checkIsLike(userId,postId);
    }

    @GetMapping("/like-post")
    boolean userLikePost(@RequestParam("user-id") long userId,
                         @RequestParam("post-id") long postId){
        return likeService.userLikePost(userId, postId);
    }

    @GetMapping("/unlike-post")
    boolean userUnLikePost(@RequestParam("user-id") long userId,
                         @RequestParam("post-id") long postId){
        return likeService.userUnLikePost(userId, postId);
    }
}
