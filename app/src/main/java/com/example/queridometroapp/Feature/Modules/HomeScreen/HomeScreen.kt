package com.example.queridometroapp.Feature.Modules.HomeScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.queridometroapp.Feature.Mock
import com.example.queridometroapp.Feature.Modules.Adapter.UsersCarouselRecyclerViewAdapter
import com.example.queridometroapp.Feature.Modules.SelectEmojiBottomSheet.SelectEmojiBottomSheet
import com.example.queridometroapp.databinding.ActivityHomescreenBinding
import java.util.*

class HomeScreen : AppCompatActivity() {

    private var _binding : ActivityHomescreenBinding? = null
    private val binding : ActivityHomescreenBinding get() = _binding!!
    lateinit var recyclerAdapter : UsersCarouselRecyclerViewAdapter
    private val viewModel : HomeScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomescreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponents()
    }

    override fun onResume() {
        super.onResume()

//        Timer().scheduleAtFixedRate(ScrollTimer(), 10, 10)

        viewModel.userName = intent.getStringExtra("userName").toString()
        viewModel.registerUserName()

        binding.btnSendEmoji.setOnClickListener{
            SelectEmojiBottomSheet().show(supportFragmentManager, "SelectEmojiBottomSheet")
        }

        recyclerAdapter.itemList = Mock.getUsersList()

        viewModel.userList.observe(this){
            Log.d("SocketListenerUser", "onResume: ")
        }
    }

    private fun initComponents() {
        recyclerAdapter = UsersCarouselRecyclerViewAdapter()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvUsers.layoutManager = layoutManager
        binding.rvUsers.adapter = recyclerAdapter
    }

    inner class ScrollTimer() : TimerTask() {
        override fun run() {
            this@HomeScreen.runOnUiThread(object : Runnable{
                override fun run() {
                    binding.rvUsers.scrollBy(0,1)
                }
            })
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}