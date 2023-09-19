package com.example.day17_userprofile

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.day17_userprofile.data.UserData
import com.example.day17_userprofile.data.userProfilesList
import com.example.day17_userprofile.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

//https://dribbble.com/shots/7262185-User-Profile-006-DailyUI/attachments/221932?mode=media

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  var bottomSheetBehavior : BottomSheetBehavior<*>? = null
    private var currentProfileIndex : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpBottomSheet(binding)
        setNewProfile(currentProfileIndex)
        gestureSetup(binding)

    }

    fun setNewProfile(index: Int) {

        val profile = userProfilesList[index%userProfilesList.size]
        setUpProfileInView(profile, binding)
        val prominentColor = getMostProminentColor(this,profile.profilePic)
        setStatusBarColorAndAppearance(prominentColor, false)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun gestureSetup(binding: ActivityMainBinding) {
        binding.root.setOnTouchListener(@SuppressLint("ClickableViewAccessibility")
        object : OnSwipeTouchListener(this@MainActivity){
            override fun onSwipeRight(): Boolean {
                if(currentProfileIndex == 0){
                    currentProfileIndex = 4
                }
                currentProfileIndex -= 1
                setNewProfile(currentProfileIndex)
                return true
            }

            override fun onSwipeLeft(): Boolean {
                currentProfileIndex += 1
                setNewProfile(currentProfileIndex)
                return true
            }

        })
    }

    private fun setUpProfileInView(profile: UserData, binding: ActivityMainBinding) {

        val userName = findViewById<TextView>(R.id.user_name)
        val bio = findViewById<TextView>(R.id.profile_bio)
        val followingCount = findViewById<TextView>(R.id.tv_following)
        val followersCount = findViewById<TextView>(R.id.tv_followers)
        val postsCount = findViewById<TextView>(R.id.tv_posts)

        val post1 = findViewById<ImageView>(R.id.iv_post_image1)
        val post2 = findViewById<ImageView>(R.id.iv_post_image2)
        val post3 = findViewById<ImageView>(R.id.iv_post_image3)
        val post4 = findViewById<ImageView>(R.id.iv_post_image4)


        userName.text = profile.name
        bio.text = profile.bio
        followingCount.text = profile.following.toString()

        if(profile.followers > 1000) {
            val text = "${ profile.followers / 1000 }K"
            followersCount.text = text
        }else{
            followersCount.text = profile.followers.toString()
        }

        postsCount.text = profile.post.toString()

        val posts = profile.postsList

        post1.setImageResource(posts[0])
        post2.setImageResource(posts[1])
        post3.setImageResource(posts[2])
        post4.setImageResource(posts[3])

        binding.ivProfilePic.setImageResource(profile.profilePic)

    }

    private fun setUpBottomSheet(binding: ActivityMainBinding) {
        val bottomSheet: View = findViewById(R.id.bottom_profile_sheet)
        binding.ivProfilePic.setImageResource(userProfilesList[0].profilePic)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        (bottomSheetBehavior as BottomSheetBehavior<*>).setBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {}
            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    }

    fun Activity.setStatusBarColorAndAppearance(statusBarColor: String, isLight: Boolean ) {
        try {
            window.statusBarColor = (Color.parseColor(statusBarColor))// Or we can use from resource color:  ContextCompat.getColor(mContext, R.color.colorPrimary)
            WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = isLight
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getMostProminentColor(context: Context, imageResId: Int): String {
        // Load the image from the drawable resource
        val bitmap: Bitmap = BitmapFactory.decodeResource(context.resources, imageResId)

        // Scale down the bitmap for efficiency
        val scaledBitmap: Bitmap = Bitmap.createScaledBitmap(bitmap, 1, 1, false)

        // Extract the pixel color at (0, 0)
        val pixelColor: Int = scaledBitmap.getPixel(0, 0)

        // Convert the color to hexadecimal format
        val hexColor: String = String.format("#%06X", 0xFFFFFF and pixelColor)

        // Return the most prominent color in hexadecimal format
        return hexColor
    }
}