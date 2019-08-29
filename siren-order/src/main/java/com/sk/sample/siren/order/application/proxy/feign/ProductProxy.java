package com.sk.sample.siren.order.application.proxy.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sk.sample.siren.order.application.proxy.feign.dto.product.Product;

@Service
public class ProductProxy {
 
	@Autowired
	private ProductClient productClient;
	
	
	public Product findProduct(Long id) {
		Product content = productClient.findProduct(id).getContent();
		content.setId(id);
		return content;
	}
	
	public Product productsUpdate(Long id, Product product) {
		return productClient.productsUpdate(id, product);
	}	

/*	
	public Collection<Product> findAllProducts() {
		return productClient.findAllProducts().getContent();
	}
	
	public Collection<Product> findAllProducts(int size) {
		return productClient.findAllProducts(size).getContent();
	}
	
	public Product findProductByName(String name) {
		return productClient.findProduct(name);
	}
	
	public Product productsUpdate(Long id, Product product) {
		return productClient.productsUpdate(id, product);
	}
*/		


	@FeignClient(name="products", url="http://localhost:11002", configuration=FeignClientConfiguration.class)
	interface ProductClient {
		
		@GetMapping("products/{id}")
		Resource<Product> findProduct(@PathVariable("id") Long id);
		
		@PutMapping("products/{id}")
		Product productsUpdate(@PathVariable("id") Long id, @RequestBody Product product);		

/*		
		@GetMapping("products")
		Resources<Product> findAllProducts();
		
		@GetMapping("products")
		Resources<Product> findAllProducts(@RequestParam("size") int size);
		
		@GetMapping("products/search/findByName")
		Product findProduct(@RequestParam(value="name", required=true) String name);
		
		@PutMapping("products/{id}")
		Product productsUpdate(@PathVariable("id") Long id, @RequestBody Product product);
*/
	}
}

