package com.codegym.service;
import com.codegym.model.Products;
import com.codegym.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImageService implements GeneralService<Products> {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void addImage(Products image) {
        imageRepository.addImage(image);
    }

    @Override
    public List<Products> findAll() {
        return imageRepository.findAll();
    }
}
