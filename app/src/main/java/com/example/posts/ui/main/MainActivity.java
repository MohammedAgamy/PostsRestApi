package com.example.posts.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.posts.R;
import com.example.posts.databinding.ActivityMainBinding;
import com.example.posts.pojo.AdapterPosts;
import com.example.posts.pojo.PostsModel;
import com.example.posts.ui.PostViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostViewModel postViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        iniView();
        getData();
    }


    private void iniView() {
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPosts();
    }


    private void getData() {
        AdapterPosts adapterPosts = new AdapterPosts(this);
        binding.recyclerPosts.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerPosts.setAdapter(adapterPosts);

        postViewModel.modelMutableLiveData.observe(this, new Observer<List<PostsModel>>() {
            @Override
            public void onChanged(List<PostsModel> postsModels) {
                adapterPosts.setList((ArrayList<PostsModel>) postsModels);
            }
        });
    }

}