package com.example.be_spring.dto.movie;

import java.util.Date;

public interface MovieProjection {
    Integer getId();

    String getName();

    Date getStartDay();

    String getImage();
}
