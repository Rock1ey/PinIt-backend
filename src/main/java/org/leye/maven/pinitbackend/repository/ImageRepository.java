package org.leye.maven.pinitbackend.repository;

import org.leye.maven.pinitbackend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
