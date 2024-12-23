package org.leye.maven.pinitbackend.repository;

import org.leye.maven.pinitbackend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/24 03:52
 */
public interface ImageRepository extends JpaRepository<Image, Long> {
}
