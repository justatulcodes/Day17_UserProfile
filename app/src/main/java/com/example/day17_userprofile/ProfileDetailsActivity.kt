//package com.example.day17_userprofile
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.recyclerview.widget.GridLayoutManager
//import com.example.day17_userprofile.adapter.PostListAdapter
//import com.example.day17_userprofile.data.userProfilesList
//import com.example.day17_userprofile.databinding.ActivityProfileDetailsBinding
//
//class ProfileDetailsActivity : AppCompatActivity() {
//    private lateinit var binding : ActivityProfileDetailsBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityProfileDetailsBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val layoutManager = GridLayoutManager(this, 2)
//
//        val data =  userProfilesList[0]
//
//        binding.tvFollowers.text = data.followers.toString()
//        binding.tvFollowing.text = data.following.toString()
//        binding.tvPosts.text = data.post.toString()
//        binding.profileBio.text = data.bio
//
//
//        val posts = userProfilesList[0].postsList
//        val adapter = PostListAdapter(posts)
//
//
//    }
//}