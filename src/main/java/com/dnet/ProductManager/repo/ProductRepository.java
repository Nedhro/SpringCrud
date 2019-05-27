package com.dnet.ProductManager.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnet.ProductManager.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findAll();

}
