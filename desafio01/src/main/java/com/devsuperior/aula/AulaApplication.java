package com.devsuperior.aula;

import com.devsuperior.aula.entities.Order;
import com.devsuperior.aula.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AulaApplication implements CommandLineRunner {

	@Autowired
	OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order;

		order = new Order(1034, 150.0, 20.0);
		showOrder(order);

		order = new Order(2282, 800.0, 10.0);
		showOrder(order);

		order = new Order(1309, 95.9, 0.0);
		showOrder(order);
	}

	private void showOrder(Order order) {
		System.out.println("Pedido código " + order.getCode());
		System.out.println("Valor total: R$ " + orderService.total(order));
	}
}
