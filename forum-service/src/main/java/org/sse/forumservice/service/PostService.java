package org.sse.forumservice.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sse.forumservice.mapper.PostMapper;
import org.sse.forumservice.model.Post;

import java.util.List;

/**
 * @author HPY
 */
@Service
public class PostService {
    @Autowired
    PostMapper postMapper;

    public PageInfo<Post> getPageOfPost(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Post> posts = postMapper.getPostOrderByTime();
        return new PageInfo<>(posts);
    }

    public PageInfo<Post> searchPageOfPost(int pageNum,int pageSize, String keyword){
        PageHelper.startPage(pageNum,pageSize);
        List<Post> posts = postMapper.searchPostOrderByTime(keyword);
        return new PageInfo<>(posts);
    }

    public Post getPostById(long id){
        return postMapper.getPostById(id);
    }
}
