package com.sk.sample.siren.product;

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
//			executeExample2(accountRepository);
//			executeExample3(accountRepository);
//			executeExample4(accountRepository);
//			executeExample5(accountRepository);
//			executeExample6(accountRepository);
//			executeExample7(accountRepository);
		};
	}
	
	
	public void insertProducts(ProductRepository productRepository) {
		Product product1 = new Product(1L, "아메리카노", 3000, 10);
		product1.setMisc("아메리카노입니다.");
		productRepository.save(product1);
		
		Product product2 = new Product(1L, "라떼", 3000, 15);
		product2.setMisc("맛있는 라떼.");
		productRepository.save(product2);
		
		Product product3 = new Product(1L, "카페오카", 4500, 5);
		product3.setMisc("향긋한 카페모카.");
		productRepository.save(product3);
		
		Product product4 = new Product(1L, "아이스티", 2800, 10);
		product4.setMisc("시원한 아이스티.....");
		productRepository.save(product4);
		
		Product product5 = new Product(1L, "에스프레소", 2000, 3);
		product5.setMisc("진한 에스프레소....");
		productRepository.save(product5);		
	}
	

	
	public void displayProducts(ProductRepository productRepository) {
		System.out.println("ProductRepository start ******************************************");
		
		Iterable<Product> productList = productRepository.findAll();
		for(Product product : productList) {
			System.out.println(product.toString());	
		}
		
		System.out.println("ProductRepository end ******************************************");
	}
	

	/*	
	public void executeExample2(ProductRepository productRepository) {
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
