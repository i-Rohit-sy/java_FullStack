package com.learning.springbootproject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlienRepo extends CrudRepository<Aliens,Integer> {


}
