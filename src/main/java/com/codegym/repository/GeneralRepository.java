package com.codegym.repository;

import java.util.List;

public interface GeneralRepository<T> {
    void addImage(T t);
    List<T> findAll();
}
