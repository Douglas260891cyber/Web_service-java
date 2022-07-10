package com.example.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.entities.Order;
import com.example.curso.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResources {

	@Autowired
	private OrderService service;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) throws Exception {
		Order order = service.FindById(id);

		if (order == null)
			throw new Exception("Exception message");

		return ResponseEntity.ok().body(order);
	}
}
