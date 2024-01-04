package com.example.hyunjung.sectionedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hyunjung.sectionedrecyclerview.adapter.MemberAdapter
import com.example.hyunjung.sectionedrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainActivityViewModel>()

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        binding.rvMainSection.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MemberAdapter(viewModel.items)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}