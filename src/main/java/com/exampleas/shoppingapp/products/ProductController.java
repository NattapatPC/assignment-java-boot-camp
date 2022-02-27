package com.exampleas.shoppingapp.products;

import com.exampleas.shoppingapp.products.Response.GetAllProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/api/products")
    public List<GetAllProductResponse> getAllProducts() {
        List<GetAllProductResponse> productResponse = productService.getAllProduct();

        return productResponse;
    }

    @GetMapping("/api/products/{id}")
    public Optional<ProductModel> getProductById(@PathVariable int id) {
        Optional<ProductModel> productResponse = productService.getProductDetail(id);

        return productResponse;
    }

    @GetMapping("/api/products/search/{name}")
    public GetAllProductResponse searchProduct(@PathVariable String name) {
        GetAllProductResponse productResponse = productService.searchProduct(name);

        return productResponse;
    }
}
