package com.test.firstrestapi;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("aliens")
public class MyResource {
    MyClassRepo repo = new MyClassRepo();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MyClass> getMyClass(){
        System.out.println("Get myClass");
        return repo.getMyClass();
    }

    @POST
    @Path("alien")
    public MyClass createRec(MyClass m1){
        System.out.println(m1);
        repo.create(m1);
        return m1;
    }
}
