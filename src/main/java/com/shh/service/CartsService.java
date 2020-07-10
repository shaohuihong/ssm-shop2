package com.shh.service;

import com.shh.entity.Product;

public interface CartsService {
    int add(int mid, int quantity, Product product) throws Exception;
}
