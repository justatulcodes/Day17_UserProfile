package com.example.day17_userprofile.data

import com.example.day17_userprofile.R

class UserData (
    val name: String,
    val bio: String,
    val following: Int,
    val followers: Int,
    val post: Int,
    val postsList: List<Int>,
    val profilePic: Int
)

val userProfilesList = listOf(
    UserData(
        name = "Alex Heng",
        bio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas id tellus ipsum. Phasellus ullamcorper sapien sit amet tempor imperdiet. Sed ultricies sem sem, at tristique est aliquet in.",
        followers = 434,
        following = 34,
        post = 99,
        postsList = listOf(R.drawable.boy1_2, R.drawable.boy1_3, R.drawable.boy1_4,
            R.drawable.boy1_5, R.drawable.boy1_1),
        profilePic = R.drawable.boy1_1
    ),
    UserData(
        name = "Ajoy Shixong",
        bio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas id tellus ipsum. Phasellus ullamcorper sapien sit amet tempor imperdiet. Sed ultricies sem sem, at tristique est aliquet in.",
        followers = 294,
        following = 89,
        post = 46,
        postsList = listOf(R.drawable.girl1_2, R.drawable.girl1_3, R.drawable.girl1_4,
            R.drawable.girl1_5, R.drawable.girl1_6, R.drawable.girl1_1),
        profilePic = R.drawable.girl1_1
    ),
    UserData(
        name = "James Smith",
        bio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas id tellus ipsum. Phasellus ullamcorper sapien sit amet tempor imperdiet. Sed ultricies sem sem, at tristique est aliquet in.",
        followers = 800,
        following = 200,
        post = 150,
        postsList = listOf(R.drawable.boy2_1, R.drawable.boy2_2, R.drawable.boy2_3,
            R.drawable.boy2_4,),
        profilePic = R.drawable.boy2_1
    ),
    UserData(
        name = "Sophia Johnson",
        bio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas id tellus ipsum. Phasellus ullamcorper sapien sit amet tempor imperdiet. Sed ultricies sem sem, at tristique est aliquet in.",
        followers = 1200,
        following = 350,
        post = 220,
        postsList = listOf(R.drawable.girl2_5, R.drawable.girl2_2, R.drawable.girl2_3,
            R.drawable.girl2_4, R.drawable.girl2_5, R.drawable.girl2_6),
        profilePic = R.drawable.girl2_1
    )
)


