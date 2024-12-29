package org.leye.maven.pinitbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String bio;
    private String avatar;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Post> posts; // 用户发布的帖子

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Favorite> favorites;  // 用户的收藏记录
}
