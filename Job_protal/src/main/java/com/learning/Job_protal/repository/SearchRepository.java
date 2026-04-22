package com.learning.Job_protal.repository;

import com.learning.Job_protal.model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
