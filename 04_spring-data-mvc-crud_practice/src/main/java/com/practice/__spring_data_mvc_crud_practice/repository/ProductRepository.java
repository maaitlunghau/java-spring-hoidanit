package com.practice.__spring_data_mvc_crud_practice.repository;

import com.practice.__spring_data_mvc_crud_practice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
