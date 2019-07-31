package com.codegym.service;

import java.util.List;

public interface GeneralService<T> {
    void addImage(T t);
    List<T> findAll();
}
