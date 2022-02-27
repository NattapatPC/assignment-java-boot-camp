package com.exampleas.shoppingapp.products;

import com.exampleas.shoppingapp.products.Exception.NotFoundException;
import com.exampleas.shoppingapp.products.Response.GetAllProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<GetAllProductResponse> getAllProduct() {
        List<ProductModel> result = productRepository.findAll();
        List<GetAllProductResponse> listGetAllProductResponse = new ArrayList<GetAllProductResponse>();
        GetAllProductResponse resultResponseProductItem = new GetAllProductResponse();
        for(ProductModel productItem:result){
            resultResponseProductItem.setId(productItem.getId());
            resultResponseProductItem.setName(productItem.getName());
            resultResponseProductItem.setMain_image(productItem.getMain_image());
            resultResponseProductItem.setProduct_price(productItem.getProduct_price());
            resultResponseProductItem.setDiscount_percent(productItem.getDiscount_percent());
            resultResponseProductItem.setTotal_price(productItem.getTotal_price());
            resultResponseProductItem.setPopularRate(productItem.getPopularRate());
            listGetAllProductResponse.add(resultResponseProductItem);
        }

        if (listGetAllProductResponse.isEmpty()) {
            throw new NotFoundException("Products not found");
        }

        return listGetAllProductResponse;
    }

    public GetAllProductResponse searchProduct(String name) {
        List<ProductModel> result = productRepository.findByNameLike("%"+name+"%");
        List<GetAllProductResponse> listGetAllProductResponse = new ArrayList<GetAllProductResponse>();
        GetAllProductResponse resultResponseProductItem = new GetAllProductResponse();

        for(ProductModel productItem:result){
            resultResponseProductItem.setId(productItem.getId());
            resultResponseProductItem.setName(productItem.getName());
            resultResponseProductItem.setMain_image(productItem.getMain_image());
            resultResponseProductItem.setProduct_price(productItem.getProduct_price());
            resultResponseProductItem.setDiscount_percent(productItem.getDiscount_percent());
            resultResponseProductItem.setTotal_price(productItem.getTotal_price());
            resultResponseProductItem.setPopularRate(productItem.getPopularRate());
            listGetAllProductResponse.add(resultResponseProductItem);
        }

        if (listGetAllProductResponse.isEmpty()) {
            throw new NotFoundException("Search product keyword "+name+" Not found");
        }

        return resultResponseProductItem;
    }

    public Optional<ProductModel> getProductDetail(int id) {
        Optional<ProductModel> result = productRepository.findById(id);

        if (!result.isPresent()) {
            throw new NotFoundException("Get product id "+String.valueOf(id)+" Not found");
        }

        return result;
    }
}
