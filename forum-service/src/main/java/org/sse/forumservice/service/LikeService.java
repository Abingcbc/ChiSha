package org.sse.forumservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sse.forumservice.mapper.LikeMapper;
import org.sse.forumservice.model.UserLikePost;

/**
 * @author HPY
 */
@Service
public class LikeService {

    @Autowired
    LikeMapper likeMapper;

    public boolean userLikePost(long userId, long postId){
        UserLikePost userLikePost = likeMapper.getLikeByUserAndPost(userId,postId);
        if(userLikePost == null){
            return likeMapper.insertLike(userId, postId);
        }
        else if(userLikePost.getIsLike() == 0){
            return likeMapper.setIsLike(userId,postId,1);
        }
        else {
            return false;
        }
    }

    public boolean userUnLikePost(long userId, long postId){
        UserLikePost userLikePost = likeMapper.getLikeByUserAndPost(userId,postId);
        if(userLikePost == null){
            return false;
        }
        else if(userLikePost.getIsLike() == 1){
            return likeMapper.setIsLike(userId,postId,0);
        }
        else {
            return false;
        }
    }

    public boolean checkIsLike(long userId,long postId){
        UserLikePost userLikePost = likeMapper.getLikeByUserAndPost(userId, postId);
        if(userLikePost == null){
            return false;
        }
        else if(userLikePost.getIsLike()==0){
            return false;
        }
        else{
            return true;
        }
    }
}
