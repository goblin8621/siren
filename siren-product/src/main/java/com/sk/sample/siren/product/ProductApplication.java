//productapplication.java
package com.sk.sample.siren.product;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.sk.sample.siren.product.domain.model.Product;
import com.sk.sample.siren.product.domain.repository.ProductRepository;

@SpringBootApplication
@EnableHypermediaSupport(type=EnableHypermediaSupport.HypermediaType.HAL)
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner execSampleCode(ProductRepository accountRepository) {	
		return (args) -> {
			insertProducts(accountRepository);
			displayProducts(accountRepository);
//			
			executeExample2(accountRepository);
			executeExample3(accountRepository);
			executeExample4(accountRepository);
			executeExample5(accountRepository);
//			executeExample6(accountRepository);
//			executeExample7(accountRepository);
		};
	}
	
	
	public void insertProducts(ProductRepository productRepository) {
		Product product1 = new Product(1L, "아메리카노", 3000, 11);
		product1.setMisc("아메리카노 입니다.");
		productRepository.save(product1);
		
		Product product2 = new Product(1L, "카페라떼", 3000, 15);
		product2.setMisc("카페라떼 입니다.");
		productRepository.save(product2);
		
		Product product3 = new Product(1L, "카페오카", 4500, 5);
		product3.setMisc("카페모카 입니다.");
		productRepository.save(product3);
		
		Product product4 = new Product(1L, "아이스티", 2800, 10);
		product4.setMisc("아이스티 입니다.");
		productRepository.save(product4);
		
		Product product5 = new Product(1L, "에스프레소", 2000, 3);
		product5.setMisc("에스프레소 입니다.");
		productRepository.save(product5);		
		
		Product product6 = new Product(2L, "아이스아메리카노", 3500, 15);
		product6.setMisc("아이스아메리카노 입니다.");
		productRepository.save(product6);
		
		Product product7 = new Product(2L, "아이스카페라떼", 3500, 10);
		product7.setMisc("아이스카페라떼 입니다.");
		productRepository.save(product7);
		
		Product product8 = new Product(2L, "아이스카페오카", 4900, 15);
		product8.setMisc("아이스카페오카 입니다.");
		productRepository.save(product8);
		
		Product product9 = new Product(2L, "밀크티", 2900, 17);
		product9.setMisc("밀크티 입니다.");
		productRepository.save(product9);
		
		Product product10 = new Product(2L, "에스프레소", 2000, 13);
		product10.setMisc("에스프레소 입니다.");
		productRepository.save(product10);	
	}
	

	
	public void displayProducts(ProductRepository productRepository) {
		System.out.println("ProductRepository start ******************************************");
		
		Iterable<Product> productList = productRepository.findAll();
		for(Product product : productList) {
			System.out.println(product.toString());	
		}
		
		System.out.println("ProductRepository end ******************************************");
	}
	


	public void executeExample2(ProductRepository productRepository) {
		Product product = productRepository.findByName("아메리카노");		//아메리카노를 찾아라
		product.setPrice(25000);
		productRepository.save(product);
		displayProducts(productRepository);
	}
	
	public void executeExample3(ProductRepository productRepository) {
		Product product = productRepository.findByName("밀크티");		//아메리카노를 찾아라
		productRepository.delete(product);
		displayProducts(productRepository);
	}
	 
	public void executeExample4(ProductRepository productRepository) {
		Product product = productRepository.findByName("아이스아메리카노");		//아메리카노를 찾아라
		product.setStock(1111);
		productRepository.save(product);
		displayProducts(productRepository);
	}
	
	public void executeExample5(ProductRepository productRepository) {
		List<Product> product =  productRepository.findByStoreId(1L);	//1번 매장은?

		System.out.println("Result: " + product.toString());
	}
	/*	
	public void executeExample5(ProductRepository productRepository) {
		List<Product> product =  productRepository.findByPriceValueGreaterThanEqual(3000);	//아메리카노를 찾아라

		System.out.println("Result: " + product.toString());
	}

	 * 
	 * 	public void executeExample2(ProductRepository productRepository) {
		Product product = productRepository.findByName("Iron Man");
		
		product.setPrice(new Money(25000));
		productRepository.save(product);
		
		displayProducts(productRepository);
	}
	
	public void executeExample3(ProductRepository productRepository) {
		List<Product> product = productRepository.findByProductDescriptionSizeType(SizeType.M);
		System.out.println("Result: " + product.toString());
	}
	
	public void executeExample4(ProductRepository productRepository) {
		List<Product> product = productRepository.findByProductDescriptionColorType(ColorType.BLUE);
		System.out.println("Result: " + product.toString());
	}
	
	public void executeExample5(ProductRepository productRepository) {
		List<Product> product = productRepository.findByPriceValueGreaterThanEqual(17000);
		System.out.println("Result: " + product.toString());
		
		List<Product> product2 = productRepository.findAll(QProduct.product.price.value.goe(17000));
		System.out.println("Result2: " + product2.toString());
	}
	
	public void executeExample6(ProductRepository productRepository) {
		List<Product> product = productRepository.findByPriceValueLessThanEqual(21000);
		System.out.println("Result: " + product.toString());
		
		List<Product> product2 = productRepository.findAll(QProduct.product.price.value.loe(17000));
		System.out.println("Result2: " + product2.toString());
	}

	public void executeExample7(ProductRepository productRepository) {
		List<Product> product = productRepository.findByPriceValueGreaterThanAndPriceValueLessThan(10000, 20000);
		System.out.println("Result: " + product.toString());
		
		Predicate predicate = QProduct.product.price.value.gt(10000).and(
				              QProduct.product.price.value.lt(20000));
		List<Product> product2 = productRepository.findAll(predicate);
		System.out.println("Result2: " + product2.toString());
	}
*/

	
}
