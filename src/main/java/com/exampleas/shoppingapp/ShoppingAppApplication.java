package com.exampleas.shoppingapp;

import com.exampleas.shoppingapp.products.ProductModel;
import com.exampleas.shoppingapp.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ShoppingAppApplication {

	@Autowired
	private ProductRepository productRepository;

	@PostConstruct
	public void initialData() {
		int mockMinPrice = 20000;
		int mockMaxPrice = 40000;
		int mockPopularRateMinRange = 0;
		int mockPopularRateMaxRange = 100;
		double randomPrice = Math.floor(Math.random()*(mockMaxPrice-mockMinPrice+1)+mockMinPrice);
		double randomTotalPrice = (Math.floor(Math.random()*(mockMaxPrice-mockMinPrice+1)+mockMinPrice) * 10)/ 100;
		String mockProductPrice = Double.toString(randomPrice);
		String mockTotalPrice = Double.toString(randomTotalPrice);
		int randomPopularRate = (int)Math.floor(Math.random()*(mockPopularRateMaxRange-mockPopularRateMinRange+1)+mockPopularRateMinRange);

		//Create product
		ProductModel product1 = new ProductModel();
		product1.setId(1);
		product1.setName("Guitar 1");
		product1.setMain_image("Guitar_1.jpg");
		product1.setProduct_price(mockProductPrice);
		product1.setDiscount_percent("10%");
		product1.setTotal_price(mockTotalPrice);
		product1.setPopularRate(randomPopularRate);
		productRepository.save(product1);
	}

	public static void main(String[] args) {
		SpringApplication.run(ShoppingAppApplication.class, args);
		System.out.println("**********Application Start*************");
	}

}
