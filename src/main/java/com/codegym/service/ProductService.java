package com.codegym.service;

import com.codegym.DAO.product.IProductDAO;
import com.codegym.model.Product;
import com.codegym.service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "iPhone 13 128GB", 21990000, "Red - New", "https://phucanhcdn.com/media/product/44556_iphone_13_red.jpg"));
        products.add(new Product(2, "iPhone 12 Mini", 16950000, "Black - New",
                "https://cdn.hoanghamobile.com/i/preview/Uploads/2020/11/06/apple-iphone-12-mini-2.png"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    public int findProductById(int id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public Product findById(int id) {
        int index = findProductById(id);
        if (index != -1) {
            return products.get(index);
        }
        return null;
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void updateById(int id, Product product) {
        int index = findProductById(id);
        products.remove(index);
    }

    @Override
    public void removeById(int id, Product product) {

    }
}
