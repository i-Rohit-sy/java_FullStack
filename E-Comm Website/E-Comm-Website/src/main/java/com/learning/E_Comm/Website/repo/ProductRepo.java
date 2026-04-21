package com.learning.E_Comm.Website.repo;

import com.learning.E_Comm.Website.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
}
