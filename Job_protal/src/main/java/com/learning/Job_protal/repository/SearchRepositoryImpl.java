package com.learning.Job_protal.repository;

import com.learning.Job_protal.model.Post;


import java.util.Arrays;

import com.mongodb.client.MongoClient;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;
import java.util.concurrent.TimeUnit;
import org.bson.Document; 
import com.mongodb.client.AggregateIterable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl  implements SearchRepository{

    @Autowired
    MongoClient mongoClient;

    @Override
    public List<Post> findByText(String text) {

        List<Post> posts = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("learning");
        MongoCollection<Document> collection = database.getCollection("users");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("techs", "desc", "profile"))
                        )
                ),
                new Document("$sort",
                        new Document("exp", 1)
                ),
                new Document("$limit", 5)
        ));

        // Convert Document → Post
        for (Document doc : result) {

            Post post = new Post();

            post.setProfile(doc.getString("profile"));
            post.setDesc(doc.getString("desc"));
            post.setExp(doc.getInteger("exp"));

            List<String> techList = (List<String>) doc.get("techs");
            post.setTechs(techList.toArray(new String[0]));

            posts.add(post);
        }

        return posts;
    }
}
