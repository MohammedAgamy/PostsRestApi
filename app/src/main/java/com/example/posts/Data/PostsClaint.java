package com.example.posts.Data;

import com.example.posts.pojo.PostsModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class PostsClaint {
    private static final String BasUrl = "https://jsonplaceholder.typicode.com";
    private PostsInterface POSTS_INTERFACE;
    private static  PostsClaint Instance;

    public PostsClaint() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BasUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        POSTS_INTERFACE = retrofit.create(PostsInterface.class);


    }

    public static PostsClaint getInstance()
    {
        if(null == Instance)
        {
            Instance=new PostsClaint();

        }
        return Instance ;
    }

    public Call<List<PostsModel>> call() {
        return POSTS_INTERFACE.getPosts();
    }
}
