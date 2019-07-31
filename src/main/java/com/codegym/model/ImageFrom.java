package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class ImageFrom {

    private MultipartFile image;


    public ImageFrom() {
    }

    public ImageFrom(MultipartFile image) {
        this.image = image;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
