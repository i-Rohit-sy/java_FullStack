package com.learning.Job_protal.repository;

import com.learning.Job_protal.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {

}
