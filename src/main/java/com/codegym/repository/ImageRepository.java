package com.codegym.repository;
import com.codegym.model.Products;

import java.util.ArrayList;
import java.util.List;

public class ImageRepository implements GeneralRepository<Products> {
   private ArrayList<Products> imageList = new ArrayList<>();

    @Override
    public void addImage(Products image) {
        imageList.add(image);
    }

    @Override
    public List<Products> findAll() {
        return imageList;
    }
}
