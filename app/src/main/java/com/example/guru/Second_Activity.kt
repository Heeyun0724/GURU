package com.example.guru

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.guru.databinding.ActivitySecondBinding

private const val TAG_HOME = "fragment_home"
private const val TAG_MYPAGE = "fragment_mypage"
private const val TAG_REVIEW = "fragment_review"


class Second_Activity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_second)

        setFragment(TAG_HOME, HomeFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.myPageItem -> setFragment(TAG_MYPAGE, MypageFragment())
                R.id.myHomeItem -> setFragment(TAG_HOME, HomeFragment())
                R.id.writeReviewItem-> setFragment(TAG_REVIEW, ReviewFragment())
            }
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val mypage = manager.findFragmentByTag(TAG_MYPAGE)
        val home = manager.findFragmentByTag(TAG_HOME)
        val review = manager.findFragmentByTag(TAG_REVIEW)

        if (mypage != null){
            fragTransaction.hide(mypage)
        }

        if (home != null){
            fragTransaction.hide(home)
        }

        if (review != null) {
            fragTransaction.hide(review)
        }

        if (tag == TAG_MYPAGE) {
            if (mypage!=null){
                fragTransaction.show(mypage)
            }
        }
        else if (tag == TAG_HOME) {
            if (home != null) {
                fragTransaction.show(home)
            }
        }

        else if (tag == TAG_REVIEW){
            if (review != null){
                fragTransaction.show(review)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}