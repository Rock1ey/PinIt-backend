package org.leye.maven.pinitbackend.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/25 22:25
 */
@Getter
@Setter
@Embeddable
public class Location {
    private Double latitude;
    private Double longitude;

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location() {

    }
    // Getters and Setters
}
