package com.example.posts.ui;

import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.posts.Data.PostsClaint;
import com.example.posts.pojo.PostsModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class PostViewModel extends ViewModel {

    public MutableLiveData<List<PostsModel>> modelMutableLiveData=new MutableLiveData<>();

    public void getPosts()
    {
        PostsClaint.getInstance().call().enqueue(new Callback<List<PostsModel>>() {
            @Override
            public void onResponse(Call<List<PostsModel>> call, Response<List<PostsModel>> response) {
               modelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostsModel>> call, Throwable t) {
                Log.d("tag" , t.getMessage());
            }
        });
    }
}
