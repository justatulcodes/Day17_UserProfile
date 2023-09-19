package com.example.day17_userprofile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.day17_userprofile.databinding.PostItemviewBinding

class PostListAdapter(private val postList: List<Int>)
    :RecyclerView.Adapter<PostListAdapter.ViewHolder>(){
    class ViewHolder (binding: PostItemviewBinding): RecyclerView.ViewHolder(binding.root) {
        val ivPost = binding.ivPostImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PostItemviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageId = postList[position]
        holder.ivPost.setImageResource(imageId)
    }

}