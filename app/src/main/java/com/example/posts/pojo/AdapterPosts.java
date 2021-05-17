package com.example.posts.pojo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.posts.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class AdapterPosts extends RecyclerView.Adapter<AdapterPosts.item_post> {
    Context mContext;

    ArrayList<PostsModel> mList=new ArrayList<>();

    public AdapterPosts(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public item_post onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_post, parent, false);
        item_post item_post = new item_post(view);
        return item_post;
    }

    @Override
    public void onBindViewHolder(@NonNull item_post holder, int position) {
        holder.userId.setText(mList.get(position).getUserId());
        holder.id.setText(mList.get(position).getId());
        holder.title.setText(mList.get(position).getTitle());
        holder.body.setText(mList.get(position).getBody());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setList(ArrayList<PostsModel> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    class item_post extends RecyclerView.ViewHolder {
        TextView userId, id, title, body;

        public item_post(@NonNull View itemView) {
            super(itemView);

            userId = itemView.findViewById(R.id.userId);
            id = itemView.findViewById(R.id.Id);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);

        }
    }
}
