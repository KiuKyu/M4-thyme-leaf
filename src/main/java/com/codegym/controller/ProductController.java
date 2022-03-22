package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    public static final String MESSAGE_FAILED = "Something is left";
    @Autowired
    private IProductService productService;

    @GetMapping("/products/list")
    public ModelAndView showListProduct() {
        ModelAndView modelAndView = new ModelAndView("/product/list");
        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "/product/add";
    }

    @PostMapping("/add")
    public ModelAndView addProduct(
            @RequestParam String name,
            @RequestParam double price,
            @RequestParam String description,
            @RequestParam String image
    ) {
        ModelAndView modelAndView = new ModelAndView("/product/add");
        Product product = new Product(name, price, description, image);
        boolean isSuccessed = productService.create(product);
        String message = isSuccessed ? "Successfully added 1 product" : MESSAGE_FAILED;
        modelAndView.addObject("isSuccessed", isSuccessed);
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Product product = productService.findProductById(id);
        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable int id, @ModelAttribute Product product) {
        boolean isSuccessed = productService.updateById(id, product);
        String message = isSuccessed ? "Successfully update 1 product" : MESSAGE_FAILED;

        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("isSuccessed", isSuccessed);
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
