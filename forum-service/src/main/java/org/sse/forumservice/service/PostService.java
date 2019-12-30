package org.sse.forumservice.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sse.forumservice.dto.PostDTO;
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

    public PageInfo<PostDTO> getPageOfPost(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<PostDTO> posts = postMapper.getPostOrderByTime();
        return new PageInfo<>(posts);
    }

    public PageInfo<PostDTO> searchPageOfPost(int pageNum,int pageSize, String keyword){
        PageHelper.startPage(pageNum,pageSize);
        List<PostDTO> posts = postMapper.searchPostOrderByTime('%'+keyword+'%');
        return new PageInfo<>(posts);
    }

    public PostDTO getPostById(long id){
        return postMapper.getPostById(id);
    }

    public Long publishPost(Post post) {
        postMapper.insertPost(post);
        return post.getPostId();
    }
}
