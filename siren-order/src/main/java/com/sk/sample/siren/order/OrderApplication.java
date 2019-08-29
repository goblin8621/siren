package com.sk.sample.siren.order;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.sk.sample.siren.order.domain.model.Order;
import com.sk.sample.siren.order.domain.repository.OrderRepository;
import com.sk.sample.siren.order.domain.service.OrderService;

@SpringBootApplication
@EnableFeignClients
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner createSampleData(OrderRepository orderRepository, @Qualifier("orderLogic") OrderService orderService) {	
		return (args) -> {
			//Order(Long accountId, Long storeId, Long productId, Integer qty)

/*			
			displayOrders(orderRepository);

			Order order1 = new Order(1L, 1L, 2L, 2);
			orderRepository.save(order1);
			orderService.purchase(order1.getId());
			
			Order order2 = new Order(1L, 1L, 1L, 5);
			orderRepository.save(order2);
			orderService.purchase(order2.getId());
			
			
			Order order3 = new Order(1L, 1L, 1L, 20);
			orderRepository.save(order3);
			orderService.purchase(order3.getId());			

			displayOrders(orderRepository);
			
			orderRepository.delete(3L);
			
			displayOrders(orderRepository);
*/			
		};
	}
	
	
	public void displayOrders(OrderRepository orderRepository) {
		System.out.println("OrderRepository start ******************************************");
		
		Iterable<Order> orderList = orderRepository.findAll();
		for(Order order : orderList) {
			System.out.println(order.toString());	
		}
		
		System.out.println("OrderRepository end ******************************************");
	}	

}