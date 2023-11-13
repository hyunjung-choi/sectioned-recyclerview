package com.example.hyunjung.sectionedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hyunjung.sectionedrecyclerview.adapter.MemberAdapter
import com.example.hyunjung.sectionedrecyclerview.data.Member
import com.example.hyunjung.sectionedrecyclerview.data.SectionModel
import com.example.hyunjung.sectionedrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val sectionModelList = ArrayList<SectionModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView() {
        loadData()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        binding.rvMainSection.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MemberAdapter(sectionModelList)
        }
    }

    private fun loadData() {
        val firstGroup = "샤이니"
        val firstGroupMembers = ArrayList<Member>()
        firstGroupMembers.add(Member("온유", "1989.12.14", "ISFP"))
        firstGroupMembers.add(Member("종현", "1990.04.08", "CUTE"))
        firstGroupMembers.add(Member("키", "1991.09.23", "ENTJ"))
        firstGroupMembers.add(Member("민호", "1991.12.09", "ESFP"))
        firstGroupMembers.add(Member("태민", "1993.07.18", "INFP"))

        val secondGroup = "스트레이키즈"
        val secondGroupMembers = ArrayList<Member>()
        secondGroupMembers.add(Member("방찬", "1989.12.14", "ISFP"))
        secondGroupMembers.add(Member("종현", "1990.04.08", "CUTE"))
        secondGroupMembers.add(Member("키", "1991.09.23", "ENTJ"))
        secondGroupMembers.add(Member("민호", "1991.12.09", "ESFP"))
        secondGroupMembers.add(Member("태민", "1993.07.18", "INFP"))

        val thirdGroup = "온앤오프"
        val thirdGroupMembers = ArrayList<Member>()
        thirdGroupMembers.add(Member("효진", "1989.12.14", "ISFP"))
        thirdGroupMembers.add(Member("이션", "1990.04.08", "CUTE"))
        thirdGroupMembers.add(Member("제이어스", "1991.09.23", "ENTJ"))
        thirdGroupMembers.add(Member("와이엇", "1991.12.09", "ESFP"))
        thirdGroupMembers.add(Member("MK", "1993.07.18", "INFP"))
        thirdGroupMembers.add(Member("유", "1993.07.18", "INFP"))

        sectionModelList.add(SectionModel(firstGroup, firstGroupMembers))
        sectionModelList.add(SectionModel(secondGroup, secondGroupMembers))
        sectionModelList.add(SectionModel(thirdGroup, thirdGroupMembers))
    }
}