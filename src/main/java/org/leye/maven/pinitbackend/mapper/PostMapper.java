package org.leye.maven.pinitbackend.mapper;

import org.leye.maven.pinitbackend.dto.PostDTO;
import org.leye.maven.pinitbackend.model.Image;
import org.leye.maven.pinitbackend.model.Post;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author leye
 * @version 1.0
 * @description: 用于将 Post 实体映射为 DTO
 * @date 2024/12/25 21:28
 */
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
        postDTO.setNickname(post.getUser().getNickname());
        postDTO.setAvatarUrl(post.getUser().getAvatar());
        postDTO.setLatitude(post.getLocation().getLatitude());
        postDTO.setLongitude(post.getLocation().getLongitude());
        return postDTO;
    }

}
