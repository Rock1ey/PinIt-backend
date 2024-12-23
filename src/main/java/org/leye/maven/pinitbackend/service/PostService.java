package org.leye.maven.pinitbackend.service;

import org.leye.maven.pinitbackend.model.Post;
import org.leye.maven.pinitbackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author leye
 * @version 1.0
 * @description: 业务逻辑层，处理帖子的创建、查询等
 * @date 2024/12/23 21:59
 */
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getPosts(String title) {
        return postRepository.findByTitleContaining(title);
    }
}
