package org.leye.maven.pinitbackend.mapper;

import org.leye.maven.pinitbackend.dto.PostDTO;
import org.leye.maven.pinitbackend.model.Image;
import org.leye.maven.pinitbackend.model.Post;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

// 将Post实体类映射为DTO类
@Component
public class PostMapper {

    public PostDTO toDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setDescription(post.getDescription());
        postDTO.setImageUrls(post.getImages().stream()
                .map(Image::getImageUrl)
                .collect(Collectors.toList()));
        postDTO.setUserid(post.getUser().getId());
        postDTO.setUsername(post.getUser().getUsername());
        postDTO.setAvatarUrl(post.getUser().getAvatar());
        postDTO.setLatitude(post.getLocation().getLatitude());
        postDTO.setLongitude(post.getLocation().getLongitude());
        return postDTO;
    }

}
