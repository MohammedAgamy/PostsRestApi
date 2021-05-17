package com.example.posts.Data;


import com.example.posts.pojo.PostsModel;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface PostsInterface {
    @GET("/posts")
    public Call<List<PostsModel>> getPosts();
}
